package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.UsuarioDTO;
import interfaces.UsuarioDAO;
import utils.MySQLConexion8;

public class MySQLUsuarioDAO implements UsuarioDAO {

	@Override
	public int registrar(UsuarioDTO u) {
		int rs=0;
		//plantilla		
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion8.getConexion();			
			String sql ="insert into tb_usuarios values(null, ?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, u.getNombre());
			pst.setString(2, u.getApellido());
			pst.setString(3, u.getUsuario());
			pst.setString(4, u.getClave());
			pst.setString(5, u.getFnacim());
			pst.setInt(6, u.getTipo());
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("error al registrar " + e.getMessage());
		} finally {
			MySQLConexion8.closeConexion(con);
		}				
		return rs;
	}

	@Override
	public UsuarioDTO validar(String usuario, String clave) {
		UsuarioDTO u = null;
		Connection con = null;

		  PreparedStatement ps = null;
		  ResultSet rs;
		  try {
		   con = MySQLConexion8.getConexion();
		   String sql = "{call usp_validaAcceso(?,?)}";// 2
		   ps = con.prepareStatement(sql);
		   ps.setString(1, usuario);
		   ps.setString(2, clave);
		   
		   rs = ps.executeQuery();
		   
		   if(rs.next()) {
			   
			  u = new UsuarioDTO(rs.getInt(1), rs.getInt(7), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		  
		   }

		  } catch (Exception e) {
		   System.out.println("Error en el login. " + e.getMessage());
		  } finally {
		   MySQLConexion8.closeConexion(con);
		  }
		  return u;
	}

	@Override
	public int actualizar(UsuarioDTO u) {
		int rs=0;
		//plantilla		
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion8.getConexion();			
			String sql ="{call usp_actualizarUsuario(?,?,?,?,?)}";
			pst = con.prepareStatement(sql);
			pst.setInt(1, u.getCodigo());
			pst.setString(2, u.getNombre());
			pst.setString(3, u.getApellido());		
			pst.setString(4, u.getClave());
			pst.setString(5, u.getFnacim());
				
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("error al actualizar " + e.getMessage());
		} finally {
			MySQLConexion8.closeConexion(con);
		}				
		return rs;
	}

}
