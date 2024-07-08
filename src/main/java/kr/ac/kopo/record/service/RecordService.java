package kr.ac.kopo.record.service;

import java.util.List;

public interface RecordService {
	
	List<RecordVO> selectByToday(String userId);
	
	List<RecordVO> selectByAll(String userId);
	
	List<RecordVO> selectByDate(String takeDate, String userId);

}
