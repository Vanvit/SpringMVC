<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<h1>
<form action="/ServletHelloWorld/login" method="post">
  <label for="fUsername">Username:</label><br>
  <input type="text" id="username" name="username" placeholder="username..."><br>
  <label for="fPassword">Password:</label><br>
  <input type="password" id="password" name="password" placeholder="password..."><br><br>
  <input type="submit" value="Login">
</form>
</h1>

</body>
</html>