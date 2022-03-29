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
import dao.DAOFactory;
import mantenimientos.MySQLProductoDAO;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet(name = "prod", urlPatterns = { "/prod" })
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoServlet() {
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
		case "s": seleccionar(request, response); break;
		
		default:
			System.out.println("No seleccionó");
		}
		
	}

	private void seleccionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtiene la información del producto y la envía a la página compra
		
		System.out.println("Entró a buscar el producto");
		String codigo = request.getParameter("cod");
		ProductoDTO p = new MySQLProductoDAO().buscar(codigo);
		request.getSession().setAttribute("p", p);
		//request.getRequestDispatcher("compra.jsp").forward(request, response);
		response.sendRedirect("compra.jsp");
	}

	private void cargar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró al proceso cargar");		
		
		// PARA USAR PATRÓN DAO SE DEBE HACER ESTO:
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ArrayList<ProductoDTO> lista = fabrica.getProductoDAO().listado();
		
		//enviar el listado al JSP
		request.setAttribute("lstProductos", lista);
		request.getRequestDispatcher("catalogo.jsp").forward(request, response);
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró a buscar el producto");
		String codigo = request.getParameter("cod");
		ProductoDTO p = new MySQLProductoDAO().buscar(codigo);
		request.setAttribute("p", p);
		request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró al proceso listado");
		
		//obtener el listado de los productos. derectamente de la gestión (sin usar Patrón DAO)
		//ArrayList<ProductoDTO> lista = new MySQLProductoDAO().listado();
		
		// PARA USAR PATRÓN DAO SE DEBE HACER ESTO:
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ArrayList<ProductoDTO> lista = fabrica.getProductoDAO().listado();
		
		//enviar el listado al JSP
		request.setAttribute("lstProductos", lista);
		request.getRequestDispatcher("listado-prod-man.jsp").forward(request, response);
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ingresó al servlet de eliminación de Producto");		 
		 String mensaje ="";
		 String url="";
		 	String id;		
		
		id = request.getParameter("txtCodProd");		
		// validaciones
		
		if(!id.matches("[P][0-9]{5}")) {				
			 mensaje += "<script>alert('" + "Debe ingresar un código válido" + "')</script>";
			 request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
			 return;
	}else {
		
			ProductoDTO p = new ProductoDTO();
			p.setId(id);
			MySQLProductoDAO gp = new MySQLProductoDAO();
			int ok = gp.eliminar(p);			
			
			if(ok==0) {
				mensaje += "Error al actualizar los datos del producto. Revisar";
				url = "/crudProductos.jsp";
			}
			else {
				mensaje += "<script>alert('" + "Se eliminaron los datos del Producto satisfactoriamente" + "')</script>";
				url = "/crudProductos.jsp";
			}
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
		}
	}



	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ingresó al servlet de actualización de Producto");
		 
		 String mensaje ="";
		 String url="";		
			
			String id, descripcion, fcha_registro, fcha_vencimiento;
			int stock = 0, idCategoria = -1, cod_prov = -1;
			double precio = 0;
		
			id = request.getParameter("txtCodProd");
			descripcion = request.getParameter("txtDescripcion");
			try {
				stock = Integer.parseInt(request.getParameter("txtStock"));
			} catch (NumberFormatException e) {
				 mensaje += "<script>alert('" + "Debe ingresar un valor númerico al stock" + "')</script>";
				 request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
				e.printStackTrace();
			}
			fcha_registro = request.getParameter("txtFch_registro");
			fcha_vencimiento =	request.getParameter("txtFch_vencimiento");
			try {
				precio= Double.parseDouble(request.getParameter("txtPrecio"));
			} catch (NumberFormatException e) {
				 mensaje += "<script>alert('" + "Debe ingresar un valor númerico al precio" + "')</script>";
				 request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
				e.printStackTrace();
			}
			try {
				idCategoria = Integer.parseInt(request.getParameter("cboCategoria"));
			} catch (NumberFormatException e) {
				 mensaje += "<script>alert('" + "Debe ingresar un valor válido" + "')</script>";
				 request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
				e.printStackTrace();
			}
			try {
				cod_prov= Integer.parseInt(request.getParameter("cboProveedor"));
			} catch (NumberFormatException e) {
				 mensaje += "<script>alert('" + "Debe ingresar un valor válido" + "')</script>";
				 request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
				e.printStackTrace();
			}
			
		
		
		// validaciones
			
			if(!descripcion.matches("[A-Za-z ]{1,45}")) {				
				 mensaje += "<script>alert('" + "La descripción del Producto no debe estar vacía ni superar los 45 caracteres" + "')</script>";
				 request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
				 return;		 
			} else if(!id.matches("[P][0-9]{5}")) {				
					 mensaje += "<script>alert('" + "Debe ingresar un código válido" + "')</script>";
					 request.setAttribute("mensaje", mensaje);
						request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
					 return;
			}else if(stock <= 0) {				
					 mensaje += "<script>alert('" + "El stock debe ser mayor 0" + "')</script>";
					 request.setAttribute("mensaje", mensaje);
						request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
					 return;
				}
			else if(precio <= 0) {				
					 mensaje += "<script>alert('" + "El Precio debe ser mayor a 0" + "')</script>";
					 request.setAttribute("mensaje", mensaje);
						request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
					 return;
				}	
			else if(idCategoria == -1) {				
					 mensaje += "<script>alert('" + "Debe seleccionar una Categoría" + "')</script>";
					 request.setAttribute("mensaje", mensaje);
						request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
					 return;
				}
			else if(cod_prov == -1) {				
					 mensaje += "<script>alert('" + "Debe seleccionar una Proveedor" + "')</script>";
					 request.setAttribute("mensaje", mensaje);
						request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
					 return;
				}
			else if(!fcha_registro.matches("^\\d{4}([\\-/.])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$")) {
				 mensaje += "<script>alert('" + "Debe ingresar el formato de fecha correcto" + "')</script>";
				 request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
				 return;
					}	
			else if(!fcha_vencimiento.matches("^\\d{4}([\\-/.])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$")) {
						 mensaje += "<script>alert('" + "Debe ingresar el formato de fecha correcto" + "')</script>";
						 request.setAttribute("mensaje", mensaje);
							request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
						 return;
							}
				else {
			
		 ProductoDTO p = new ProductoDTO(id, descripcion,fcha_registro,fcha_vencimiento,stock,idCategoria,cod_prov,precio);
			

			MySQLProductoDAO gp = new MySQLProductoDAO();
			int ok = gp.actualizar(p);			
			
			if(ok==0) {
				mensaje += "Error al actualizar los datos del producto. Revisar";	
				url = "/crudProductos.jsp";
			}
			else {
				mensaje += "<script>alert('" + "Se actualizaron los datos del Producto satisfactoriamente" + "')</script>";
				url = "/crudProductos.jsp";
			}
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
	}
	
	}


	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ingresó al servlet de registro de Producto");
		 
		 String mensaje ="";
		 String url="";
				
			
			String id, descripcion, fcha_registro, fcha_vencimiento;
			int stock = 0, idCategoria = -1, cod_prov = -1;
			double precio = 0;
		
			id = request.getParameter("txtCodProd");
			descripcion = request.getParameter("txtDescripcion");
			try {
				stock = Integer.parseInt(request.getParameter("txtStock"));
			} catch (NumberFormatException e) {
				 mensaje += "<script>alert('" + "Debe ingresar un valor númerico al stock" + "')</script>";
				 request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
				e.printStackTrace();
			}
			fcha_registro = request.getParameter("txtFch_registro");
			fcha_vencimiento =	request.getParameter("txtFch_vencimiento");
			try {
				precio= Double.parseDouble(request.getParameter("txtPrecio"));
			} catch (NumberFormatException e) {
				 mensaje += "<script>alert('" + "Debe ingresar un valor númerico al precio" + "')</script>";
				 request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
				e.printStackTrace();
			}
			try {
				idCategoria = Integer.parseInt(request.getParameter("cboCategoria"));
			} catch (NumberFormatException e) {
				 mensaje += "<script>alert('" + "Debe ingresar un valor válido" + "')</script>";
				 request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
				e.printStackTrace();
			}
			try {
				cod_prov= Integer.parseInt(request.getParameter("cboProveedor"));
			} catch (NumberFormatException e) {
				 mensaje += "<script>alert('" + "Debe ingresar un valor válido" + "')</script>";
				 request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
				e.printStackTrace();
			}
			
	
		
	if(!descripcion.matches("[A-Za-z ]{1,45}")) {				
		 mensaje += "<script>alert('" + "La descripción del Producto no debe estar vacía ni superar los 45 caracteres" + "')</script>";
		 request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
		 return;		 
	} else if(!id.matches("[P][0-9]{5}")) {				
			 mensaje += "<script>alert('" + "Debe ingresar un código válido" + "')</script>";
			 request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
			 return;
	}else if(stock <= 0) {				
			 mensaje += "<script>alert('" + "El stock debe ser mayor 0" + "')</script>";
			 request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
			 return;
		}
	else if(precio <= 0) {				
			 mensaje += "<script>alert('" + "El Precio debe ser mayor a 0" + "')</script>";
			 request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
			 return;
		}	
	else if(idCategoria == -1) {				
			 mensaje += "<script>alert('" + "Debe seleccionar una Categoría" + "')</script>";
			 request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
			 return;
		}
	else if(cod_prov == -1) {				
			 mensaje += "<script>alert('" + "Debe seleccionar una Proveedor" + "')</script>";
			 request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
			 return;
		}
	else if(!fcha_registro.matches("^\\d{4}([\\-/.])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$")) {
		 mensaje += "<script>alert('" + "Debe ingresar el formato de fecha correcto" + "')</script>";
		 request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
		 return;
			}	
	else if(!fcha_vencimiento.matches("^\\d{4}([\\-/.])(0?[1-9]|1[1-2])\\1(3[01]|[12][0-9]|0?[1-9])$")) {
				 mensaje += "<script>alert('" + "Debe ingresar el formato de fecha correcto" + "')</script>";
				 request.setAttribute("mensaje", mensaje);
					request.getRequestDispatcher("crudProductos.jsp").forward(request, response);
				 return;
					}
		else {
		
		 ProductoDTO p = new ProductoDTO(id, descripcion,fcha_registro,fcha_vencimiento,stock,idCategoria,cod_prov,precio);
			
			
			MySQLProductoDAO gp = new MySQLProductoDAO();
			int ok = gp.registrar(p);
			
			if(ok==0) {
				mensaje += "Error al registrar los datos. Revisar";	
				url = "/crudProductos.jsp";
			}
			else {
				mensaje += "<script>alert('" + "Registro satisfactorio del Producto" + "')</script>";
				url = "/crudProductos.jsp";
			}
			
			request.setAttribute("mensaje", mensaje);
			request.getRequestDispatcher(url).forward(request, response);
		}
	
	}
}


