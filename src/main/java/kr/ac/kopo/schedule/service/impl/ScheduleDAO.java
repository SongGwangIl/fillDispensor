package kr.ac.kopo.schedule.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.ac.kopo.schedule.service.ScheduleVO;

@Mapper
public interface ScheduleDAO {
	
	List<ScheduleVO> list();

	int add(ScheduleVO vo);

}
