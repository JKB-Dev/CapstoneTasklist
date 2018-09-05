<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>task page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
</head>
<body>

<div style="margin-left: 50px; margin-top: 50px;">

<h1>task list for user #${tag}</h1>

<table border="1">
	<tr>
	    <th>task #</th>
	    <th>task description</th>
	    <th>task due date</th>
	    <th>task complete</th>
	    <th></th>
	</tr>
	<c:forEach var="task" items="${list}"> <!-- products EL tag places results of repository.findAll() in table -->
		<tr>
			<td> ${ task.idtask }</td>
			<td> ${ task.taskdesc }</td>
			<td> ${ task.taskdue }</td>
			<td><input type="checkbox" name="complete" value="${task.complete}"></td>
			<td><a href="/item/${task.idtask}/delete" onclick="return confirm('Are you sure you want to delete this task?');">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<br>

<form action="addtask" method="post">
	<input type="hidden" type="number" id="iduser" name="iduser" value="${tag}"></input>
	<br>
	<input type="submit" value="add task">
</form>

</div>

</body>
</html>