package kr.ac.kopo.user.service;

import java.util.List;

import kr.ac.kopo.com.LoginVO;

public interface UserService {

	List<LoginVO> list(LoginVO vo);
	
	LoginVO selectList(LoginVO vo);
}
