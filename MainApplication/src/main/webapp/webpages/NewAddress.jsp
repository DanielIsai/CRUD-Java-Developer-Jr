<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Address</title>
		<link rel = "stylesheet" href = "${pageContext.request.contextPath}/resources/css/styles.css" />
		<script src="${pageContext.request.contextPath}/resources/js/address.js"></script>
	</head>
	<body>
		<form class = "box" method = "post" action = "detailsAddress?UUID=${UUID}" onsubmit = "return fvalidator()">
			<h1>New Address</h1>
			<h5 id = "message">Add data</h5>
			<input type = "text" name = "cstreet"  	id = "fstreet"  placeholder = "Street">
			<input type = "text" name = "cnumber" 	id = "fnumber" 	placeholder = "Number">
			<input type = "text" name = "ccity" 	id = "fcity" 	placeholder = "City">
			<input type = "text" name = "ccountry" 	id = "fcountry"	placeholder = "Country">
			<input type = "submit" id = "action" value = "Submit"><br>
			<input type = "button"  class = "button btnWarning" onclick = "location.href = 'MenuObtain'" value = "Return to Obtain Menu">
		</form>
	</body>
</html>