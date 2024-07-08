package kr.ac.kopo.record.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.record.service.RecordService;
import kr.ac.kopo.record.service.RecordVO;

@Service
public class RecordServiceimpl implements RecordService{

	@Autowired
	private RecordDAO recordDAO;

	
	@Override
	public List<RecordVO> selectByDate(String userId) {
		return recordDAO.selectByDate(userId);
	}

	@Override
	public List<RecordVO> selectByAll(String userId) {
		return recordDAO.selectByAll(userId);
	}
}
