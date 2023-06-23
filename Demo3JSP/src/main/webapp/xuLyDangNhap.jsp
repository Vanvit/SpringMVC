<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

String username = request.getParameter("username");
String password = request.getParameter("password");
%>

<%
if(username.equalsIgnoreCase("Van") && password.equalsIgnoreCase("123"))
{
%>
	<h1>Bạn đã đăng nhập thành công</h1>
<%
}else{
%>
<h1>Not found acc</h1>
<%} %>

</body>
</html>