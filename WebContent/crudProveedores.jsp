<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/libreria.tld" prefix="tools"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
				<h2 class="subTituloCuerpo">Mantenimiento de Proveedores</h2>
				<div style="margin-left: 20%; margin-right: 20%;">
					<br> <br>
					<form action="prov" method="post">
						<div class="form-group">
							<label for="exampleInputEmail1">Código: </label> <input
								class="form-control" id="exampleInputEmail1" name="txtCodProd"
								value="${p.cod_prov}" aria-describedby="emailHelp"
								placeholder="código autogenerado"> <small id="emailHelp"
								class="form-text text-muted"></small>
						</div>
						<div class="form-group">
							<label for="">Nombre:</label> <input
								class="form-control" id="exampleInputPassword1"
								name="txtNombre" value="${p.nombre_pro}"
								placeholder="Ingrese Nombre del Proveedor">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Descripción</label> <input
								class="form-control" id="exampleInputPassword1"
								name="txtDescripcion" value="${p.descripcion}"
								placeholder="Ingrese descripción del proveedor">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Teléfono</label> <input
								class="form-control" id="exampleInputPassword1"
								name="txtTelefono" value="${p.telefono}"
								placeholder="Ingrese Télefono del proveedor">
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1">Correo: </label> <input
								type="email" class="form-control" id="exampleInputEmail1"
								name="txtCorreo" aria-describedby="emailHelp"  value="${p.correo}"
								placeholder="Ingrese su correo"> <small id="emailHelp"
								class="form-text text-muted"></small>
						</div>
						<div class="form-group">

							<label for="exampleInputPassword1">Direccion</label> <input
								class="form-control" id="exampleInputPassword1"
								placeholder="Ingrese Dirección" name="txtDireccion" value="${p.direccion}">
						</div>					
						<br>

						<button type="submit" class="btn btn-primary" name="opcion"
							value="r">Registrar</button>

						<button type="submit" class="btn btn-primary" name="opcion"
							value="a">Actualizar</button>

						<button type="submit" class="btn btn-danger" name="opcion"
							value="e">Eliminar</button>	

					</form>
					<form action="prov" method="post">
					<button type="submit" class="btn btn-warning" name="opcion" value="l">Listado</button>
					</form>
					${mensaje}
					
					<br>
					<br>



				</div>
			</div>
		</main>

		<footer>
			<tools:Footer />

		</footer>


	</div>


</body>
</html>