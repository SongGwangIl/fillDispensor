package kr.ac.kopo.schedule.service;

import java.util.List;

import kr.ac.kopo.com.LoginVO;

public interface ScheduleService {

	List<ScheduleVO> list(LoginVO vo);

	int add(ScheduleVO vo);
}
