package kr.ac.kopo.schedule;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.ac.kopo.schedule.service.ScheduleService;
import kr.ac.kopo.schedule.service.ScheduleVO;
import kr.ac.kopo.user.UserVO;

@Controller("/schedule")
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	ScheduleService scheduleService;
	
	@GetMapping("/list.do")
	public String list(@SessionAttribute("loginUser") UserVO uvo, Model model) {
		List<ScheduleVO> lvo = scheduleService.list(uvo.getUserId()); // 테스트
		model.addAttribute("lvo",lvo);
		// scheTimeVO 추가
		return "schedule/list";
	}
	
	@GetMapping("/add.do")
	public String addform() {
		return "schedule/add";
	}
	
	@PostMapping("/add.do")
	public String add(@SessionAttribute("loginUser") UserVO uvo, ScheduleVO svo, Model model) {
		svo.setUserId(uvo.getUserId());
		int num = scheduleService.add(svo);
		System.out.println(num + "개의 스케쥴 추가 완료");
		model.addAttribute("scheduleVO", svo);
		return "schedule/time/add1";
	}
	
//	400에러 테스트 코드
//	@PostMapping("/add.do")
//	public String add2(ScheduleVO vo, HttpSession session) {
//		System.out.println("11111");
//		return "redirect:/schedule/list.do";
//	}
//	

}
