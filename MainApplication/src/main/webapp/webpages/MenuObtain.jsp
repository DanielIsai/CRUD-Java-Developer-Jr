<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Menu Obtain</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
	</head>
	<body>
		<form class = "box" method = "get" action = "Create" >
			<h1>Obtain Menu</h1>
				<input type = "button"  value = "Obtain All" 		class = "button btnAqua"	onclick = "location.href = 'ObtainAll'" >
				<input type = "button"  value = "Obtain by Id" 		class = "button btnGreen" 	onclick = "location.href = 'ObtainById'" >
				<input type = "button"  value = "Obtain by Name"	class = "button btnBlue" 	onclick = "location.href = 'ObtainByName'">
				<input type = "button"  value = "Advanced Search"	class = "button btnYellow"	onclick = "location.href = 'AdvancedSearch'">
				<br>
				<input type = "button"  value = "Return to Menu"	class = "button btnWarning" onclick = "location.href = 'Menu'" >
		</form>
	</body>
</html>