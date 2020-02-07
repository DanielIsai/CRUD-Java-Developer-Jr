<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/DataTables/datatables.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/DataTables/DataTables-1.10.20/css/dataTables.bootstrap.min.css">
		<link rel = "stylesheet" href = "${pageContext.request.contextPath}/resources/css/styles.css"/>
		<script type="text/javascript" charset="utf8" src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" charset="utf8" src="${pageContext.request.contextPath}/DataTables/datatables.js"></script>
		<script type="text/javascript" charset="utf8" src="${pageContext.request.contextPath}/DataTables/DataTables-1.10.20/js/dataTables.bootstrap.min.js"></script>
		<script>
			$(document).ready( function () {
    		$('#data').DataTable();
			} );
		</script>
	</head>
	<body>
		<br>
		<br>
		<br>
		<h1>List Obtained</h1>
		<br>
		<h2>${message}</h2>
		<div class="person-table">
		<table id="data"  class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>EMAIL</th>
					<th>PHONE</th>
					<th>ADDRESS</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var = "items" items = "${listPeople}">
					<tr>
						<td> <c:out value = "${items.id}"/></td>
						<td> <c:out value = "${items.name}"/></td>
						<td> <c:out value = "${items.email}"/></td>
						<td> <c:out value = "${items.phone}"/></td>
						<td>
							<a href = "Add?UUID=${items.id}">Add</a> <a href = "View?UUID=${items.id}&Name=${items.name}">View</a> 
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		<input type = "button"  class = "button btnWarning" onclick = "location.href = 'MenuObtain'" value = "Return to Obtain Menu">
	</body>
</html>