<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/libreria.tld" prefix="tools"%>
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
				<h2 class="subTituloCuerpo">Carrito de Compra</h2>
				<br>
				<div style="margin-left: 3%; margin-right: 3%;">

					<c:if test="${cantArticulos == 0}">
					<h2 class="subTituloCuerpo" style="display:inline-block;">Tu Carrito Está Vacío</h2>
					<a href="prod?opcion=c" class="btn btn-primary" style="margin-left:15px;">Realizar
							compra <span class="glyphicon glyphicon-repeat"></span>
						</a><br>
					<img src="img/carritoVacio.png" style="display: block; margin:auto; margin-top:20px; height: 300px;" >
						
						
					</c:if>

					<c:if test="${cantArticulos != 0}">

						<div style="width: 70%; height: auto; float: left;">
							

							<%-- Mostrar listado de los detalles --%>


							<table class="table table-hover">
								<thead>
									<tr>
										<th></th>
										<th>Nombre</th>
										<th>Cantidad</th>
										<th>Precio</th>
										<th>Importe</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${carro}" var="d">
										<tr class="grilla_campo">
											<td><img alt="imagen"
												src="img/productos/${d.idprod}.png" height="60px"
												width="60px">
											</td>
											<td>${d.nomprod}</td>
											<td>${d.cantidad}</td>
											<td><fmt:setLocale value="es_PE" /> <fmt:formatNumber
													type="currency" value="${d.preciovta}" />
											</td>
											<td><fmt:setLocale value="es_PE" /> <fmt:formatNumber
													type="currency" value="${d.importe}" /></td>
											<td>
												<!-- Primera forma para eliminar (con el método post los datosno se muestran en la url) -->
												<form action="venta" method="post">
													<input type="hidden" name="cod" value="${d.idprod}">
													<button class="btn btn-danger" name="opcion" value="e">Eliminar</button>
												</form> 
											</td>
											<td></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

							<br> <a href="prod?opcion=c" class="btn btn-primary">Continuar
								comprando <span class="glyphicon glyphicon-repeat"></span>
							</a>

						</div>
						<div
							style="width: 29%; height: 400px; float: left; border: 1px solid; padding:10px;">
							<h2 class="subTituloCuerpo">Resumen de pedido</h2>
							<hr>
							<%-- muestra la variable global enviada desde el Listener --%>
							<label>Cantidad de Artículos:  (${cantArticulos})
							</label>
							<label>Sub total: <fmt:setLocale
									value="es_PE" /> <fmt:formatNumber type="currency"
									value="${subTotalVenta}" />

							</label>
							<hr>
							<form action="venta" method="post">
								<button class="btn btn-primary" name="opcion" value="f">
									Procesar compra <span class="glyphicon glyphicon-ok"></span>
								</button>
							</form>


						</div>

					</c:if>



				</div>
			</div>
		</main>

		<footer>
			<tools:Footer />

		</footer>
	${mensaje}
	</div>
</body>