package kr.ac.kopo.record.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.ac.kopo.record.service.RecordVO;

@Mapper
public interface RecordDAO {
	
	List<RecordVO> selectByDate(String userId);
	List<RecordVO> selectByAll(String userId);
}