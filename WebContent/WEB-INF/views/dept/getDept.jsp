<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function () {
	$("#btnUpd").on("click", function() {
		//location.href = "updateDept?department_id=${dept.department_id}"
		location.assign("updateDept?department_id=${dept.department_id}");
	});
});
</script>
</head>
<body>
<div align="center">
	DEPARTMENT_ID : ${dept.department_id}<br>
	DEPARTMENT_NAME : ${dept.department_name}<br>
	MANAGER_ID : ${dept.manager_id}<br>
	LOCATION_ID : ${dept.location_id}<br>
	<button id="btnUpd">수정</button><br>
	<a href="deleteDept?department_id=${dept.department_id}">삭제</a>&nbsp;
	<a href="getSearchDept">목록으로</a>
</div>
</body>
</html>