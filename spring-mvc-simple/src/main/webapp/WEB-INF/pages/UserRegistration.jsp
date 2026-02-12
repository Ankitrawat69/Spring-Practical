<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<sf:form method="post" modelAttribute="form">
		<div align="center">
			<h1 style="color: navy">User Registration</h1>
			<h3>${msg}</h3>
			<table>
				<tr>
					<th align="left">First Name :</th>
					<td><sf:input path="firstName"
							placeholder="enter your firstName" /></td>
				</tr>
				<tr>
					<th align="left">Last Name :</th>
					<td><sf:input path="lastName"
							placeholder="enter your lastName" /></td>
				</tr>
				<tr>
					<th align="left">Login ID :</th>
					<td><sf:input path="login" placeholder="enter your login" /></td>
				</tr>
				<tr>
					<th align="left">Password :</th>
					<td><sf:input path="password"
							placeholder="enter your password" /></td>
				</tr>
				<tr>
					<th align="left">DOB :</th>
					<td><sf:input path="dob" placeholder="enter your dob" /></td>
				</tr>
				<tr>
					<th align="left">Address</th>
					<td><sf:input path="address" placeholder="enter your address" /></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="signUp"></td>
				</tr>
			</table>
		</div>
	</sf:form>
</body>
</html>