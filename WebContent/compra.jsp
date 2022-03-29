<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<h2 class="subTituloCuerpo">Formulario de Compras</h2>
				<br>
				<div style="margin-left: 20%; margin-right: 20%;">
					<fieldset>
						<form action="venta" method="post">
							<table>
								<tr>
									<td>
										<table >
											<tr >
												<td><img alt="" src="img/productos/${p.id}.png"
													width="200px" height="200px"></td>
											</tr>
										</table>
									</td>

									<td>
										<table style="margin-left: 20px;">
											<tr>
												<td><label>Cod producto:</label></td>
												<td><label>${p.id}</label> 
											</tr>
											<tr>
												<td>Descripción :</td>
												<td><label>${p.descripcion}</label></td>
											</tr>
											<tr>
												<td>Precio :</td>
												<td><label><fmt:setLocale value="es_PE" /> <fmt:formatNumber
															type="currency" value="${p.precio}" /> </label></td>
											</tr>
											<tr>
												<td>Cantidad a comprar :   </td>
												<td><input type="number" value="1" name="cantidad"
													min="1" max=""></td>
											</tr>

											<tr>
												<td>
													<button class="btn btn-primary" name="opcion" value="a">
														Agregar compra <span
															class="glyphicon glyphicon-shopping-cart"></span>
													</button>
												</td>
											</tr>

										</table>
									</td>

								</tr>
							</table>


						</form>
					</fieldset>
				</div>
			</div>
		</main>

		<footer>
			<tools:Footer />

		</footer>
	</div>
</body>