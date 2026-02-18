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
					<td><sf:input path="studentName"
							placeholder="search by studentName" /></td>

					<td><input type="submit" name="operation" value="search"></td>
				</tr>
			</table>
			<table width="100%" border="1px">
				<tr>
					<th>Select</th>
					<th>Id</th>
					<th>Student Name</th>
					<th>Login</th>
					<th>Password</th>
					<th>Address</th>
					<th>Edit</th>
				</tr>

				<c:forEach items="${list}" var="student">
					<tr align="center">
						<td align="center"><sf:checkbox path="ids" value="${student.id}" /></td>
						<td><c:out value="${student.id}"></c:out></td>
						<td><c:out value="${student.studentName}"></c:out></td>
						<td><c:out value="${student.login}"></c:out></td>
						<td><c:out value="${student.password}"></c:out></td>
						<td><c:out value="${student.address}"></c:out></td>
						<td><a href="<c:url value="/ctl/Student?id=${student.id}"/>"><b>Edit</b></a></td>
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