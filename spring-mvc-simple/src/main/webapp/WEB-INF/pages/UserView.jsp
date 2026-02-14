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
		
		<c:if test="${form.id>0}">
				<h1 style="color: navy">Update User</h1>
			</c:if>
			<c:if test="${form.id==0}">
				<h1 style="color: navy">Add User</h1>
			</c:if>
			
			<h3 style="color: green">${msg}</h3>
			<h3 style="color: red">${emsg}</h3>
			
			<table>
				<tr>
					<th align="left">First Name :</th>
					<td><sf:input path="firstName"
							placeholder="enter your firstName" /></td>
					<td style="color: red"><sf:errors path="firstName" /></td>
					
				</tr>
				<tr>
					<th align="left">Last Name :</th>
					<td><sf:input path="lastName"
							placeholder="enter your lastName" /></td>
		<td style="color: red"><sf:errors path="lastName" /></td>
					
				</tr>
				<tr>
					<th align="left">Login ID :</th>
					<td><sf:input path="login" placeholder="enter your login" /></td>
					<td style="color: red"><sf:errors path="login" /></td>
				</tr>
				<tr>
					<th align="left">Password :</th>
					<td><sf:input path="password"
							placeholder="enter your password" /></td>
							<td style="color: red"><sf:errors path="password" /></td>
				</tr>
				<tr>
					<th align="left">DOB :</th>
					<td><sf:input path="dob" placeholder="enter your dob" /></td>
					<td style="color: red"><sf:errors path="dob" /></td>
				</tr>
				<tr>
					<th align="left">Address</th>
					<td><sf:input path="address" placeholder="enter your address" /></td>
					<td style="color: red"><sf:errors path="address" /></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="${form.id > 0 ? 'update' : 'save'}"></td>
				</tr>
			</table>
		</div>
	</sf:form>
</body>
</html>