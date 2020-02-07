<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Update Person</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css" />
		<script src="${pageContext.request.contextPath}/resources/js/update.js"></script>
	</head>
	<body>
		<form class = "box" method = "post" action = "detailsUpdateById" onsubmit = "return fvalidator()">
			<h1>Update person</h1>
			<h5 id = "message">Update data</h5>
			<input type = "text" name = "cid" 	id = "fid" placeholder = "Id">
			<input type = "text" name = "cname" id = "fname" placeholder = "Name">
			<input type = "text" name = "cemail" id = "femail" placeholder = "Email">
			<input type = "text" name = "cphone" id = "fphone" placeholder = "Phone">
			<input type = "submit" id = "action" value = "Submit"><br>
			<input type = "button"  class = "button btnWarning" onclick = "location.href = 'Menu'" value = "Return to Menu">
		</form>
	</body>
</html>