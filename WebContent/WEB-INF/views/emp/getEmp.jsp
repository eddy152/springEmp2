<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getEmp.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){  // () {}  CHECK
	$("#btnUpd").on("click", function(){
		// 1. location.href = "updateEmp?employee_id=${emp.employee_id}"
		location.assign("updateEmp?employee_id=${emp.employee_id}") //2
	});
});
</script>
</head>
<body>
파라미터 : ${employee}
<hr>
<h3>사원 상세보기</h3>
	사번 : ${emp.employee_id}<br>
	이름 : ${emp.first_name}<br>
	이메일 : ${emp.email}<br>
	급여 : ${emp.salary}<br>
	부서 : ${emp.department_id}<br>
	번호 : ${emp.phone_number}<br>
	<br>
	<button id="btnUpd">수정</button>
	<a href="deleteEmp?employee_id=${emp.employee_id}">삭제</a>
	<a href="getSearchEmp">목록가기</a>
	
</body>
</html>