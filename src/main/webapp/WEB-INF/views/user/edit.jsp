<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
    <form:form action="/user/edit" method="POST" modelAttribute="editModel">
    
    First Name: <form:input path="firstName"/> <br>
    Last Name: <form:input path="laststName"/> <br>
    Email: <form:input path="email"/> <br>
    Age:  <form:input path="age"/> <br>
    Description: <form:input path="description"/> <br>
    
    <input type="submit" value="Edit">
    
    </form:form>