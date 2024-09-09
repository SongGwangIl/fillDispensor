package timepill.user.service;

import timepill.user.UserVO;

public interface UserService {
	//회원등록
	int add(UserVO vo);
	//로그인
	UserVO login(String userId);
	//사용가능한 아이디 확인
	String checkId(String userId);
	//사용자이름얻기
	String getUserName(String userId);
	//보호자이름얻기
	String getProtectorName(String userId);
	//보호자정보등록
	void addProtectorInfo(UserVO vo);
	//사용자정보등록
	void addUserInfo(UserVO vo);
	//사용자정보얻기
	UserVO getUserInfo(UserVO vo);
	//나의정보수정
	String updateMyInfo(UserVO uivo);
	//
	String getUserValid(String userId);

	String getUserSelect(String userId);
}