package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.TipoUsuarioDTO;
import dao.DAOFactory;

public class ComboTipoUsuarioTag extends TagSupport{
	
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			ArrayList<TipoUsuarioDTO> lista= fabrica.getComboCatUsr().listadoTiposUsuarios();
			out.println("<option value='-1' > Seleccione</option>");	
			for (TipoUsuarioDTO tu : lista) {
				out.println("<option value='"+ tu.getId_tipo() +"'>" + tu.getDes_tipo()+"</option>");				
			}
			
		} catch (IOException e) {
			System.out.println("Error en inicio de Combo ComboTipoUsuarioTag: " + e.getMessage());			
		}
		
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;

	}

}
