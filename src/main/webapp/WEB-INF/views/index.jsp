<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
</head>
<body>

<div style="margin-left: 50px; margin-top: 50px;">

	<h1>${tag}</h1>

	<form method ="post" action="/home">
	ID:
	<br>
	<input type="text" name="id">
	<br>
	Password:
	<br>
	<input type="password" name="pw">
	<br>
	<br>
	<input type="submit" value="log in">
	
	</form>
	
</div>	

</body>
</html>