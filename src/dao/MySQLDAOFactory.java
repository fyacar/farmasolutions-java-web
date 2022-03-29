package dao;

import interfaces.ComboCatUsrDAO;
import interfaces.ProductoDAO;
import interfaces.ProveedorDAO;
import interfaces.UsuarioDAO;
import interfaces.VentaDAO;
import mantenimientos.MySQLComboCatUrsDAO;
import mantenimientos.MySQLProductoDAO;
import mantenimientos.MySQLProveedorDAO;
import mantenimientos.MySQLUsuarioDAO;
import mantenimientos.MySQLVentaDAO;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public ProductoDAO getProductoDAO() {
		// llamamos a las clases de implementación o Gestión (lo que va dentro del paquete de mantenimiento)
		return new MySQLProductoDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySQLUsuarioDAO(); //Implementación o gestión.
	}

	@Override
	public ComboCatUsrDAO getComboCatUsr() {
		// TODO Auto-generated method stub
		return new MySQLComboCatUrsDAO();
	}

	@Override
	public ProveedorDAO getProveedorDAO() {
		// TODO Auto-generated method stub
		return new  MySQLProveedorDAO();
	}

	@Override
	public VentaDAO getVentaDAO() {
		// TODO Auto-generated method stub
		return new MySQLVentaDAO();
	}

}