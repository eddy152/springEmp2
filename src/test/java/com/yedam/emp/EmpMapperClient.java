package com.yedam.emp;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.emp.service.EmpService;
import com.yedam.emp.service.impl.EmpMapper;
//Can do without controller or service
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/*-context.xml")
public class EmpMapperClient {
	@Autowired EmpMapper empMapper;
		
	@Autowired EmpService empService;
	//@Test
	public void updateEmp() {
		EmpVO vo = EmpVO.builder()
						.employee_id("4002")
						.email("abc@bab.c")
						.build();
		int result = empMapper.updateEmp(vo);
		assertEquals(result, 1);
	}
	
	
	@Test
	public void insertEmp() {
		EmpVO vo = EmpVO.builder()
						.employee_id("5012")
						.first_name("1st4")
						.last_name("1tdest646")
						.email("abq@baq.com")
						.hire_date(new java.sql.Date(new Date().getTime()))
						.job_id("IT_PROG")
						.department_id("20")
						.build();
		int result = empService.insertEmp(vo);
		assertEquals(result, 1);
	}
	
	//@Test
	public void getSearchEmp() {
		EmpVO vo = EmpVO.builder().first_name("na").build(); // lombok
		List<EmpVO> list = empMapper.getSearchEmp(vo);
		System.out.println(list);
	}
	
	
	//@Test
	public void getEmp() {
		EmpVO vo = new EmpVO();
		vo.setEmployee_id("100");
		EmpVO resultVO = empMapper.getEmp(vo);
		// assertEquals("100", resultVO.getEmployee_id());
		assertNotNull(resultVO); // T/F
		System.out.println(resultVO);
	}

}
