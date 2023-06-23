<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Hello Java Servlet!!!</h1>
<%

	String ip = request.getRemoteAddr();
	int x  = 10;
	
	Object obj = request.getAttribute("msg");
	String s = (String) obj; // ep kieu đa hình
	
%>
<%=ip %><br>
<%= x %><br>
<%=s %>


</body>
</html>