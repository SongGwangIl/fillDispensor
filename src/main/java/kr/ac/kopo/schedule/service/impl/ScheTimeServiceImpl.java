package kr.ac.kopo.schedule.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.schedule.service.ScheTimeService;
import kr.ac.kopo.schedule.service.ScheTimeVO;
import kr.ac.kopo.schedule.service.ScheduleVO;

@Service
public class ScheTimeServiceImpl implements ScheTimeService {

	@Autowired
	ScheTimeDAO scheTimeDAO;

	@Override
	public List<ScheTimeVO> list(ScheduleVO vo) {
		return scheTimeDAO.list(vo);
		// 로그인한 사람의 리스트만 보여야 함... 일단 지금은 생략
	}

	@Override
	public int add(ScheTimeVO vo) {
		return scheTimeDAO.add(vo);
	}

}
