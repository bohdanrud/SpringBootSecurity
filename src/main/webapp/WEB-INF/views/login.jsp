<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Login page</h2>
	<c:if test="${ param.fail }">
		<p style="color: red;"> Fail to authorize </p>
	</c:if>

	<form:form action="/login" method="POST">
	 Email: <input type="text" name="email">
		<br>
	 Password: <input type="password" name="password">
		<br>
		<input type="submit" value="Log In">
		<br>
	</form:form>

</body>
</html>