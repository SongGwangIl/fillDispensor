package kr.ac.kopo.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.kopo.com.LoginVO;
import kr.ac.kopo.schedule.service.ScheduleService;
import kr.ac.kopo.schedule.service.ScheduleVO;

@Controller
public class ScheduleController {

	@Autowired
	ScheduleService scheduleService;
	
	@RequestMapping(path = "/list.do", method = RequestMethod.GET)
	public String list(LoginVO vo, Model model) {
		List<ScheduleVO> lvo = scheduleService.list(vo);
		model.addAttribute("lvo",lvo);
		
		return "schedule/list";
	}
	

}
