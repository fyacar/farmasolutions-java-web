package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ProductoDTO;
import beans.UsuarioDTO;
import dao.DAOFactory;
import mantenimientos.MySQLUsuarioDAO;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet(name = "us", urlPatterns = { "/us" })
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opc = request.getParameter("opcion");
		
		//opc = (opc==null) ? "cerrar" : opc;
		
		System.out.println("Opci�n seleccionada: " + opc);
		
		// Seg�n la opci�n... 
		
		switch (opc) {
		case "r": {
					registro(request, response); break;
		}
		case "i": {
				ingreso(request, response); break;
		}
		case "a": {
				actualizar(request, response); break;
		}
		case "s":{
			salir(request, response); break;
		}

		
		default:
			System.out.println("Cerrando la sesi�n actual");
			System.out.println("ID sesion.............: " + request.getSession().getId());
			System.out.println("----------------------------------");
			request.getSession().invalidate();
			response.sendRedirect("login.jsp");
					}
	}

	private void salir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		UsuarioDTO us = (UsuarioDTO) request.getSession().getAttribute("u");
				
		if(us == null) {
//			 request.setAttribute("mensaje", "<script>alert('No ha iniciado Sesi�n')</script>");
			 request.getRequestDispatcher("principal.jsp").forward(request, response);
			 return;
		}
		request.getSession().invalidate();
        request.setAttribute("mensaje", "<script>alert('Sesi�n Finalizada')</script>");
        request.getRequestDispatcher("principal.jsp").forward(request, response);
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 System.out.println("ingres� al servlet de Actualizaci�n de informaci�n de Usuario");
		 
		 String mensaje ="";
		 String url;
		 
		int codigo = -1; 
		String nombre, apellidos, clave, fechaNacimiento;
		
		try {
			codigo = Integer.parseInt(request.getParameter("txtCodigo"));
		} catch (NumberFormatException e) {
			 mensaje += "<script>alert('" + "Debe ingresar un c�digo V�lido" + "')</script>";
			 request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("actualiza-datos.jsp").forward(request, response);
			e.printStackTrace();
		}
		nombre = request.getParameter("txtNombre");
		apellidos = request.getParameter("txtApellidos");	
		clave = request.getParameter("txtClave");
		fechaNacimiento= request.getParameter("txtFechaNacimiento");
	
			
		 if(!fechaNacimiento.matches("^\\d{4}([\\-/.])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$")) {
			 mensaje += "<script>alert('" + "Debe ingresar el formato de fecha correcto" + "')</script>";
			 request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("actualiza-datos.jsp").forward(request, response);
			 return;
				}
		 else if(!nombre.matches("[A-Za-z]{1,15}")) {				
			 mensaje += "<script>alert('" + "El nombre no debe estar vac�o ni superar los 15 caracteres" + "')</script>";
			 request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("actualiza-datos.jsp").forward(request, response);
			 return;
			}
		 else if(!apellidos.matches("[A-Za-z]{1,25}")) {				
			 mensaje += "<script>alert('" + "El Apellido no debe estar vac�o ni superar los 25 caracteres" + "')</script>";
			 request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("actualiza-datos.jsp").forward(request, response);
			 return;
			}
		 else if(!clave.matches("[A-Za-z0-9]{1,6}") ){
			 mensaje += "<script>alert('" + "La clave no puede estar vac�a y debe contener hasta 6 caracteres alfanum�ricos" + "')</script>";
			 request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("actualiza-datos.jsp").forward(request, response);
			 return;
		 } else if(codigo==0 ){
			 mensaje += "<script>alert('" + "Ingrese un c�digo v�lido" + "')</script>";
			 request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("actualiza-datos.jsp").forward(request, response);
			 return;
		 } 
		else {
			UsuarioDTO u = new UsuarioDTO();
			u.setCodigo(codigo);
			u.setNombre(nombre);
			u.setApellido(apellidos);			
			u.setClave(clave);
			u.setFnacim(fechaNacimiento);	
			System.out.println(
					"Codigo: " + codigo+ "\n" +
					"Nombre: "+ nombre +"\n" + 
					"Apellidos: "+ apellidos +"\n" +					
					"Clave: "+ clave +"\n" +					
					"Fecha de Nacimiento: "+ fechaNacimiento +"\n"			
					);
			
			//Procesos
			
			MySQLUsuarioDAO gu = new MySQLUsuarioDAO();
			int ok = gu.actualizar(u);
			
			if(ok==0) {
				mensaje += "Error al Actualizar los datos. Revisar";
				url = "actualiza-datos.jsp";
			}
			else {
				mensaje += "<script>alert('" + "Usuario <strong>" + nombre + " </strong> Actualizado Correctamente" + "')</script>";
				url = "login.jsp";
			}
		}

		
		//salidaS
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	private void ingreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hola Mundo, soy un servlet");
		String url="login.jsp";
		String mensaje="";
		
		HttpSession miSesion = request.getSession();
		System.out.println("Id de sesion: ...............: " + miSesion.getId());
		System.out.println("Fecha y hora de creaci�n ....: " + new SimpleDateFormat().format(miSesion.getCreationTime()));
		System.out.println("Tiempo m�ximo inactividad ...: " + miSesion.getMaxInactiveInterval());
				
		
		//leer campos de entrada
		String usuario = request.getParameter("txtUsuario");
		String clave = request.getParameter("txtClave");
		
		if(!usuario.matches("^[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")) {				
			 mensaje += "<script>alert('" + "Debe ingresar un Correo Electr�nico V�lido" + "')</script>";
			 request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			 return;
			} else if(!clave.matches("[A-Za-z0-9]{1,6}") ){
				 mensaje += "<script>alert('" + "La clave no puede estar vac�a y debe contener hasta 6 caracteres alfanum�ricos" + "')</script>";
				 request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				 return;
			 } 	
		
		else {
		
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		UsuarioDTO u = fabrica.getUsuarioDAO().validar(usuario, clave);
		
		
		if(u !=null) {
		url = "principal.jsp";		
		request.getSession().setAttribute("u", u);
		
	}	else {	
		request.setAttribute("mensaje", "<script>alert('Usuario o clave incorrectos')</script>");
	}
		request.getRequestDispatcher(url).forward(request, response);
		}
	}

	private void registro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 System.out.println("ingres� al servlet de registro de usuario");
		 
		 String mensaje ="";
		 String url;
		int tipo;
		String nombre, apellidos, usuario, clave, fechaNacimiento;
		
		nombre = request.getParameter("txtNombre");
		apellidos = request.getParameter("txtApellidos");
		usuario = request.getParameter("txtUsuario");
		clave = request.getParameter("txtClave");
		fechaNacimiento= request.getParameter("txtFechaNacimiento");
		tipo = Integer.parseInt(request.getParameter("cboTipo"));
		
		
		 if(!fechaNacimiento.matches("^\\d{4}([\\-/.])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$")) {
			 mensaje += "<script>alert('" + "Debe ingresar el formato de fecha correcto" + "')</script>";
			 request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("registrar-usuario.jsp").forward(request, response);
			 return;
				}
		 else if(!nombre.matches("[A-Za-z]{1,15}")) {				
			 mensaje += "<script>alert('" + "El nombre no debe estar vac�o ni superar los 15 caracteres" + "')</script>";
			 request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("registrar-usuario.jsp").forward(request, response);
			 return;
			}
		 else if(!apellidos.matches("[A-Za-z]{1,25}")) {				
			 mensaje += "<script>alert('" + "El Apellido no debe estar vac�o ni superar los 25 caracteres" + "')</script>";
			 request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("registrar-usuario.jsp").forward(request, response);
			 return;
			}
		 else if(!usuario.matches("^[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")) {				
			 mensaje += "<script>alert('" + "Debe ingresar un Correo Electr�nico V�lido" + "')</script>";
			 request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("registrar-usuario.jsp").forward(request, response);
			 return;
			}
		 else if(!clave.matches("[A-Za-z0-9]{1,6}") ){
			 mensaje += "<script>alert('" + "La clave no puede estar vac�a y debe contener hasta 6 caracteres alfanum�ricos" + "')</script>";
			 request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("registrar-usuario.jsp").forward(request, response);
			 return;
		 }  else if(tipo == -1){
			 mensaje += "<script>alert('" + "Debe elegir un Tipo de Usuario" + "')</script>";
			 request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("registrar-usuario.jsp").forward(request, response);
			 return;
		 } 
		else {
			UsuarioDTO u = new UsuarioDTO();				
			u.setNombre(nombre);
			u.setApellido(apellidos);
			u.setUsuario(usuario);
			u.setClave(clave);
			u.setFnacim(fechaNacimiento);
			u.setTipo(tipo);
			
			System.out.println("Nombre: "+ nombre +"\n" + 
					"Apellidos: "+ apellidos +"\n" +
					"Usuario: "+ usuario +"\n" +
					"Clave: "+ clave +"\n" +
					"Fecha de Nacimiento: "+ fechaNacimiento +"\n"+
					"Tipo: "+ tipo +"\n" 
					);
			
			//Procesos
			
			MySQLUsuarioDAO gu = new MySQLUsuarioDAO();
			int ok = gu.registrar(u);
			
			if(ok==0) {
				mensaje += "Error al registrar los datos. Revisar";
				url = "/registrar.jsp";
			}
			else {
				mensaje += "<script>alert('" + "Registro del usuario <strong>" + nombre + " </strong> OK, ingrese al sistema" + "')</script>";
				url = "/login.jsp";
			}
		}

		
		//salidaS
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
