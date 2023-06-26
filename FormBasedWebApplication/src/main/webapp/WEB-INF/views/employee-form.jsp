<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="employeeModel">
		First Name :
		<form:input path="firstname" />
		<br> Last Name :
		<form:input path="lastname" />
		<br> 
		Department Name : 
		HR
		<form:radiobutton path="department" value="HR" />
		Admin
		<form:radiobutton path="department" value="Admin" />
		IT
		<form:radiobutton path="department" value="IT" />
		<br> 
		Technologies: 
		Excel
		<form:checkbox path="technologies" value="Excel" />
		Java
		<form:checkbox path="technologies" value="Java" />
		RDMS
		<form:checkbox path="technologies" value="RDMS" />
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>
