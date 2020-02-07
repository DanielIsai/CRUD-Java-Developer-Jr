<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Menu Person</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
	</head>
	<body>
		<form class = "box" method = "get" action = "Create" >
			<h1>People Menu</h1>
				<input type = "button"  value = "Create Person" class = "button btnGreen"	onclick = "location.href = 'Create'" >
				<input type = "button"  value = "Obtain People" class = "button btnBlue"	onclick = "location.href = 'MenuObtain'" >
				<input type = "button"  value = "Update Person" class = "button btnPurple"	onclick = "location.href = 'UpdateById'">
				<input type = "button"  value = "Delete Person" class = "button btnYellow"	onclick = "location.href = 'DeleteById'">
				<input type = "button"  value = "Delete All"	class = "button btnWarning"	onclick = "location.href = 'Validation?Page=DeleteAll&UUID=${UUID}'">
		</form>
	</body>
</html>