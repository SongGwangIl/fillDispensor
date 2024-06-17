package kr.ac.kopo.user.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.ac.kopo.com.LoginVO;

@Mapper
public interface UserDAO {

	List<LoginVO> list();
	
	LoginVO selectList(LoginVO vo);
}