package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.ProveedorDTO;
import dao.DAOFactory;

public class ComboProveedorTag extends TagSupport{
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			ArrayList<ProveedorDTO> lista= fabrica.getProveedorDAO().listado();
			out.println("<option value='-1' > Seleccione</option>");	
			for (ProveedorDTO p : lista) {
				out.println("<option value='"+ p.getCod_prov() +"'>" + p.getNombre_pro()+"</option>");				
			}
			
		} catch (IOException e) {
			System.out.println("Error en inicio de ComboProveedorTag: " + e.getMessage());			
		}
		
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;

	}
}
