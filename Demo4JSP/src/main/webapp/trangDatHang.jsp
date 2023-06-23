<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xac Nhan don hang</title>
</head>
<body>
<%

String hoVaTen = request.getParameter("hoVaTen");
String email = request.getParameter("email");
String soLuong = request.getParameter("soLuong");

%>

<h1>Xác nhận đặt hàng</h1>
 Xin cảm ơn <%=hoVaTen %> đã đặt <b> <%=soLuong %> </b>sản phẩm<br>
<hr>
Bạn sẽ nhận được và email : <b><%=email %></b>

</body>
</html>