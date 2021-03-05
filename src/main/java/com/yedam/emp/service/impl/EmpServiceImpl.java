package com.yedam.emp.service.impl;

import java.util.List; 	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {
	
	//@Autowired EmpSpringDAO dao;
	//@Autowired EmpMybatisDAO dao;
	@Autowired EmpMapper dao;
	
	//@Transactional
	public int insertEmp(EmpVO vo) {    //Decide on a new method
		//dao.insertEmp(vo); // Auto commit   If the transaction is not specified, it is automatically committed. //Error after double insert
		//If transaction is specified, all queries are rolled back.
		return dao.insertEmp(vo); // uk error
	} 

	
	
	public int updateEmp(EmpVO vo) {
		return dao.updateEmp(vo);
	}

	public int deleteEmp(EmpVO vo) {
		return dao.deleteEmp(vo);
	}

	public EmpVO getEmp(EmpVO vo) {
		return dao.getEmp(vo);
	}

	public List<EmpVO> getSearchEmp(EmpSearchVO vo) {
		return dao.getSearchEmp(vo);
	}



	@Override
	public int getCount(EmpSearchVO vo) {
		return dao.getCount(vo);
	}
	
	

}
