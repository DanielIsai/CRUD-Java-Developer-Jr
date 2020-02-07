<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Delete Person</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css" />
		<script src="${pageContext.request.contextPath}/resources/js/byid.js"></script>
	</head>
	<body>
		<form class = "box" method = "post" action = "detailsDeleteById" onsubmit = "return fvalidator()">
			<h1>Delete person</h1>
			<h5 id = "message">Delete data</h5>
			<input type = "text" name = "cid" id = "fid" placeholder = "Id">
			<input type = "submit" id = "action" value = "Submit"><br>
			<input type = "button"  class = "button btnWarning"onclick = "location.href = 'Menu'" value = "Return to Menu">
		</form>
	</body>
</html>