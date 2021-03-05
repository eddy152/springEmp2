package com.yedam.emp.service.impl;

import java.util.List;

import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;

public interface EmpMapper {

	public int insertEmp(EmpVO vo);

	public int updateEmp(EmpVO vo);

	public int deleteEmp(EmpVO vo);

	public EmpVO getEmp(EmpVO vo);

	public List<EmpVO> getSearchEmp(EmpSearchVO vo);

	public int getCount(EmpSearchVO vo);
}
