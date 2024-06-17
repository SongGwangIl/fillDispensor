package kr.ac.kopo.schedule.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ict.schedule.service.ScheduleService;
import com.ict.schedule.service.ScheduleVO;

import kr.ac.kopo.bookshop.pager.Pager;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
	
	final String path = "schedule/";
	
	@Autowired
	ScheduleService service;
	
	@GetMapping("/list")
	String list(Model model, Pager pager) {
		List<ScheduleVO> list = service.list(pager);
		//����¡ ó�� ���� �����̱� ��
		model.addAttribute("list", list);
		
		return path+"list";
	}
	
	@GetMapping("/add")
	String add() {
		
		return path+"add";
	}
	@PostMapping("/add")
	String add(ScheduleVO item) {
		
		service.add(item);
		
		return "redirect:list";
	}
	
	
	
	

//	// �ӽõ����� ��� ��������
//	@RequestMapping(value = "/temp3/selectList.do")
//	public String selectList(ScheduleVO scheduleVO, HttpServletRequest request, ModelMap model) throws Exception {
//
//		List<ScheduleVO> resultList = scheduleService.selectTempList(scheduleVO);
//		model.addAttribute("resultList", resultList);
//		
//		int totCnt = scheduleService.selectTempListCnt(scheduleVO);
//		model.addAttribute("totCnt", totCnt);
//
//		return "temp3/TempSelectList";
//	}
//
//	// �ӽõ����� ��������
//	@RequestMapping(value = "/temp3/select.do")
//	public String select(ScheduleVO scheduleVO, HttpServletRequest request, ModelMap model) throws Exception {
//		ScheduleVO result = scheduleService.selectTemp(scheduleVO);
//		model.addAttribute("result", result);
//		return "temp3/TempSelect";
//	}
//
//	// �ӽõ����� ���/����
//	@RequestMapping(value = "/temp3/tempRegist.do")
//	public String tempRegist(ScheduleVO scheduleVO, HttpServletRequest request, ModelMap model) throws Exception {
//		ScheduleVO result = new ScheduleVO();
//		if (!EgovStringUtil.isEmpty(scheduleVO.getScheNo())) {
//			result = scheduleService.selectTemp(scheduleVO);
//		}
//		model.addAttribute("result", result);
//		return "temp3/TempRegist";
//	}
//
//	// �ӽõ����� ����ϱ�
//	@RequestMapping(value = "/temp3/insert.do")
//	public String insert(ScheduleVO scheduleVO, HttpServletRequest request, ModelMap model) throws Exception {
//		scheduleService.insertTemp(scheduleVO);
//		return "forward:/temp3/selectList.do";
//	}
//
//	// �ӽõ����� �����ϱ�
//	@RequestMapping(value = "/temp3/update.do")
//	public String update(ScheduleVO scheduleVO, HttpServletRequest request, ModelMap model) throws Exception {
//		scheduleService.updateTemp(scheduleVO);
//		return "forward:/temp3/selectList.do";
//	}
//
//	// �ӽõ����� �����ϱ�
//	@RequestMapping(value = "/temp3/delete.do")
//	public String delete(ScheduleVO scheduleVO, HttpServletRequest request, ModelMap model) throws Exception {
//		scheduleService.deleteTemp(scheduleVO);
//		return "forward:/temp3/selectList.do";
//	}



}
