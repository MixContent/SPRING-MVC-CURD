<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CURD OPERATION PAGE..</title>
<style type="text/css">
h1 {
	color: navy;
	text-align: left;
	top: 20px;
	font-size: 30px;
}

h2 {
	color: black;
	text-align: center;
}
</style>
</head>
<body>
	<h2>CURD OPEARATION</h2>
	<form action="${pageContext.request.contextPath}/save.mvc"
		method="post">
		<h1>CREATE (C)</h1>

		<table style="width: 19%; height: 100px; float: left;">
			<tr>
				<td>ID :</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>NAME :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>DEPT :</td>
				<td><input type="text" name="dept"></td>
			</tr>
			<tr>
				<td>SALARY :</td>
				<td><input type="text" name="salary"></td>
			</tr>
			<tr>
				<td><input type="submit" value="save"
					style="margin-left: 100px;"></td>
			</tr>
		</table>
	</form>
	<form action="${pageContext.request.contextPath}/update.mvc">

		<table style="width: 19%; height: 100px; float: right;">
			<h1 style="margin-top: 1px;">UPDATE (U)</h1>
			<tr>
				<td>ID :</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>SALARY :</td>
				<td><input type="text" name="salary"></td>
			</tr>
			<tr>
				<td><input type="submit" value="UPDATE"
					style="margin-left: 100px;"></td>
			</tr>
		</table>
	</form>
	<table style="width: 49%; height: 200px; float: left; margin: 100px;" >
		<tr>
			<td><a href="${pageContext.request.contextPath}/read.mvc">
					<h1>Click Here To Read</h1>
			</a></td>
		</tr>
	</table>
	<form action="${pageContext.request.contextPath}/delete.mvc">

		<table style="width: 19%; height: 100px; float: right;">
			<h1 style="margin-top: 1px;">DELETE (D)</h1>
			<tr>
				<td>ID :</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td><input type="submit" value="DELETE"
					style="margin-left: 100px;"></td>
			</tr>
		</table>
	</form>
</body>
</html>