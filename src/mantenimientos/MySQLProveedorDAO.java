package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.ProductoDTO;
import beans.ProveedorDTO;
import interfaces.ProveedorDAO;
import utils.MySQLConexion8;

public class MySQLProveedorDAO implements ProveedorDAO{

	@Override
	public int registrar(ProveedorDTO p) {
		int rs=0;
		//plantilla		
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion8.getConexion();			
			String sql ="insert into tb_proveedores values(null, ?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, p.getNombre_pro());			
			pst.setString(2, p.getTelefono());
			pst.setString(3, p.getDireccion());
			pst.setString(4, p.getCorreo());
			pst.setString(5, p.getDescripcion());
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("error al registrar Proveedor" + e.getMessage());
		} finally {
			MySQLConexion8.closeConexion(con);
		}				
		return rs;
	}

	@Override
	public int actualizar(ProveedorDTO p) {
		int rs=0;
		//plantilla		
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion8.getConexion();			
			String sql ="{call usp_actualizarProveedor(?,?,?,?,?,?)}";
			pst = con.prepareStatement(sql);
			pst.setInt(1, p.getCod_prov());
			pst.setString(2, p.getNombre_pro());			
			pst.setString(3, p.getTelefono());
			pst.setString(4, p.getDireccion());
			pst.setString(5, p.getCorreo());
			pst.setString(6, p.getDescripcion());
			rs = pst.executeUpdate();
				
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("error al actualizar " + e.getMessage());
		} finally {
			MySQLConexion8.closeConexion(con);
		}				
		return rs;
	}

	@Override
	public int eliminar(ProveedorDTO p) {
		int rs=0;
		Connection con = null;

		  PreparedStatement ps = null;

		  try {
		   con = MySQLConexion8.getConexion();
		   
		   String sql = "delete from tb_proveedores where cod_prov=?";
		   ps = con.prepareStatement(sql);
		   ps.setInt(1, p.getCod_prov());		  
		   rs = ps.executeUpdate();

		  } catch (Exception e) {
		   System.out.println("Error al eliminar Proveedor. ->" + e.getMessage());

		  } finally {
		   MySQLConexion8.closeConexion(con);
		  }
		return rs;
	}

	@Override
	public ArrayList<ProveedorDTO> listado() {
		ArrayList<ProveedorDTO> lista = new ArrayList<ProveedorDTO>();
		
		//Plantilla
		Connection con = null;
		PreparedStatement ps = null;
		
		ResultSet rs = null;

		  try {
		   con = MySQLConexion8.getConexion();
		   
		   String sql = "select * from tb_proveedores";
		   ps = con.prepareStatement(sql);		 		  
		   rs = ps.executeQuery();
		   
		   while(rs.next()) {			   
			   ProveedorDTO p = new ProveedorDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			   lista.add(p);
		   }

		  } catch (Exception e) {
		   System.out.println("Error al listar Proveedores. ->" + e.getMessage());

		  } finally {
		   MySQLConexion8.closeConexion(con);
		  }
		
		return lista;
	}

	@Override
	public ProveedorDTO buscar(String cod_prov) {
		ProveedorDTO p = null;
		Connection con = null;
		//Plantilla		
		PreparedStatement ps = null;		
		ResultSet rs = null;

		  try {
		   con = MySQLConexion8.getConexion();
		   
		   String sql = "select * from tb_proveedores where cod_prov = ?";
		   ps = con.prepareStatement(sql);	
		   ps.setString(1, cod_prov);
		   
		   rs = ps.executeQuery();
		   
		   if(rs.next()) {			
			   //El orden de los números depende del resultado en sql
			   p = new ProveedorDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		   }

		  } catch (Exception e) {
		   System.out.println("Error al buscar Proveedor. ->" + e.getMessage());

		  } finally {
		   MySQLConexion8.closeConexion(con);
		  }
		return p ;
	}

}
