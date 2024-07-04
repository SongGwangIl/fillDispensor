package kr.ac.kopo.record.service;

import java.util.List;

public interface RecordService {
	
	List<RecordVO> selectByDate(String userId);
	List<RecordVO> selectByAll(String userId);

}
