<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Register page</h1>

<form:form action="/register" method="POST" modelAttribute="registerModel">

	Email: <form:input path="email"/> <br>
	Password: <form:password path="password"/> <br>
	Password Confirmation: <form:password path="passwordConfirmation"/> <br>
	
	<input type="submit" value="Register">

</form:form>

</body>
</html>