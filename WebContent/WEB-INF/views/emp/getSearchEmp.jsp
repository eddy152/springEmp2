<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp/getSearchEmp.jsp</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h3>사원목록</h3>
<form action="getSearchEmp" name="searchFrm">
	<input type="hidden" name="page" value="1">
	부서 <input name= "department_id" value="${empSearchVO.department_id}">
	JOB <input name = "job_id" value="${empSearchVO.job_id}">
	NAME<input name ="first_name" value="${empSearchVO.first_name}">
	<button>검색</button>
</form>
	<c:forEach items="${list }" var="emp">
	<div class="row">
	
		사번 : <a href="getEmp?employee_id=${emp.employee_id}"> ${emp.employee_id }</a>
		/ 이름 :<a href="getEmp?employee_id=${emp.employee_id}"> ${emp.first_name } </a>
		/ 부서이름 : ${emp.department_name } 
		/ 직업명 :  ${emp.job_title}<br>
	</div>	
	</c:forEach>
	<my:paging paging="${paging}"  jsFunc="goPage"/> 
	<script>
		function goPage(p){
		//	location.href="getSearchEmp?page=" + p;
			searchFrm.page.value=p;
			searchFrm.submit();
		
		}
	</script>
	<a href="main">목록가기</a>
</body>
</html>