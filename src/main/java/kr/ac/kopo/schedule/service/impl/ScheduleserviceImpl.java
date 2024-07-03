package kr.ac.kopo.schedule.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.com.LoginVO;
import kr.ac.kopo.schedule.service.ScheduleService;
import kr.ac.kopo.schedule.service.ScheduleVO;

@Service
public class ScheduleserviceImpl implements ScheduleService {
	
	@Autowired
	ScheduleDAO scheduleDAO;
	
	@Override
	public List<ScheduleVO> list(LoginVO vo) {
		return scheduleDAO.list();
		// 로그인한 사람의 리스트만 보여야 함... 일단 지금은 생략
	}

	@Override
	public int add(ScheduleVO vo) {
		return scheduleDAO.add(vo);
	}

}
