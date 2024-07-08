package kr.ac.kopo.schedule;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.schedule.service.ScheTimeService;
import kr.ac.kopo.schedule.service.ScheTimeVO;
import kr.ac.kopo.schedule.service.ScheduleVO;

@Controller("/schedule/time")
@RequestMapping("/schedule/time")
public class ScheTimeController {

	@Autowired
	ScheTimeService scheTimeService;

	@GetMapping("/add.do")
	public String addform() {
		return "schedule/time/add";
	}

	@PostMapping("/addPlus.do")
	public String addPlus(ScheTimeVO vo, HttpSession session) {
//		ScheduleVO mvo = (ScheduleVO) session.getAttribute("loginUser"); //세션에 등록되었는지 확인
//		vo.setUserId(mvo.getUserId());

		// sche_id 가져와야 함

		int num = scheTimeService.add(vo);
		System.out.println(num + "개의 시간설정 추가, 계속 추가합니다");
		return "schedule/time/add";
		// 같은 폼에서 다른 버튼으로 다른 컨트롤러를 실행하는것.. 되나? 되겟죠?
	}

	@PostMapping("/addFinish.do")
	public String addFinish(ScheTimeVO vo, HttpSession session) {
//		ScheduleVO mvo = (ScheduleVO) session.getAttribute("loginUser"); //세션에 등록되었는지 확인
//		vo.setUserId(mvo.getUserId());

		// sche_id 가져와야 함

		int num = scheTimeService.add(vo);
		System.out.println(num + "개의 시간설정 추가. 종료합니다");
		return "redirect:/schedule/list.do";
	}

}
