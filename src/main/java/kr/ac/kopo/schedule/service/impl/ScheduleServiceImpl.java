package kr.ac.kopo.schedule.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.schedule.service.ScheduleService;
import com.ict.schedule.service.ScheduleVO;

import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.pager.Pager;

@Service
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	private ScheduleDAO dao;
	
	@Override
	public List<ScheduleVO> list(Pager pager) {
		int total = dao.total(pager);
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	public void add(ScheduleVO item) {
		dao.add(item);
		
	}

	@Override
	public ScheduleVO item(int sheNo) {
		// TODO Auto-generated method stub
		return null;
	}
}
