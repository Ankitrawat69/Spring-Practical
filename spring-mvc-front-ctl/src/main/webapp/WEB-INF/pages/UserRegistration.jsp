<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
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
			<h2 style="color: green">${msg}</h2>
			<h2 style="color: red">${emsg}</h2>
			<table>
				<tr>
					<th align="left">First Name :</th>
					<td><sf:input path="firstName" placeholder="enter first name" /></td>
					<td style="color: red"><sf:errors path="firstName"></sf:errors></td>
				</tr>
				<tr>
					<th align="left">Last Name :</th>
					<td><sf:input path="lastName" placeholder="enter last name" /></td>
					<td style="color: red"><sf:errors path="lastName"></sf:errors></td>
				</tr>
				<tr>
					<th align="left">Login ID :</th>
					<td><sf:input path="login" placeholder="enter your login" /></td>
					<td style="color: red"><sf:errors path="login"></sf:errors></td>
				</tr>
				<tr>
					<th align="left">Password :</th>
					<td><sf:input path="password"
							placeholder="enter your password" /></td>
					<td style="color: red"><sf:errors path="password"></sf:errors></td>
				</tr>
				<tr>
					<th align="left">Date Of Birth :</th>
					<td><sf:input path="dob" placeholder="enter your dob" /></td>
					<td style="color: red"><sf:errors path="dob"></sf:errors></td>
				</tr>
				<tr>
					<th align="left">Address :</th>
					<td><sf:input path="address" placeholder="enter first name" /></td>
					<td style="color: red"><sf:errors path="address"></sf:errors></td>
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