<%@page import="model.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Person details</title>
</head>
<body>

	<%
		Person per = (Person) request.getAttribute("person");
	%>
	ID:<%=per.getId()%>
	<br> 
	Name:<%=per.getName()%>

</body>
</html>