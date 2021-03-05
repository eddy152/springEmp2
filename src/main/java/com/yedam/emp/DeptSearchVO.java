package com.yedam.emp;

import lombok.Data;

@Data
public class DeptSearchVO extends DeptVO{
	// paging
	Integer page = 1;
	int start = 1;
	int end = 10;
}
