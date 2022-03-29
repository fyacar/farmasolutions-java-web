<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/libreria.tld" prefix="tools"%>


 <!-- VALIDACIÓN -->
 
<%@ page import="beans.UsuarioDTO"%>  
<%
	UsuarioDTO u = (UsuarioDTO) request.getSession().getAttribute("u");
	if(u == null){
		response.sendRedirect("login.jsp");
	}
%>  



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
				<h2 class="subTituloCuerpo">Actualizar Datos de Usuario</h2>
				<br>
				<div style="margin-left: 20%; margin-right: 20%;">				
					
					<form action="us" method="post" id="frmBase">

						<div class="form-group">
							<label for="exampleInputEmail1">Código: </label> <input
								class="form-control" id="exampleInputEmail1" name="txtCodigo"
								aria-describedby="emailHelp" placeholder="Ingrese nombre"
								value="${u.codigo}" > <small
								id="emailHelp" class="form-text text-muted"></small>
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1">Nombre:</label> <input
								class="form-control" id="exampleInputEmail1" name="txtNombre"
								aria-describedby="emailHelp" placeholder="Ingrese nombre"
								value="${u.nombre}"> <small id="emailHelp"
								class="form-text text-muted"></small>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Apellidos:</label> <input
								class="form-control" id="exampleInputPassword1"
								name="txtApellidos" placeholder="Ingrese Apellidos"
								value="${u.apellido}">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Usuario: </label> <input
								type="email" class="form-control" id="exampleInputEmail1"
								name="txtUsuario" aria-describedby="emailHelp"
								placeholder="Ingrese su correo" value="${u.usuario}"
								> <small id="emailHelp"
								class="form-text text-muted"></small>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Contraseña:</label> <input
								type="password" class="form-control" id="exampleInputPassword1"
								name="txtClave" placeholder="Ingrese Password"
								value="${u.clave}">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Fecha de nacimiento: </label> <input
								type="date" class="form-control" id="exampleInputEmail1"
								name="txtFechaNacimiento" aria-describedby="emailHelp"
								placeholder="Año/Mes/Día" value="${u.fnacim}"> <small
								id="emailHelp" class="form-text text-muted"></small>
						</div>
						<div class="boton">
							<button type="Submit" class="btn btn-primary" name="opcion"
								value="a">Actualizar</button>
						</div>

					</form>


				</div>
			</div>
		</main>

		<footer>
			<tools:Footer />

		</footer>
		${mensaje}
	</div>
</body>