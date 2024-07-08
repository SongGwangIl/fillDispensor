package kr.ac.kopo.record.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.record.service.RecordService;
import kr.ac.kopo.record.service.RecordVO;

@Service
public class RecordServiceImpl implements RecordService{

	@Autowired
	private RecordDAO recordDAO;

	
	@Override //오늘의 날짜 조회
	public List<RecordVO> selectByToday(String userId) {
		return recordDAO.selectByToday(userId);
	}

	@Override //전체 조회
	public List<RecordVO> selectByAll(String userId) {
		return recordDAO.selectByAll(userId);
	}

	@Override //선택 날짜 조회
	public List<RecordVO> selectByDate(String takeDate, String userId) {
		return recordDAO.selectByDate(takeDate, userId);
	}
	
	
}
