package kr.ac.kopo.schedule.service;

import java.util.List;

import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.pager.Pager;

public interface ScheduleService {
	
	List<ScheduleVO> list(Pager pager);

	void add(ScheduleVO item);
	
	ScheduleVO item(int sheNo);
	
	}
