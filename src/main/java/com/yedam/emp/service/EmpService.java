package com.yedam.emp.service;

import java.util.List;

import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;

public interface EmpService {
	// Enrollment
	public int insertEmp(EmpVO vo);
	// Modify
	public int updateEmp(EmpVO vo);
	// delete
	public int deleteEmp(EmpVO vo);
	// one look up
	public EmpVO getEmp(EmpVO vo);
	// All Inquiry
	public List<EmpVO> getSearchEmp(EmpSearchVO vo);
	// Number of Case
	public int getCount(EmpSearchVO vo);
	
	
}
