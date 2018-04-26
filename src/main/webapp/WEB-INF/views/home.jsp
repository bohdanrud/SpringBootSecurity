<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Home Page</h1>

<sec:authorize access="!isAuthenticated()">
	<a href="/login">Go to Log In</a> <br>
	<a href="/register">Go to Register</a> <br>
</sec:authorize>

<sec:authorize access="isAuthenticated()">

<sec:authorize access="hasRole('ADMIN')">
<a href="/admin">Go to Admin</a> <br>
</sec:authorize>

<sec:authorize access="hasAnyRole('ADMIN','USER')">
<a href="/user">Go to User</a> <br>
</sec:authorize>

<form:form action="/logout" method="POST">
<input type="submit" value="Log Out">
</form:form>
</sec:authorize>

</body>
</html>