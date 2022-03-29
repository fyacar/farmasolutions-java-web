package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.CategoriaDTO;
import dao.DAOFactory;

public class ComboCategoriaTag extends TagSupport {
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			ArrayList<CategoriaDTO> lista= fabrica.getProductoDAO().listadoCategoria();
			out.println("<option value='-1' > Seleccione</option>");	
			for (CategoriaDTO c : lista) {
				out.println("<option value='"+ c.getIdCategoria() +"'>" +c.getDescripcion()+"</option>");				
			}
			
		} catch (IOException e) {
			System.out.println("Error en inicio de cabeceraTag: " + e.getMessage());			
		}
		
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;

	}
}
