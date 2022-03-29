package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.CategoriaDTO;
import beans.ProductoDTO;
import interfaces.ProductoDAO;
import utils.MySQLConexion8;

public class MySQLProductoDAO implements ProductoDAO {

	@Override
	public int registrar(ProductoDTO p) {
		int rs=0;
		Connection con = null;

		  PreparedStatement ps = null;

		  try {
		   con = MySQLConexion8.getConexion();
		   
		   String sql = "Insert into tb_productos values(?,?,?,?,?,?,?,?)";// 6
		   ps = con.prepareStatement(sql);
		   ps.setString(1, p.getId());
		   ps.setString(2, p.getDescripcion());
		   ps.setInt(3, p.getStock());
		   ps.setDouble(4, p.getPrecio());
		   ps.setInt(5, p.getIdCategoria());
		   ps.setInt(6, p.getCod_prov());
		   ps.setString(7, p.getFcha_registro());
		   ps.setString(8, p.getFcha_vencimiento());
		   rs = ps.executeUpdate();

		  } catch (Exception e) {
		   System.out.println("Error al registrar producto. ->" + e.getMessage());

		  } finally {
		   MySQLConexion8.closeConexion(con);
		  }
		return rs;
	}

	@Override
	public int actualizar(ProductoDTO p) {
		int rs=0;
		Connection con = null;

		  PreparedStatement ps = null;

		  try {
		   con = MySQLConexion8.getConexion();
		   
		   String sql = "call usp_actualizarProducto(?,?,?,?,?,?,?,?)";
		   ps = con.prepareStatement(sql);		   
		   ps.setString(1, p.getId());
		   ps.setString(2, p.getDescripcion());
		   ps.setInt(3, p.getStock());
		   ps.setDouble(4, p.getPrecio());
		   ps.setInt(5, p.getIdCategoria());
		   ps.setInt(6, p.getCod_prov());
		   ps.setString(7, p.getFcha_registro());
		   ps.setString(8, p.getFcha_vencimiento());
		   rs = ps.executeUpdate();

		  } catch (Exception e) {
		   System.out.println("Error al Actualizar producto. ->" + e.getMessage());

		  } finally {
		   MySQLConexion8.closeConexion(con);
		  }
		return rs;
	}

	@Override
	public int eliminar(ProductoDTO p) {
		int rs=0;
		Connection con = null;

		  PreparedStatement ps = null;

		  try {
		   con = MySQLConexion8.getConexion();
		   
		   String sql = "delete from tb_productos where idprod=?";
		   ps = con.prepareStatement(sql);
		   ps.setString(1, p.getId());		  
		   rs = ps.executeUpdate();

		  } catch (Exception e) {
		   System.out.println("Error al Eliminar producto. ->" + e.getMessage());

		  } finally {
		   MySQLConexion8.closeConexion(con);
		  }
		return rs;
	}

	@Override
	public ArrayList<ProductoDTO> listado() {
		ArrayList<ProductoDTO> lista = new ArrayList<ProductoDTO>();
		
		//Plantilla
		Connection con = null;
		PreparedStatement ps = null;
		
		ResultSet rs = null;

		  try {
		   con = MySQLConexion8.getConexion();
		   
		   String sql = "select * from tb_productos";
		   ps = con.prepareStatement(sql);		 		  
		   rs = ps.executeQuery();
		   
		   while(rs.next()) {
			   //El orden de los números depende del resultado en sql
			   ProductoDTO p = new ProductoDTO(rs.getString(1), rs.getString(2),rs.getString(7),rs.getString(8),rs.getInt(3),rs.getInt(5),rs.getInt(6),rs.getDouble(4));
			   lista.add(p);
		   }

		  } catch (Exception e) {
		   System.out.println("Error al listar productos. ->" + e.getMessage());

		  } finally {
		   MySQLConexion8.closeConexion(con);
		  }
		
		return lista;
	}

	@Override
	public ArrayList<ProductoDTO> listadoxCategoria(int categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductoDTO buscar(String codigo) {
		ProductoDTO p = null;
		Connection con = null;
		//Plantilla		
		PreparedStatement ps = null;		
		ResultSet rs = null;

		  try {
		   con = MySQLConexion8.getConexion();
		   
		   String sql = "select * from tb_productos where idprod = ?";
		   ps = con.prepareStatement(sql);	
		   ps.setString(1, codigo);
		   
		   rs = ps.executeQuery();
		   
		   if(rs.next()) {			
			   //El orden de los números depende del resultado en sql
			  p = new ProductoDTO(rs.getString(1), rs.getString(2),rs.getString(7),rs.getString(8),rs.getInt(3),rs.getInt(5),rs.getInt(6),rs.getDouble(4));
		   }

		  } catch (Exception e) {
		   System.out.println("Error al buscar producto. ->" + e.getMessage());

		  } finally {
		   MySQLConexion8.closeConexion(con);
		  }
		return p ;
	}

	@Override
	public ArrayList<CategoriaDTO> listadoCategoria() {
		ArrayList<CategoriaDTO> lista = new ArrayList<CategoriaDTO>();		  
		  Connection con = null;
		  PreparedStatement ps = null;
		  ResultSet rs = null;
		  try {
		   con = MySQLConexion8.getConexion();
		   String sql = "select * from tb_categorias;";// 0
		   ps = con.prepareStatement(sql);
		   rs = ps.executeQuery();		
		   while (rs.next()) {
			   CategoriaDTO c = new CategoriaDTO();
			   c.setIdCategoria(rs.getInt(1));
			   c.setDescripcion(rs.getString(2));		   
		   lista.add(c);		   
		   }
		  } catch (Exception e) {
		   System.out.println("Error al listar categorias. ->" + e.getMessage());
		   
		  } finally {
		   MySQLConexion8.closeConexion(con);
		  }

		  return lista;
	}


	

}
