package timepill.kakao.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.RequiredArgsConstructor;
import timepill.kakao.service.KakaoDAO;
import timepill.kakao.service.KakaoService;
import timepill.schedule.service.ScheduleService;
import timepill.schedule.service.ScheduleVO;
import timepill.user.service.UserVO;
import timepill.kakao.service.KakaoMessageTemplate;

@RequiredArgsConstructor
@Service("kakaoService")
public class KakaoServiceImpl implements KakaoService {

	private final HttpSession httpSession;

	/** httpCallService DI */
	@Autowired
	private HttpCallService httpCallService;

	/** kakaoDAO DI */
	@Autowired
	private KakaoDAO kakaoDAO;

	/** scheduleService DI */
	@Autowired
	ScheduleService scheduleService;

	@Value("${rest-api-key}")
	private String REST_API_KEY;

	@Value("${login-callback-uri}")
	private String LOGIN_CALLBACK_URI;

	@Value("${message-callback-uri}")
	private String MESSAGE_CALLBACK_URI;

	@Value("${authorize-uri}")
	private String AUTHORIZE_URI;

	@Value("${token-uri}")
	public String TOKEN_URI;

	@Value("${client-secret}")
	private String CLIENT_SECRET;

	@Value("${kakao-api-host}")
	private String KAKAO_API_HOST;

	/** 인가코드 요청 주소 */
	@Override
	public String goKakaoOAuth(String scope, String rediUri) throws Exception {
		String uri = "";
		if ("login-callback".equals(rediUri)) { // 로그인 요청
			uri = AUTHORIZE_URI + "?redirect_uri=" + LOGIN_CALLBACK_URI + "&response_type=code&client_id=" + REST_API_KEY;
		} else if ("message-callback".equals(rediUri)) { // 메세지 권한 요청
			uri = AUTHORIZE_URI + "?redirect_uri=" + MESSAGE_CALLBACK_URI + "&response_type=code&client_id=" + REST_API_KEY;
		}
		if (!scope.isEmpty())
			uri += "&scope=" + scope;
		System.out.println("scope : " + scope);
		System.out.println("uri : " + uri);
		return uri;
	}

	/** 액세스 토큰 요청 및 저장 */
	@Override
	public void callback(String code, String rediUri) throws Exception {
		String param = "";
		if ("login-callback".equals(rediUri)) { // 로그인 요청
			param = "grant_type=authorization_code&client_id=" + REST_API_KEY + "&redirect_uri=" + LOGIN_CALLBACK_URI + "&client_secret=" + CLIENT_SECRET + "&code="
					+ code;
		} else if ("message-callback".equals(rediUri)) { // 메세지 권한 요청
			param = "grant_type=authorization_code&client_id=" + REST_API_KEY + "&redirect_uri=" + MESSAGE_CALLBACK_URI + "&client_secret=" + CLIENT_SECRET + "&code="
					+ code;
		}
		String rtn = httpCallService.Call("POST", TOKEN_URI, "", param);
		JsonObject element = JsonParser.parseString(rtn).getAsJsonObject();
		String accessToken = element.get("access_token").getAsString();
		System.out.println("accessToken : " + accessToken);
		httpSession.setAttribute("token", accessToken); // 세션에 액세스 토큰 저장
	}

	/** 사용자 정보 가져오기 */
	@Override
	public String getProfile() throws Exception {
		String uri = KAKAO_API_HOST + "/v2/user/me";
		return httpCallService.CallwithToken("GET", uri, httpSession.getAttribute("token").toString());
	}

	/** 카카오 가입&로그인 핸들러 */
	@Override
	public String userAuthHandler() throws Exception {
		// 사용자 정보 가져오기
		String userInfo = getProfile();
		JsonObject userJson = JsonParser.parseString(userInfo).getAsJsonObject();
		String kakaoId = userJson.get("id").getAsString();
		String nickname = userJson.get("properties").getAsJsonObject().get("nickname").getAsString();
//		String email = userJson.get("kakao_account").getAsJsonObject().get("email").getAsString();

		UserVO vo = new UserVO();
		vo.setUserId("KAKAO_" + kakaoId);
		vo.setNickname(nickname);

		// 회원가입 여부 체크
		UserVO userInfoResult = kakaoDAO.duplicateCheckUser(vo);
		if (userInfoResult != null) {
			// 시큐리티 로그인
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userInfoResult, "",
					userInfoResult.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			httpSession.setAttribute("message", "로그인 완료");
		} else {
			vo.setKakaoToken(httpSession.getAttribute("token").toString());
			kakaoDAO.insertUser(vo);
			// 신규 유저 알람 생성
			ScheduleVO scheduleVO = new ScheduleVO();
			String[] hours = {"08", "12", "18", "22"};
			for (int i = 0; i < 4; i++) {
				scheduleVO.setUserId(vo.getUserId());
				scheduleVO.setAlarmType(i+1);
				scheduleVO.setAlarmTime(hours[i] + ":00");
				scheduleService.insertAlarm(scheduleVO);
			}
			httpSession.setAttribute("message", "회원가입 완료");
		}
		return "green";
	}

	/** 로그아웃 */
	@Override
	public void logout() throws Exception {
		String uri = KAKAO_API_HOST + "/v1/user/logout";
		if (httpSession.getAttribute("token") != null) {
			httpCallService.CallwithToken("POST", uri, httpSession.getAttribute("token").toString());
		}
	}

	/** 카카오 메세지 권한 동의 여부 체크 */
	@Override
	public boolean checkMessageAuth() throws Exception {
		String checkScopeUrl = KAKAO_API_HOST + "/v2/user/scopes";
		String response = httpCallService.CallwithToken("GET", checkScopeUrl, httpSession.getAttribute("token").toString(), null);
		JsonObject element = JsonParser.parseString(response).getAsJsonObject();
		JsonArray scopes = element.get("scopes").getAsJsonArray();

		System.out.println("체크 메세지 권한");
		for (int i = 0; i < scopes.size(); i++) {
			JsonObject scope = scopes.get(i).getAsJsonObject();
			if (scope.get("id").getAsString().equals("talk_message") && scope.get("agreed").getAsBoolean()) {
				return true;
			}
		}
		return false;
	}

	/** 카카오 메세지 보내기 */
	@Override
	public String message() throws Exception {
		String uri = KAKAO_API_HOST + "/v2/api/talk/memo/default/send";
		System.out.println("메세지 서비스 시작");
		return httpCallService.CallwithToken("POST", uri, httpSession.getAttribute("token").toString(), KakaoMessageTemplate.getDefaultMessageParam());
	}

}
