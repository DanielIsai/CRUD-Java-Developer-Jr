<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Advanced Search</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css" />
	</head>
	<body>
		<form class = "box" method = "post" action = "detailsAdvancedSearch" onsubmit = "return fvalidator()">
			<h1>Advanced Search</h1>
			<h5 id = "message">Contain these data</h5>
			<input type = "text" 	name = "cname"	id = "fname"	placeholder = "Name">
			<input type = "text" 	name = "cemail" id = "femail"	placeholder = "Email">
			<input type = "text" 	name = "cphone" id = "fphone" 	placeholder = "Phone">
			<input type = "submit" 					id = "action" 	value = "Submit"><br>
			<input type = "button"  class = "button btnWarning" onclick = "location.href = 'MenuObtain'" value = "Return to Obtain Menu">
		</form>
	</body>
</html>