<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/libreria.tld" prefix="tools" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">  
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
   <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
   <link rel="stylesheet" type="text/css" href="css/principal.css">
   <title>Document</title>
</head>
<body>

    <div class="contenedorPrincipal">

        <header>
                <img class="bannerPrincipal" src="img/01.jpg" alt="">
        </header>

        <div class="menu">  
              
        	 <tools:Menu tipo="${u.tipo}"/>
               
        </div>
           
        <main>
                <h1 class="tituloCuerpo">FarmaSolutions</h1>
                <div class="contenedorFlexCuerpo">
                        <div class="flexItem">
                               <a class="enlaceTarjetas" href="registrar-usuario.jsp" style="color:black;"> 
                               <h2 class="tituloTarjetas">Regítrate</h2> 
                               </a>
                                <p>Regístrate y forma parte de la gran familia de FarmaSolutions.                               
                                Para nosotros es fundamental entregarte la mayor confianza a la hora de hacer segura tu compra y también en el momento que nos 
                                facilitas tus datos para podernos dirigirnos a ti y enviarte los pedidos. </p>
                        </div>
                        <div class="flexItem">
                        		<a class="enlaceTarjetas" href="login.jsp" style="color:black;"> 
                                <h2 class="tituloTarjetas">Inicia Sesión</h2>
                                </a>
                                <p>Inicia Sesión y comienza y aprovecha las mejores promociones en todos nuestros productos. Somos la cadena de farmacias más grande del Perú. Estamos para servirte.</p>
                        </div>
                        <div class="flexItem">
                        	<a class="enlaceTarjetas" href="prod?opcion=c" style="color:black;"> 
                                <h2 class="tituloTarjetas">Productos</h2>
                                </a>
                                <p>Te ofrecemos un gran catálogo en el que meticulosamente trabajamos a diario para que puedas disfrutar de las mejores marcas al mejor precio en todo momento y con toda la comodidad que te brinda FarmaSolutions.</p>
                        </div>
                        <div class="flexItem">
                                <h2 class="tituloTarjetas">Misión</h2>
                                <p>Nuestra misión es ofrecerte una asistencia sanitaria de calidad, ofrecerte servicios farmacéuticos y productos, de forma profesional, servicial y cercana.</p>
                        </div>
                        <div class="flexItem"> 
                                <h2 class="tituloTarjetas">Acerca de Nosotros</h2>
                                <p> FarmaSolutions es es una farmacia online que cuenta con una gran experiencia en servicio y atención al cliente, formado por un grupo de profesionales a tu disposición para darte y ofrecerte siempre lo mejor.</p>
                        </div>
                        <div class="flexItem">
                                <h2 class="tituloTarjetas">Contacto</h2>
                                <p>email: farmasolutions@contacto.com</p>
                                <p>teléfono: 924154879</p>                                
                                <p>Redes Sociales: @farmaSolutionsPe</p>
                        </div>
                       
                </div>
        </main>

        <footer>
        	<tools:Footer/> 
             	
        </footer>  
${mensaje}

    </div>

    
</body>
</html>