package kr.ac.kopo.user.service.impl;

import org.apache.ibatis.annotations.Mapper;

import kr.ac.kopo.user.UserVO;

@Mapper
public interface UserDAO {

	int add(UserVO vo);

	UserVO login(UserVO vo);

	String checkId(String userId);
}