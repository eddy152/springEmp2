package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.DeptSearchVO;
import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.JobVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.DeptService;
import com.yedam.emp.service.EmpService;

@Controller
public class EmpController {

	@Autowired EmpService empService;
	@Autowired DeptService deptService;
	//@Autowired JobService jobService;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	@GetMapping("/insertEmp") // Registration page
	public String insertEmp(EmpVO vo, Model model, DeptSearchVO deptvo, JobVO jobvo) {
//		deptvo.setStart(1);
//		deptvo.setEnd(1000);
		model.addAttribute("deptList", deptService.getSearchDept(deptvo));
//		model.addAttribute("jobList", jobService.getSearchJob(jobvo));
		return "/emp/insertEmp";
	}
	@PostMapping("/insertEmp") // Registration process
	public String insertEmpProc(EmpVO vo) {
		empService.insertEmp(vo);
		return "redirect:/getSearchEmp";
	}	
	
	@GetMapping("/updateEmp") // Modify page
	public String updateEmp(EmpVO vo, Model model, DeptSearchVO deptvo) {
		model.addAttribute("deptList", deptService.getSearchDept(deptvo));
		model.addAttribute("empVO", empService.getEmp(vo));
		return "/emp/updateEmp";
	}
	@PostMapping("/updateEmp") // Modify process
	public String updateEmpProc(EmpVO vo) {
		empService.updateEmp(vo);
		return "redirect:/getSearchEmp";
	}
	
	@GetMapping("/getEmp") // Single inquiry
	public String getEmp(Model model
						//, HttpServletRequest request
						//, @RequestParam(value="id", required = false, defaultValue = "100") String employee_id // = request.getparameter
						//, @PathVariable String employee_id
						, @ModelAttribute("employee") EmpVO vo
						) {
		//1. getParameter
		//String employee_id = request.getParameter("employee_id");
		
		//EmpVO vo = new EmpVO();
		//vo.setEmployee_id(employee_id);
		
		model.addAttribute("emp", empService.getEmp(vo));
		return "/emp/getEmp";
	}
	@GetMapping("/getSearchEmp") //All Inquiry
	public String getSearchEmp(EmpSearchVO vo,Paging paging ,Model model) {
		paging.setPageUnit(5);// Number of records displayed on one page
		paging.setPageSize(3);// Page number
		//paging
		if(vo.getPage() == null) {
			vo.setPage(1);
		}
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		paging.setTotalRecord(100);
		model.addAttribute("paging", paging);
		model.addAttribute("list", empService.getSearchEmp(vo));
		return "/emp/getSearchEmp";
	//	int start = (vo.getPage() - 1 ) * 10 + 1;
	//	int end = start + 10 - 1; // One page output unit
	//	vo.setStart(start);
	//	vo.setEnd(end);
	}
	
	@RequestMapping("/deleteEmp") // delete
	public String deleteEmp(EmpVO vo, Model model) {
		empService.deleteEmp(vo);
		return "redircet:/getSearchEmp";
	}
	
}
