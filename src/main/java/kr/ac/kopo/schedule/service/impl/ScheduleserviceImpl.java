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
	}

}
