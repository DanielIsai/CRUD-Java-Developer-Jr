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
		<form class = "box" method = "post" action = "detailsAddressUpdate?UUID=${UUID}&id=${id}" onsubmit = "return fvalidator()">
			<h1>Update Address</h1>
			<h5 id = "message">Add data</h5>
			<input type = "text" name = "cstreet"  	id = "fstreet"  value = "${street}">
			<input type = "text" name = "cnumber" 	id = "fnumber" 	value = "${number}">
			<input type = "text" name = "ccity" 	id = "fcity" 	value = "${city}">
			<input type = "text" name = "ccountry" 	id = "fcountry"	value = "${country}">
			<input type = "submit" id = "action" value = "Submit"><br>
			<input type = "button"  class = "button btnWarning" onclick = "location.href = 'MenuObtain'" value = "Return to Obtain Menu">
		</form>
	</body>
</html>