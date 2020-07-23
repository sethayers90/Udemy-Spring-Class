<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
	First Name: <form:input path="firstName"/>
	<br><br>
	Last Name: <form:input path="lastName"/>
	<br><br>
	Country: 
	<form:select path="country">
	
		<form:option value="Brazil" label="Brazil"/>
		<form:option value="France" label="Franch"/>
		<form:option value="Germany" label="Germany"/>
		<form:option value="Unite States" label="United States"/>
		
	</form:select>
	<br><br>
	<input type="submit" value="Submit"/>
	</form:form>
	
</body>
</html>