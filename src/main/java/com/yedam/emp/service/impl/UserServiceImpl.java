package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.UserVO;
import com.yedam.emp.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired UserMapper dao;
	
	@Override
	public int insertUser(UserVO vo) {
		return dao.insertUser(vo);
	}

	@Override
	public int deleteUser(UserVO vo) {
		return dao.deleteUser(vo);
	}

	@Override
	public UserVO getSearchUser(UserVO vo) {
		return dao.getSearchUser(vo);
	}
	
	@Override
	public List<UserVO> getUser(UserVO vo) {
		return dao.getUser(vo);
	}

	@Override
	public int updateUser(UserVO vo) {
		int r = 0;
		r = dao.updateUser(vo);
		return r;
	}

	@Override
	public UserVO getUserOne(UserVO vo) {
		return dao.getUserOne(vo);
	}

}
