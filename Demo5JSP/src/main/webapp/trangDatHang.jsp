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

int slSP = 1;
try{
	slSP = Integer.parseInt(soLuong);
}catch(Exception e){
	
}

%>

<h1>Xác nhận đặt hàng</h1>
 Xin cảm ơn <%=hoVaTen %> đã đặt <b> <%=slSP %> </b>sản phẩm<br>
 Số tiền cần thanh toán là <b><%=slSP*5000 %>VNĐ</b>
<hr>
Bạn sẽ nhận được và email : <b><%=email %></b>

</body>
</html>