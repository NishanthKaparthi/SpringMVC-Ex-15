<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
	.error{
		color:red
	}
</style>
<title>Employee Form</title>
</head>
<body>
	<form:form action="/createEmployee" modelAttribute="employee">
		<label for = "idInput">Id: </label>
		<form:input path="id" id="idInput"/>
		<form:errors path = "id" cssClass="error"></form:errors><br>
		<label for = "firstNameInput">FirstName: </label>
		<form:input path="firstName" id="firstNameInput"/>
		<form:errors path = "firstName" cssClass="error"></form:errors><br>
		<label for = "lastNameInput">LastName: </label>
		<form:input path="lastName" id="lastNameInput"/>
		<form:errors path = "lastName" cssClass="error"></form:errors><br>
		<label for = "emailInput">Email: </label>
		<form:input path="email" id="emailInput"/>
		<form:errors path = "email" cssClass="error"></form:errors><br>
		<input type="submit" value="Enter" />
	</form:form>
</body>
</html>