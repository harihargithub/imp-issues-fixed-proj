<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Registration Confirmation</title>
</head>
<body>
	Your Registration with the following details is confirmed:
	<br>
	<br> First Name: ${employeeModel.firstname}
	<br> Last Name: ${employeeModel.lastname}
	<br> Department Name: ${employeeModel.department}
	<br> Technologies:

	<c:forEach var="technology" items="${employeeModel.technologies}"
		varStatus="status">
    ${technology} ** ${not status.last ? ' ' : ''}
</c:forEach>

	<c:forEach var="technology" items="${employeeModel.technologies}">
		<br>
		${technology}<br>
	</c:forEach>

</body>
</html>
