<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prueba de EndCom</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

</head>
<body>
<div class="container mt-4">
<table class="table">
<thead>
	<tr>
		<th>Id</th>
		<th>Nombre</th>
		<th>Actions</th>
	</tr>
</thead>
<tbody>
<c:forEach var="persona" items="${personas}">
	<tr>
		<td>${persona.name}</td>
		<td>${persona.url}</td>
		<td>
			<a class="btn btn-warning">Editar</a>
			<a class="btn btn-danger">Eliminar</a>
		</td>
	</tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>