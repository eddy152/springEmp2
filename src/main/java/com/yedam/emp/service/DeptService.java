package com.yedam.emp.service;

import java.util.List;

import com.yedam.emp.DeptSearchVO;
import com.yedam.emp.DeptVO;

public interface DeptService {

	public int insertDept(DeptVO vo);
	
	public int updateDept(DeptVO vo);
	
	public int deleteDept(DeptVO vo);

	public  DeptVO getDept(DeptVO vo);
	
	public List<DeptVO> getSearchDept(DeptSearchVO vo);
	
	public int getCount(DeptSearchVO vo);
}
