package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import beans.TipoUsuarioDTO;
import interfaces.ComboCatUsrDAO;
import utils.MySQLConexion8;

public class MySQLComboCatUrsDAO implements ComboCatUsrDAO{

	@Override
	public ArrayList<TipoUsuarioDTO> listadoTiposUsuarios() {
		ArrayList<TipoUsuarioDTO> lista = new ArrayList<TipoUsuarioDTO>();		
		
		Connection con = null;
		PreparedStatement ps = null;		
		ResultSet rs = null;

		  try {
		   con = MySQLConexion8.getConexion();
		   
		   String sql = "select * from tb_tipo";
		   ps = con.prepareStatement(sql);		 		  
		   rs = ps.executeQuery();
		   
		   while(rs.next()) {			   
			   TipoUsuarioDTO tu = new TipoUsuarioDTO(rs.getInt(1), rs.getString(2));			 		  
			   lista.add(tu);
		   }

		  } catch (Exception e) {
		   System.out.println("Error al cargar datos del combo de Tipos de Usuario. ->" + e.getMessage());

		  } finally {
		   MySQLConexion8.closeConexion(con);
		  }
		
		return lista;
	}

}
