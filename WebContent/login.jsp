<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/libreria.tld" prefix="tools"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">  
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
       <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
       <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
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
                   <img class="logoMenu" src="img/portada.png">
                   <h2 class="tituloAmarillo">FarmaSolutions</h2>
                   <p class="frase">Porque aquí queremos lo mejor para ti</p>                  
            </div>
               
            <main>
                <h1 class="tituloCuerpo">FarmaSolutions</h1>
                <h2 class="subTituloCuerpo">Login</h2>
                
                <div style="margin-left: 20%; margin-right: 20%;">
		<h2>Acceso al sistema</h2>
		<form action="us" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Usuario: </label> <input
					type="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Ingrese su correo"
					name="txtUsuario"> <small id="emailHelp"
					class="form-text text-muted"></small>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Contraseña :</label> <input
					name="txtClave" type="password" class="form-control"
					id="exampleInputPassword1" placeholder="Ingrese Password">
			</div>
			<div class="boton">
				<button type="Submit" class="btn btn-primary" name="opcion"
					value="i">Ingresar</button>
			</div>
		</form>
	<br>
		<p>
			Para registrar su cuenta pulse <a href="registrar-usuario.jsp" style="color: blue;">aquí</a>
		</p>
		<p>
			Para Regresar a la ventana principal pulse <a href="principal.jsp" style="color: blue;">aquí</a>
		</p>
		<br>
		<%--muestra el atributo enviado desde el servlet --%>
		${mensaje}


	</div>
                
                
                   
            </main>
    
            <footer>
                    <div id="imgredes">
                            <a target="_blank" href="https://www.facebook.com/"><img class="redes" src="img/facebook.png" alt=""></a>
                                    
                            <a target="_blank" href="https://www.instagram.com/"><img class="redes" src="img/instagram.png" alt=""></a>
                                    
                            <a target="_blank" href="https://twitter.com"><img class="redes" src="img/twiterr.png" alt=""></a>	
                            
                    </div>	
                    <p class="textoFooter">Derechos reservados - 2021</p>
            </footer>  
    
    
        </div>
    
        
    </body>
</html>