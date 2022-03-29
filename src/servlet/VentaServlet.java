package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CabeceraBoletaDTO;
import beans.DetalleBoletaDTO;
import beans.ProductoDTO;
import beans.UsuarioDTO;
import dao.DAOFactory;

/**
 * Servlet implementation class VentaServlet
 */
@WebServlet(name = "venta", urlPatterns = { "/venta" })
public class VentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentaServlet() {
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
		
		case "a": agregarCompra(request, response); break;
		case "e": eliminarCompra(request, response); break;
		case "f": finalizarCompra(request, response); break;
		case "c": cargar(request, response); break;
		default:
			System.out.println("No seleccionó");
		}
		
		
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

	private void finalizarCompra(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Ingresó al proceo: Finalizar Compra");
		String mensaje, url;
		
		//obtenemos atributos a nivel de sesion
		UsuarioDTO u = (UsuarioDTO) request.getSession().getAttribute("u");
		//validación de usuario logeado
		if(u==null) {
			response.sendRedirect("login.jsp");
			return;
		}
		
		ArrayList<DetalleBoletaDTO> carro = (ArrayList<DetalleBoletaDTO>)request.getSession().getAttribute("carro");
		
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		
		//Crea objeto cabecara de boleta
		CabeceraBoletaDTO cab = new CabeceraBoletaDTO();
		cab.setNum_bol(fabrica.getVentaDAO().generaBoleta()); //mediante Gestión o DAO
		cab.setCod_cliente(u.getCodigo()); //del acceso al sistema		
		
		//Realiza la grabación de la venta
		int rs = fabrica.getVentaDAO().realizarVenta(cab, carro);
			
		
		if(rs==0) {
			request.getSession().setAttribute("mensaje", "<script>alert('Error en la transacción')</script>");
			
		} else {
			request.getSession().setAttribute("mensaje", "<script>alert('transacción Realizada')</script>");
		
			request.getSession().setAttribute("carro", new ArrayList<DetalleBoletaDTO>() );
			request.getSession().setAttribute("subTotalVenta", 0.0);
			request.getSession().setAttribute("cantArticulos", 0);							
		}	
		response.sendRedirect("canasta.jsp");
		
	}

	private void eliminarCompra(HttpServletRequest request, HttpServletResponse response) throws IOException {	
		System.out.println("Entró al Servlet Venta - opción Eliminar");
		
		
		ArrayList<DetalleBoletaDTO> carro = (ArrayList<DetalleBoletaDTO>)request.getSession().getAttribute("carro");
		int cantArticulos = (int)request.getSession().getAttribute("cantArticulos");
		double subTotalVenta = (double) request.getSession().getAttribute("subTotalVenta");
		
		
		String idprod = request.getParameter("cod");		
		
		
		for(DetalleBoletaDTO d : carro) {
			if(d.getIdprod().equals(idprod)) {
				subTotalVenta -= d.getImporte();
				cantArticulos -= d.getCantidad();
				carro.remove(d);
				break;
			}
		}
		
		//volver a enviar las variables globales
		
		request.getSession().setAttribute("carro", carro);
		request.getSession().setAttribute("subTotalVenta", subTotalVenta);
		request.getSession().setAttribute("cantArticulos", cantArticulos);
		System.out.println("-- Enviando Variables a nivel de sesión --");
		
		//enviar a la página
		
		response.sendRedirect("canasta.jsp");
		
	}

	private void agregarCompra(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Entró al Servlet Venta - opción Agregar");
		//lee la cantidad enviada desde compra.jsp
		int cant = Integer.parseInt(request.getParameter("cantidad"));
		//obtener el producto enviado a nivel de sesion
		ProductoDTO p = (ProductoDTO) request.getSession().getAttribute("p");
		
		//obtenemos las variables globales a actualizar
		ArrayList<DetalleBoletaDTO> carro = (ArrayList<DetalleBoletaDTO>)request.getSession().getAttribute("carro");
		int cantArticulos = (int)request.getSession().getAttribute("cantArticulos");
		double subTotalVenta = (double) request.getSession().getAttribute("subTotalVenta");
		
		//actualizar
		DetalleBoletaDTO d = new DetalleBoletaDTO();
		d.setIdprod(p.getId());
		d.setNomprod(p.getDescripcion());
		d.setCantidad(cant);
		d.setPreciovta(p.getPrecio());
		d.setImporte(cant * p.getPrecio());
		
		
		//Agregamos el nuevo detalle al carro
		carro.add(d);
		cantArticulos += d.getCantidad();
		subTotalVenta += d.getImporte();
		
		//volver a enviar las variables globales
		
		request.getSession().setAttribute("carro", carro);
		request.getSession().setAttribute("subTotalVenta", subTotalVenta);
		request.getSession().setAttribute("cantArticulos", cantArticulos);
		System.out.println("-- Enviando Variables a nivel de sesión --");
		
		//enviar a la página
		
		response.sendRedirect("canasta.jsp");
		
	}

}
