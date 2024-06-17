package kr.ac.kopo.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import kr.ac.kopo.com.LoginVO;
import kr.ac.kopo.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(path = "/list.do", method = RequestMethod.GET)
	public String list(LoginVO vo, Model model) {
		List<LoginVO> lvo = userService.list(vo);
		model.addAttribute("lvo",lvo);
		
		return "user/list";
	}
	
	@RequestMapping(path = "/login.do", method = RequestMethod.GET)
	public String loginForm() {
		
		return "user/login";
	}

	@RequestMapping(path = "/login.do", method = RequestMethod.POST)
	public String login(@ModelAttribute("userId") LoginVO vo, HttpSession session) {
			
		LoginVO lvo = userService.selectList(vo);
		
		if ( lvo != null && vo.getUserId().equals(lvo.getUserId()) && 
				vo.getUserPass().equals(lvo.getUserPass()) ) 
		{
			//로그인 성공
			session.setAttribute("loginUser", lvo);
			return "redirect:/list.do";
		}
		// 로그인 실패	
		return "redirect:/login.do";
	}

}
