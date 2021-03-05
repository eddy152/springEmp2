package com.yedam.emp.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.emp.service.UserService;
import com.yedam.emp.UserVO;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	// 등록 처리
	@PostMapping("/User")
	public UserVO insertUserProc(@RequestBody UserVO vo) {
		userService.insertUser(vo);
		return vo;
	}// 수정 처리

	@PutMapping("/User")
	public Map updateUser(@RequestBody UserVO vo) {
		int r = userService.updateUser(vo);
		return Collections.singletonMap("cnt", r);
	}

	// 삭제 처리
	@DeleteMapping(value = "/User")
	public Map deleteUserProc(@RequestBody UserVO vo) {
		int r = userService.deleteUser(vo);
		return Collections.singletonMap("cnt", r);
	}

	// 전체 조회
	@GetMapping("/User")
	public List<UserVO> getSearchUser(UserVO vo) {
		return userService.getUser(vo);
	}

	// 단건 조회
	@GetMapping("/User/{id}")
	public UserVO getUser(UserVO vo, @PathVariable String id) {
		vo.setId(id);
		return userService.getSearchUser(vo);
	}

	// 단건 조회
	@GetMapping("/User/{id}&{password}")
	public UserVO getUserOne(UserVO vo, @PathVariable String id, @PathVariable String pw) {
		vo.setId(id);
		vo.setPassword(pw);
		return userService.getSearchUser(vo);
	}
}
