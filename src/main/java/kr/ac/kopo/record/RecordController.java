package kr.ac.kopo.record;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.record.service.RecordService;
import kr.ac.kopo.record.service.RecordVO;
import kr.ac.kopo.user.UserVO;

@Controller
@RequestMapping("/record")
public class RecordController{
		
	@Autowired
	private RecordService recordService;
		
	@GetMapping("/list.do")
	public String list(Model model, HttpSession session) {
		
		//세션객체에 저장된 로그인 정보에서 id를 받아옴
		UserVO uvo = (UserVO) session.getAttribute("loginUser");
		String userId = uvo.getUserId();

		List<RecordVO> listByAll = recordService.selectByAll(userId);
		List<RecordVO> listByDate = recordService.selectByDate(userId);
		
		model.addAttribute("recordSelectByAll", listByAll);
		model.addAttribute("recordSelectByDate", listByDate);

		return "record/list";
	}
	
}