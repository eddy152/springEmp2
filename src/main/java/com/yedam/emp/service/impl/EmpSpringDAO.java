package com.yedam.emp.service.impl;

import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yedam.emp.EmpVO;

@Repository
public class EmpSpringDAO {
	@Autowired
	JdbcTemplate jdbc;

	private final String INSERT_EMP = "INSERT  INTO  EMPLOYEES"
									+ "( EMPLOYEE_ID," + " FIRST_NAME," + " LAST_NAME,"
									+ " EMAIL," + " HIRE_DATE," + " JOB_ID," +" MANAGER_ID," +" DEPARTMENT_ID)"
									+ " VALUES(?,?,?,?,?,?,?,?)";

	private final String UPDATE_EMP = "UPDATE EMPLOYEES SET "
									+ "FIRST_NAME=?, LAST_NAME=?, EMAIL=?, PHONE_NUMBER=?,DEPARTMENT_ID=?, MANAGER_ID=?"
									+ " WHERE EMPLOYEE_ID=?";

	private final String DELETE_EMP = "DELETE FROM EMPLOYEES  WHERE EMPLOYEE_ID=? ";
	
	private final String GET_EMP = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=? ";
	//Brings a list that is not a simple construction
	private final String GET_SEARCH_EMP = "SELECT * FROM EMPLOYEES";

	// insert
	public int insertEmp(EmpVO vo) {
		int result = 0;
		result = jdbc.update(INSERT_EMP, vo.getEmployee_id(), vo.getFirst_name(), vo.getLast_name(), vo.getEmail(),
				vo.getHire_date(), vo.getJob_id(), vo.getDepartment_id());

		return result;
	}

	// Modify
	public int updateEmp(EmpVO vo) {
		int result = 0;
		result = jdbc.update(UPDATE_EMP,//
				vo.getFirst_name(),//
				vo.getLast_name(),//
				vo.getEmail(),//
				vo.getPhone_number(),//
				vo.getDepartment_id(),//
				vo.getManager_id(),//
			vo.getEmployee_id());//
		return result;
	}
	// delete

	public int deleteEmp(EmpVO vo) {
		int result = 0;
		result = jdbc.update(DELETE_EMP, vo.getEmployee_id());
		
		return result;
		
	}
	
	// one look up
	public EmpVO getEmp(EmpVO empVO) {
	 return jdbc.queryForObject(GET_EMP, new EmpRowMapper(),
			 					  empVO.getEmployee_id());
	}
	//Search Inquiry
	public List<EmpVO> getSearchEmp(EmpVO empVO){
		return jdbc.query(GET_SEARCH_EMP,
						new EmpRowMapper());
	}
	
	
	
	// RowMapper create!!
	class EmpRowMapper implements RowMapper<EmpVO>{

		@Override
		public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpVO vo = new EmpVO();
			vo = new EmpVO();
			vo.setEmployee_id(rs.getString("EMPLOYEE_ID"));
			vo.setFirst_name(rs.getString("FIRST_NAME"));
			vo.setLast_name(rs.getString("LAST_NAME"));
			vo.setEmail(rs.getString("EMAIL"));
			vo.setSalary(rs.getString("SALARY"));
			vo.setHire_date(rs.getDate("HIRE_DATE"));
			vo.setDepartment_id(rs.getString("DEPARTMENT_ID"));
			vo.setJob_id(rs.getString("JOB_ID"));
			vo.setPhone_number(rs.getString("PHONE_NUMBER"));
			vo.setManager_id(rs.getString("MANAGER_ID"));
			
			return vo;
		}	
	
	}


		
}

