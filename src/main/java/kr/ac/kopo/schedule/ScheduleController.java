package kr.ac.kopo.schedule;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.com.LoginVO;
import kr.ac.kopo.schedule.service.ScheduleService;
import kr.ac.kopo.schedule.service.ScheduleVO;

@Controller("/schedule")
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	ScheduleService scheduleService;
	
	@GetMapping("/list.do")
	public String list(LoginVO vo, Model model, HttpSession session) {
//		ScheduleVO mvo = (ScheduleVO) session.getAttribute("loginUser"); //세션에 등록되었는지 확인
//		vo.setUserId(mvo.getUserId());
		
		List<ScheduleVO> lvo = scheduleService.list(vo);
		model.addAttribute("lvo",lvo);
		return "schedule/list";
	}
	
	@GetMapping("/add.do")
	public String addform() {
		return "schedule/add";
	}
	
	@PostMapping("/add.do")
	public String add(ScheduleVO vo, HttpSession session) {
//		ScheduleVO mvo = (ScheduleVO) session.getAttribute("loginUser"); //세션에 등록되었는지 확인
//		vo.setUserId(mvo.getUserId());
		
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
