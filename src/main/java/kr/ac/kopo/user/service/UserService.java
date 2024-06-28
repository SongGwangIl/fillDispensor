package kr.ac.kopo.user.service;

import kr.ac.kopo.user.UserVO;

public interface UserService {

	int add(UserVO vo);

	UserVO login(UserVO vo);
}
