<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Obtain Person</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
		<script src="${pageContext.request.contextPath}/resources/js/name.js"></script>
	</head>	
	<body>
		<form class = "box" method = "post" action = "detailsObtainByName" onsubmit = "return fvalidator()">
			<h1>Obtain by Name</h1>
			<h5 id = "message">Obtain data</h5>
			<input type = "text" name = "cname" id = "fname" placeholder = "Name">
			<input type = "submit" id = "action" value = "Submit"><br>
			<input type = "button"  class = "button btnWarning" onclick = "location.href = 'MenuObtain'" value = "Return to Obtain Menu">
		</form>
	</body>
</html>