<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/libreria.tld" prefix="tools"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/principal.css">
<link rel="stylesheet" type="text/css" href="css/paginas.css">
<!-- DataTable  -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
<script	src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"> </script>
<title>Document</title>
</head>
<body>

	<div class="contenedorPrincipal">

		<header>
			<img class="bannerPrincipal" src="img/01.jpg" alt="">
		</header>

		<div class="menu">

			<tools:Menu tipo="${u.tipo}" />

		</div>

		<main>
			<br> <br>
			<div class="container">
			 	<h1 class="tituloCuerpo">FarmaSolutions</h1>
                <h2 class="subTituloCuerpo">Listado de Proveedores</h2>
				
				<a class="btn btn-primary" href="prov?opcion=l" style='margin-left: 30px; margin-top:20px;'>Ver data</a>				
				
				<br> <br>
				<table class="table" id="myTable">
					<tr>
						<th></th>
						<th>C?digo</th>
						<th>Nombre</th>
						<th>Tel?fono</th>
						<th>Correo</th>
						<th>Descripci?n</th>
						<th></th>						
					</tr>
					<c:forEach items="${lstProveedores}" var="p">
						<tr class="grilla_campo">
							<td></td>
							<td>${p.cod_prov}</td>	
							<td>${p.nombre_pro}</td>
							<td>${p.telefono}</td>
							<td>${p.correo}</td>
							<td>${p.descripcion}</td>
							<td><a href="prov?cod=${p.cod_prov}&opcion=q" style="color:blue;">Realizar
									Mantenimiento</a></td>							
						</tr>
					</c:forEach>

				</table>
				
			</div>
		</main>

		<footer>
			<tools:Footer />

		</footer>


	</div>


</body>

<script>
$(document).ready( function () {
    $('#myTable').DataTable();
} );
</script>
</html>