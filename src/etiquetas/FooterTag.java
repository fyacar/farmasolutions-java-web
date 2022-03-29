package etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class FooterTag extends TagSupport {

	public int doStartTag() throws JspException {	
		
		JspWriter out = pageContext.getOut();
		try {
			out.println("<div id=\"imgredes\">");
			out.println("<a target=\"_blank\" href=\"https://www.facebook.com/\"><img class=\"redes\" src=\"img/facebook.png\" alt=\"\"></a>");
			out.println("<a target=\"_blank\" href=\"https://www.instagram.com/\"><img class=\"redes\" src=\"img/instagram.png\" alt=\"\"></a>");
			out.println("<a target=\"_blank\" href=\"https://twitter.com\"><img class=\"redes\" src=\"img/twiterr.png\" alt=\"\"></a>");
			out.println("</div>");
			out.println("<p class=\"textoFooter\">Derechos reservados - 2021</p>");			
		} catch (IOException e) {
			System.out.println("Error en inicio de FooterTag: " + e.getMessage());			
		}
		
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;

	}
	
	
}
