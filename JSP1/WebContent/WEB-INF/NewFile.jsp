<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.lang.Math" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

int a = 2;
int b=3;
int sum  = a+b;
double canHai = Math.sqrt(sum);


%>

</body>
<h1> Hai Cong Ba = <%=sum %></h1>
<h1>Can cua <%=sum %> = <%=canHai %></h1>
</html>