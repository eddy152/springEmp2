package com.yedam.emp.service.impl;

import java.util.List;

import com.yedam.emp.UserVO;

public interface UserMapper {
	public int insertUser(UserVO vo);
	
	public int deleteUser(UserVO vo);
	
	public UserVO getSearchUser(UserVO vo);
	
	public List<UserVO> getUser(UserVO vo);
	
	public int updateUser(UserVO vo);
	
	public UserVO getUserOne(UserVO vo);
}
