package etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MenuTag extends TagSupport {
	
	//Atributo
		//Por defecto serán tipo cliente (valor 2 (según la BD))
		//Lo declaramos tipo entero porque ese es el valor que sale en el beans.
	private int tipo =  3;	

	public int doStartTag() throws JspException {
		
		
		JspWriter out = pageContext.getOut();
		try {
			out.println("<img class=\"logoMenu\" src=\"img/portada.png\">");
			out.println("<h2 class=\"tituloAmarillo\">FarmaSolutions</h2>");
			out.println(" <p class=\"frase\">Porque aquí queremos lo mejor para ti</p>");
			out.println("<ul>");
			out.println("<li class=\"enlacesMenu\"><a href=\"principal.jsp\">Inicio</a> </li>");
			out.println("<li class=\"enlacesMenu\"><a href='login.jsp'>Iniciar Sesion</a></li>");
			out.println("<li class=\"enlacesMenu\"><a href='prod?opcion=c'>Catálogo</a> </li>");
			out.println("<li class=\"enlacesMenu\"><a href='canasta.jsp'>Carrito</a></li>");			
			//out.println("<li class=\"enlacesMenu\"><a href='compra.jsp'>Compra</a> </li>");	
			if(tipo!=3 || tipo!=2) {
			out.println("<li class=\"enlacesMenu\"><a href='mantenimiento.jsp'>Mantenimiento</a></li>");
			out.println("<li class=\"enlacesMenu\"><a href='us?opcion=s'>Cerrar sesión</a></li>");
			}
			
			out.println("</ul>");
			
		} catch (IOException e) {
			System.out.println("Error en inicio de MenuTag: " + e.getMessage());			
		}
		
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;

	}
	
	// gets y sets del atributo tipo

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


}
