<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Status Page</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
	</head>
	<body>
		<form class = "box" method = "get">
			<h1 class = "margin">${message}</h1>
			<br>
			<br>
			<input type = "button"  class = "button btnWarning"onclick = "location.href = 'Menu'" value = "Return to Menu">
		</form>
	</body>
</html>