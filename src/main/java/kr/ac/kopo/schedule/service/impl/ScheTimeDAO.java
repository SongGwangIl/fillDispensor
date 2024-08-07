package kr.ac.kopo.schedule.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.ac.kopo.schedule.service.ScheTimeVO;
import kr.ac.kopo.schedule.service.ScheduleVO;

@Mapper
public interface ScheTimeDAO {
	
	List<ScheTimeVO> list(ScheduleVO vo);

	int add(ScheTimeVO vo);

}
