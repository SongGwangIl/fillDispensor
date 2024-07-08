package kr.ac.kopo.schedule;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.schedule.service.ScheduleService;
import kr.ac.kopo.schedule.service.ScheduleVO;
import kr.ac.kopo.user.UserVO;

@Controller("/schedule")
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	ScheduleService scheduleService;
	
	@GetMapping("/list.do")
	public String list(UserVO vo, Model model, HttpSession session) {
		UserVO loginUser = (UserVO)session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		List<ScheduleVO> lvo = scheduleService.list(userId);
		model.addAttribute("lvo",lvo);
		return "schedule/list";
	}
	
	@GetMapping("/add.do")
	public String addform() {
		return "schedule/add";
	}
	
	@PostMapping("/add.do")
	public String add(ScheduleVO vo, HttpSession session) {
		UserVO loginUser = (UserVO)session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		vo.setUserId(userId);
		
		int num = scheduleService.add(vo); 
		System.out.println(num + "개의 스케쥴 추가 완료");
		return "redirect:/schedule/list.do";
	}
//	
//	@PostMapping("/add.do")
//	public String add2(ScheduleVO vo, HttpSession session) {
//		System.out.println("11111");
//		return "redirect:/schedule/list.do";
//	}
//	

}
