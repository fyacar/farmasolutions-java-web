<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/libreria.tld" prefix="tools"%>

 <!-- VALIDACIÓN -->
 
<%@ page import="beans.UsuarioDTO"%>  
<%
	UsuarioDTO u = (UsuarioDTO) request.getSession().getAttribute("u");
	if(u == null){
		 request.setAttribute("mensaje", "<script>alert('No ha iniciado Sesión')</script>");
		response.sendRedirect("login.jsp");
		
	}else if(u.getTipo()!=1){
		 request.setAttribute("mensaje", "<script>alert('Debe ser Administrador para ingresar al Mantenimiento')</script>");
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
<link rel="stylesheet" type="text/css" href="css/mantenimiento.css">
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
				<br><br>
			                <div class="enlacesImagen">

                    <div class="divImg">
                        <a class="imgEnlaces" href="prod?opcion=l" style="color:blue;">
                            <figure>
                                <img class="imgMantenimiento" src="img/mantenimiento.png">
                                <figcaption>
                                    Mantenimiento de Productos
                                </figcaption>
                            </figure>
                        </a>
                    </div>
                    <div class="divImg">
                        <a class="imgEnlaces" href="prov?opcion=l" style="color:blue;">
                            <figure>
                                <img class="imgMantenimiento" src="img/mantenimiento.png">
                                <figcaption>
                                    Mantenimiento de Proveedores
                                </figcaption>
                            </figure>
                        </a>
                    </div>
                    <div class="divImg">
                        <a class="imgEnlaces" href="actualiza-datos.jsp" style="color:blue;">
                            <figure>
                                <img class="imgMantenimiento" src="img/mantenimiento.png">
                                <figcaption>
                                    Actualización de Usuario
                                </figcaption>
                            </figure>
                        </a>
                    </div>                    
                </div>	
			
			</div>
		</main>

		<footer>
			<tools:Footer />

		</footer>


	</div>


</body>
</html>