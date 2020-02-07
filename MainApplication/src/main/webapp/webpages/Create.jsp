<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Create Person</title>
		<link rel = "stylesheet" href = "${pageContext.request.contextPath}/resources/css/styles.css" />
		<script src="${pageContext.request.contextPath}/resources/js/create.js"></script>
	</head>
	<body>
		<form class = "box" method = "post" action = "detailsCreate" onsubmit = "return fvalidator()">
			<h1>New person</h1>
			<h5 id = "message">Add data</h5>
			<input type = "text" name = "cname"  id = "fname"  placeholder = "Name">
			<input type = "text" name = "cemail" id = "femail" placeholder = "Email">
			<input type = "text" name = "cphone" id = "fphone" placeholder = "Phone">
			<input type = "submit" id = "action" value = "Submit"><br>
			<input type = "button"  class = "button btnWarning" onclick = "location.href = 'Menu'" value = "Return to Menu">
		</form>
	</body>
</html>