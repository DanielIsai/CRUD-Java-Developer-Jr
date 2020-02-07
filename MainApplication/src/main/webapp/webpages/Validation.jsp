<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Status Page</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css" />
	</head>
	<body>
		<form class = "box" method = "get" action = "Menu" >
			<h1>Do you want to continue?</h1>
			<h2>${Message}</h2>
			<input type = "button"  value = "No" class = "button btnGreen" 	onclick = "location.href = 'Menu'" >
			<input type = "button"  value = "Yes" class = "button btnWarning"		onclick = "location.href = '${Page}?UUID=${UUID}'" >
		</form>
	</body>
</html>