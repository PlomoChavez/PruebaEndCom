<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
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
<div class="container mt-4">
<label>Buscador</label>
<form:form action="agregar" method="POST" modelAttribute="pokemon">
<table>
        <tr>
            <td><form:label path="id">ID</form:label></td>
            <td><form:input path="id" readonly="true"/></td>
        </tr>
        <tr>
            <td><form:label path="apodo">Apodo</form:label></td>
            <td><form:input path="apodo"/></td>
        </tr>
        <tr>
            <td><form:label path="especie">Especie:</form:label></td>
            <td><form:input path="especie" readonly="true"/></td>
        </tr>
        <tr>
            <td><form:label path="tipo">Tipo:</form:label></td>
            <td><form:input path="tipo" readonly="true"/></td>
        </tr>
    </table>
<table>
        <tr>
            <td><form:label path="ataque">Ataque</form:label></td>
            <td><form:label path="defensa">Defensa</form:label></td>
            <td><form:label path="salud">Salud</form:label></td>
        </tr>
            <td><form:input path="ataque" readonly="true"/></td>
            <td><form:input path="defensa" readonly="true" /></td>
            <td><form:input readonly="true" path="salud" /></td>
        </tr>
        <tr>
            <td colspan="3" class="text-center"><input type="submit" class="btn btn-success" value="Agregar"/></td>
        </tr>
    </table>
</form:form>
</div>
</body>
</html>