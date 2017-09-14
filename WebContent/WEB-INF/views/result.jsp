<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CURD RESULTS :</title>
</head>
<body>
	<div align="center">

		<c:out value="${message}" />
		<br> <br> <br>
		<c:out value="${updatedMessage}" />
	</div>
	<table align="center" background="lavender" border="1">
		<tr style="border-color: red; color: lightblue">
			<th>ID</th>
			<th>NAME</th>
			<th>DEPT</th>
			<th>SALARY</th>
		</tr>
		<c:forEach items="${employeeDTOs}" var="employeeDTOs">
			<tr>
				<td>${employeeDTOs.id}</td>
				<td>${employeeDTOs.name}</td>
				<td>${employeeDTOs.dept}</td>
				<td>${employeeDTOs.salary}</td>
			</tr>
		</c:forEach>
	</table>

	<div align="center">
		<c:out value="${deleteInfo}" />
	</div>
</body>
</html>