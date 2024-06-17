package kr.ac.kopo.schedule.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.schedule.service.ScheduleVO;

import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.pager.Pager;

@Repository
public class ScheduleDAO {
	
	@Autowired
	SqlSession sql;
	
	public List<ScheduleVO> list(Pager pager) {
		return sql.selectList("schedule.list", pager);
	}

	public void add(ScheduleVO item) {
		sql.insert("schedule.add", item);
	}
	
	public int total(Pager pager) {
		return sql.selectOne("schedule.total", pager);
	}
}
	
//	// 임시데이터 가져오기
//	public ScheduleVO selectTemp(ScheduleVO vo) throws Exception{
//		return sql.selectOne("scheduleDAO.selectTemp",vo);
//	}
//	// 임시데이터 목록 가져오기
//	public List<ScheduleVO> selectTempList(ScheduleVO vo) throws Exception {
//		return sql.selectList("scheduleDAO.selectTempList", vo);
//	}
//	// 임시데이터 등록
//	public void insertTemp(ScheduleVO vo) throws Exception {
//		sql.insert("scheduleDAO.insertTemp", vo);
//	}
//	// 임시데이터 수정
//	public void updateTemp(ScheduleVO vo) throws Exception {
//		sql.update("scheduleDAO.updateTemp", vo);
//	}
//	// 임시데이터 삭제
//	public void deleteTemp(ScheduleVO vo) throws Exception {
//		sql.delete("scheduleDAO.deleteTemp", vo);
//	}
//	// 임시데이터 목록 수
//	public int selectTempListCnt(ScheduleVO vo) throws Exception {
//		return sql.selectOne("scheduleDAO.selectTempListCnt", vo);
//	}



