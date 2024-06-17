package kr.ac.kopo.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.com.LoginVO;
import kr.ac.kopo.user.service.UserService;

@Service
public class UserServiceimpl implements UserService{
	
	@Autowired
	UserDAO userdao;

	@Override
	public List<LoginVO> list(LoginVO vo) {
		
		return userdao.list();
	}
	
	
	public LoginVO selectList(LoginVO vo) {
		
		return userdao.selectList(vo);
	}

}
