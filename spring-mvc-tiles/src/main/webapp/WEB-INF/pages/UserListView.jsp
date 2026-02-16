<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<div align="center">
		<h1>User List</h1>
		<sf:form method="post" modelAttribute="form">
			<table>
				<tr>
					<td><sf:input path="firstName"
							placeholder="search by firstName" /></td>

					<td><input type="submit" name="operation" value="search"></td>
				</tr>
			</table>
			<table width="100%" border="1px">
				<tr>
					<th>Select</th>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Login</th>
					<th>Password</th>
					<th>Dob</th>
					<th>Address</th>
					<th>Edit</th>
				</tr>

				<c:forEach items="${list}" var="user">
					<tr align="center">
						<td align="center"><sf:checkbox path="ids" value="${user.id}" /></td>
						<td><c:out value="${user.id}"></c:out></td>
						<td><c:out value="${user.firstName}"></c:out></td>
						<td><c:out value="${user.lastName}"></c:out></td>
						<td><c:out value="${user.login}"></c:out></td>
						<td><c:out value="${user.password}"></c:out></td>
						<td><fmt:formatDate value="${user.dob}" pattern="dd/MM/yyyy" />
						</td>
						<td><c:out value="${user.address}"></c:out></td>
						<td><a href="<c:url value="/ctl/User?id=${user.id}"/>"><b>Edit</b></a></td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<table style="width: 100%">
				<tr>
					<td><input type="submit" name="operation" value="previous" /></td>
					<td style="text-align: center;"><input type="submit"
						name="operation" value="delete"></td>
					<td style="text-align: right;"><input type="submit"
						name="operation" value="next"></td>
				</tr>
			</table>
		</sf:form>

	</div>
</body>
</html>