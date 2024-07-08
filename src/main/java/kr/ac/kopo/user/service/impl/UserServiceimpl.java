package kr.ac.kopo.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.user.UserVO;
import kr.ac.kopo.user.service.UserService;

@Service
public class UserServiceimpl implements UserService{
	
	@Autowired
	UserDAO userdao;

	@Override
	public int add(UserVO vo) {
		
		return userdao.add(vo);
	}


	@Override
	public UserVO login(UserVO vo) {
		
		return userdao.login(vo);
	}


	@Override
	public String checkId(String userId) {

		return userdao.checkId(userId);
	}

}
