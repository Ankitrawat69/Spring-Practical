<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty sessionScope.user}">
		<h3>
			Hi,
			<c:out value="${sessionScope.user.firstName}"></c:out>
		</h3>
		<a href="<c:url value="/Welcome"/>"><b>Welcome</b></a> |
		<%-- <a href="<c:url value="/User"/>"><b>Add User</b></a> | 
		<a href="<c:url value="/User/search"/>"><b>User List</b></a> |  --%>
		<a href="<c:url value="/Login?operation=logout"/>"><b>Logout</b></a>
	</c:if>
	<c:if test="${empty sessionScope.user}">
		<h3>Hi, Guest</h3>
		<a href="<c:url value="/Welcome"/>"><b>Welcome</b></a> |
		<a href="<c:url value="/Login"/>"><b>Login</b></a>
	</c:if>
	<hr>
</body>
</html>