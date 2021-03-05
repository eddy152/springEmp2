package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.DeptSearchVO;
import com.yedam.emp.DeptVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.DeptService;

@Controller
public class DeptController {
	@Autowired  DeptService deptService;
	
	@GetMapping("/insertDept")
	public String insertDept(DeptVO vo) {
		return "/dept/insertDept";
	}
	@PostMapping("/insertDept")
	public String insertDeptProc(DeptVO vo) {
		deptService.insertDept(vo);
		return "redirect:/getSearchDept";
	}
	
	@GetMapping("/updateDept")
	public String updateDept(DeptVO vo, Model model) {
		model.addAttribute("deptVO", deptService.getDept(vo));
		return "/dept/updateDept";
	}
	@PostMapping("/updateDept")
	public String updateDeptProc(DeptVO vo) {
		deptService.updateDept(vo);
		return "redirect:/getSearchDept";
	}
	
	@GetMapping("/getDept")
	public String getDept(DeptVO vo, Model model) {
		model.addAttribute("dept", deptService.getDept(vo));
		return "/dept/getDept";
	}
	@GetMapping("/getSearchDept")
	public String getSarchEmp(DeptSearchVO vo, Paging paging, Model model) {
		paging.setPageUnit(5);// Number of records displayed on one page
		paging.setPageSize(3);// Page number
		//paging
		if(vo.getPage() == null) {
			vo.setPage(1);
		}
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		paging.setTotalRecord(100);
		model.addAttribute("list", deptService.getSearchDept(vo));
		return "/dept/getSearchDept";
	}
	
	
}
