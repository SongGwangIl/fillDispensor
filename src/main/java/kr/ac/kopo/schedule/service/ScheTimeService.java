package kr.ac.kopo.schedule.service;

import java.util.List;

import kr.ac.kopo.com.LoginVO;

public interface ScheTimeService {

	List<ScheTimeVO> list(LoginVO vo);

	int add(ScheTimeVO vo);
}
