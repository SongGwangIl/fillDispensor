package kr.ac.kopo.schedule.service;

import java.util.List;

public interface ScheTimeService {

	List<ScheTimeVO> list(ScheduleVO vo);

	int add(ScheTimeVO vo);
}
