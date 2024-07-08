package kr.ac.kopo.record.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.ac.kopo.record.service.RecordVO;

@Mapper
public interface RecordDAO {
	
	List<RecordVO> selectByToday(String userId);
	
	List<RecordVO> selectByAll(String userId);
	
	List<RecordVO> selectByDate(@Param("takeDate") String takeDate, @Param("userId") String userId);
}