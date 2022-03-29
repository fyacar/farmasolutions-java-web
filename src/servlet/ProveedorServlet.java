package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ProductoDTO;
import beans.ProveedorDTO;
import dao.DAOFactory;
import mantenimientos.MySQLProductoDAO;
import mantenimientos.MySQLProveedorDAO;

/**
 * Servlet implementation class ProveedorServlet
 */
@WebServlet(name = "prov", urlPatterns = { "/prov" })
public class ProveedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedorServlet() {
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
		System.out.println("Opción seleccionada: " + opc);
		
		switch (opc) {
		case "r": registrar(request, response); break;
		case "a": actualizar(request, response); break;
		case "e": eliminar(request, response); break;
		case "l": listar(request, response); break;
		case "c": cargar(request, response); break;
		case "q": buscar(request, response); break;		
		
		default:
			System.out.println("No seleccionó");
		}
		
	}

	private void cargar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró al proceso cargar");		
		
		// PARA USAR PATRÓN DAO SE DEBE HACER ESTO:
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ArrayList<ProveedorDTO> lista = fabrica.getProveedorDAO().listado();
		
		//enviar el listado al JSP
		request.setAttribute("lstProveedores", lista);
		request.getRequestDispatcher("listado-prove-man.jsp").forward(request, response);
		
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró al proceso listado");		
		
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ArrayList<ProveedorDTO> lista = fabrica.getProveedorDAO().listado();		
		
		request.setAttribute("lstProveedores", lista);
		request.getRequestDispatcher("listado-prove-man.jsp").forward(request, response);
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró a buscar el proveedor");
		String codigo = request.getParameter("cod");
		ProveedorDTO p = new MySQLProveedorDAO().buscar(codigo);
		request.setAttribute("p", p);
		request.getRequestDispatcher("crudProveedores.jsp").forward(request, response);
		
	}



	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ingresó al servlet de eliminación de Proveedor");		 
		 String mensaje ="";
		 String url="";
		 	int cod_prov = 0;		
		
		try {
			cod_prov = Integer.parseInt(request.getParameter("txtCodProd"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		// validaciones
			if (cod_prov==0) {
				mensaje += "<script>alert('" + "Debe ingresar un Código Válido" + "')</script>";				
				request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("crudProveedores.jsp").forward(request, response);
				return;
			}
			else {
			ProveedorDTO p = new ProveedorDTO();
			p.setCod_prov(cod_prov);;
			MySQLProveedorDAO gp = new MySQLProveedorDAO();
			int ok = gp.eliminar(p);			
			
			if(ok==0) {
				mensaje += "<script>alert('" + "Error al eliminar los datos del proveedor. Revisar" + "')</script>";
				url = "/crudProveedores.jsp";
			}
			else {
				mensaje += "<script>alert('" + "Se eliminaron los datos del Proveedor satisfactoriamente" + "')</script>";
				url = "/crudProveedores.jsp";
			}
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
		}

	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ingresó al servlet de actualización de Proveedor");
		 
		 String mensaje ="";
		 String url="";
				
			
			int cod_prov = 0;
			String nombre_pro, telefono, direccion, correo,	descripcion;
		
			try {
				cod_prov = Integer.parseInt(request.getParameter("txtCodProd"));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			nombre_pro = request.getParameter("txtNombre");
			telefono = request.getParameter("txtTelefono");
			direccion = request.getParameter("txtDireccion");
			correo =	request.getParameter("txtCorreo");
			descripcion= request.getParameter("txtDescripcion");
				
		
		// validaciones
			 if(!nombre_pro.matches("[A-Za-z ]{1,30}")) {				
				 mensaje += "<script>alert('" + "El nombre del Proveedor no debe estar vacío ni superar los 30 caracteres" + "')</script>";
				 request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("crudProveedores.jsp").forward(request, response);
				 return;
				}
			 else if(!telefono.matches("[0-9]{7,9}") ){
				 mensaje += "<script>alert('" + "Debe ingresar un número telfónico fijo (7 números) o un celular (9 números)" + "')</script>";
				 request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("crudProveedores.jsp").forward(request, response);
				 return;
			 }  else if(!correo.matches("^[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")) {				
				 mensaje += "<script>alert('" + "Debe ingresar un Correo Electrónico Válido" + "')</script>";
				 request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("crudProveedores.jsp").forward(request, response);
				 return;
				}
			else {	
				if(cod_prov==0) {
					 mensaje += "<script>alert('" + "Debe proporcionar un código de proveedor válido" + "')</script>";
					 request.setAttribute("mensaje", mensaje);
						request.getRequestDispatcher("crudProveedores.jsp").forward(request, response);
				}else {
		
			 ProveedorDTO p = new ProveedorDTO(cod_prov, nombre_pro, telefono, direccion, correo, descripcion);
			

				MySQLProveedorDAO gp = new MySQLProveedorDAO();
				int ok = gp.actualizar(p);	
			
			if(ok==0) {
				mensaje += "Error al actualizar los datos del Proveedor. Revisar";	
				url = "/crudProveedores.jsp";
			}
			else {
				mensaje += "<script>alert('" + "Se actualizaron los datos del Producto satisfactoriamente" + "')</script>";
				url = "/crudProveedores.jsp";
			}
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
		}
			}
}


	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ingresó al servlet de registro de Proveedor");
		 
		 String mensaje ="";
		 String url="";
				
			
			
			String nombre_pro, telefono, direccion, correo,	descripcion;
		
			
			nombre_pro = request.getParameter("txtNombre");
			telefono = request.getParameter("txtTelefono");
			direccion = request.getParameter("txtDireccion");
			correo =	request.getParameter("txtCorreo");
			descripcion= request.getParameter("txtDescripcion");
			
		
		// validaciones
			
			
			 if(!nombre_pro.matches("[A-Za-z ]{1,30}")) {				
				 mensaje += "<script>alert('" + "El nombre del Proveedor no debe estar vacío ni superar los 30 caracteres" + "')</script>";
				 request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("crudProveedores.jsp").forward(request, response);
				 return;
				}						
			 else if(!telefono.matches("[0-9]{7,9}") ){
				 mensaje += "<script>alert('" + "Debe ingresar un número telfónico fijo (7 números) o un celular (9 números)" + "')</script>";
				 request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("crudProveedores.jsp").forward(request, response);
				 return;
			 }  else if(!correo.matches("^[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")) {				
				 mensaje += "<script>alert('" + "Debe ingresar un Correo Electrónico Válido" + "')</script>";
				 request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("crudProveedores.jsp").forward(request, response);
				 return;
				} 
			else {			
		
				ProveedorDTO p = new ProveedorDTO(nombre_pro, telefono, direccion, correo, descripcion);
			
			
			MySQLProveedorDAO gp = new MySQLProveedorDAO();
			int ok = gp.registrar(p);
			
			if(ok==0) {
				mensaje += "Error al registrar los datos. Revisar";	
				url = "/crudProveedores.jsp";
			}
			else {
				mensaje += "<script>alert('" + "Registro satisfactorio del Proveedor" + "')</script>";
				url = "/crudProveedores.jsp";
			}
			
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

}


