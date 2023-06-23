<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Person</title>
</head>
<body>
<h1>
<form action="/ServletHelloWorld/person/create" method="post">
  <label for="fid">ID:</label><br>
  <input type="text" id="id" name="idName" placeholder="id..."><br>
  <label for="fname">Name:</label><br>
  <input type="text" id="name" name="nameName" placeholder="name..."><br><br>
  <input type="submit" value="Submit">
</form>
</h1>
</body>
</html>