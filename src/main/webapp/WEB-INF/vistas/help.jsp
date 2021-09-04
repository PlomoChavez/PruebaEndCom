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

<body class="p-5">
	<div class="mt-4">
		<a href="/generacion?id=1" class="btn btn-primary">Gen 1</a>
		<a href="/generacion?id=2" class="btn btn-primary">Gen 2</a>
		<a href="/generacion?id=3" class="btn btn-primary">Gen 3</a>
		<a href="/generacion?id=4" class="btn btn-primary">Gen 4</a>
		<a href="/generacion?id=5" class="btn btn-primary">Gen 5</a>
		<a href="/generacion?id=6" class="btn btn-primary">Gen 6</a>
		<a href="/buscar" class="btn btn-success">Buscar por rango</a>
		<a href="/buscarNombre" class="btn btn-success">Buscar por nombre o id</a>
		<a href="/pokemons" class="btn btn-dark">Pokemonos almacenados</a>
		<a href="/help" class="btn btn-dark">Help</a>
	</div>
<div class="mt-4"><table>
        <tr>
            <td class="fw-bold">Nombre:</td>
            <td>Jesus Ramon Chavez Quiroz</td>
        </tr>
        <tr>
            <td class="fw-bold">Correo:</td>
            <td>jesus.r.chavez.q.94@gmail.com</td>
        </tr>
        <tr>
            <td class="fw-bold">Telefono:</td>
            <td>7442077733</td>
        </tr>
    </table>
</div>
</body>
</html>