package kr.ac.kopo.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/cover")
	public String cover() {
		return "user/cover";
	}
	
	@RequestMapping(path = "/main", method = RequestMethod.GET)
	public String list() {
		
		return "user/main";
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String loginForm() {
		
		return "user/login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute UserVO vo, HttpSession session) {
			
		UserVO uvo = userService.login(vo);
		
		if ( uvo != null && vo.getUserId().equals(uvo.getUserId()) && 
				vo.getUserPwd().equals(uvo.getUserPwd()) ) 
		{
			//로그인 성공
			session.setAttribute("loginUser", uvo);
			return "redirect:/main";
		}
		// 로그인 실패	
		return "redirect:/login";
	}
	
	@RequestMapping(path = "/singup", method = RequestMethod.GET)
	public String addForm() {
		
		return "user/add";
	}
	
	@RequestMapping(path = "/singup", method = RequestMethod.POST)
	public String add(UserVO vo, HttpServletRequest request) {
		
		userService.add(vo);
		
		request.setAttribute("msg", "회원가입 되었습니다.");
		request.setAttribute("url", "/kopo/cover");		
		
		return "user/alert";			
	}
	
	@ResponseBody
	@RequestMapping(path = "/checkId", method = RequestMethod.POST)
	public String checkId(String userId) {
		String result = userService.checkId(userId);
		
		return result;
	}

}
