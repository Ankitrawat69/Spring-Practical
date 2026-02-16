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
			<h1 style="color: navy">Login</h1>
			<h2 style="color: green">${msg}</h2>
			<h2 style="color: red">${emsg}</h2>
			<h2 style="color: red">${error}</h2>
			<table>
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
					<th></th>
					<td><input type="submit" name="operation" value="signIn"></td>
				</tr>
			</table>
		</div>
	</sf:form>
</body>
</html>