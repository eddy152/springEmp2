<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateEmp.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	//이메일 중복체크 json
	$("#btnEmail").on("click", function(){
		$.ajax({
				url : "EmailCheck",
				data : "email="+$("[name=email]").val(), //서버에보낼 파라미터  param값 넣기
				dataType : "xml", 	//결과 타입 json -> xml
				success : function(response){ //인수로넘어온다
			/*	json
				$("#emailResult").html(response.email); //인수값출력
				if( response.email == true){
					#("#emailResult").html("<font color='blue'>사용가능</font>");
				}else
					#("#emailResult").html("<font color='red'>사용불가능</font>");
			} */
			// xml
					$("#emailResult").html( $(response).find("email").text() );
		}
		})
	});
		$("#empSearch").on("click", function(){
			window.open('empSearch', '사원검색', 'width=700px, height=800px');
		});
		
});

</script>
</head>
<body>
	<h3 id="top">사원수정</h3>
	<div align="center">
		<form:form modelAttribute="empVO" action="updateEmp" method="post" name="frm">
			employee_id <form:input path="employee_id"/><br>
			first_name <form:input path="first_name"/><br>
			last_name <form:input path="last_name"/><br>
			email <form:input path="email"/>
			<!--이메일중복체크 -->
			<button type="button" id="btnEmail">중복체크</button>
			<span id="emailResult"></span><br> 
			phone_number <form:input path="phone_number"/><br>
			hire_date <form:input path="hire_date"/><br>
			<form:radiobutton path="department_id"/><br>
			department_id <form:radiobuttons path="department_id" items="${deptList}" itemLabel="department_name" itemValue="department_id"/><br> 
			job_id <form:select path="job_id">
						<option value="선택">선택</option>
						<form:options items="${jobList}" itemLabel="job_title" itemValue="job_id"/>
				   </form:select><br>
			manager_id <form:input path="manager_id"/><br>
			<button type="button" id="empSearch">사원검색</button><br>
			<button type="submit">등록</button>
			<button type="reset">취소</button>
			<a href="getSearchEmp">목록가기</a>
		</form:form>
	</div>
</body>
</html>