
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${ error != null}">
	<span style="color:red;">${ error }</span>
</c:if>

<form:form action="/user/edit" method="POST" modelAttribute="editModel">
	<form:hidden path="id" />
	<form:hidden path="password" />
    
    First Name: <form:input path="firstName" />
	<br>
    Last Name: <form:input path="lastName" />
	<br>
    Email: <form:input path="email" />
	<br>
    Age:  <form:input path="age" />
	<br>
    Description: <form:input path="description" />
	<br>

	<input type="submit" value="Edit">

</form:form>