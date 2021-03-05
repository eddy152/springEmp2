<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateEmp.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h3 id="top">부서입력</h3>
	<form action="insertDept" method="post" name="frm">
		department_id
		<input type="number" name="department_id"><br>
		department_name
		<input name="department_name"><br>
		manager_id
		<input name="manager_id"><br>
		location_id
		<input name="location_id"><br>
		<button type="submit">등록</button>
		<button type="reset">초기화</button>
	</form>
</body>
</html>
