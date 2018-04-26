<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
</sec:authorize>
<a href="/admin">Go to Admin</a> <br>
<a href="/user">Go to User</a> <br>

</body>
</html>