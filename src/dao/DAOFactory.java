package dao;

import interfaces.ComboCatUsrDAO;
import interfaces.ProductoDAO;
import interfaces.ProveedorDAO;
import interfaces.UsuarioDAO;
import interfaces.VentaDAO;

// Fabrica las implementaciones de las gestiones.
public abstract class DAOFactory {

	//Constantes que sirven para saber con qué BD o fuentes se puede trabajar.
	public static final int MYSQL = 1; 
	public static final int SQL = 2;
	public static final int ORACLE = 3;

	// Qué interfaces (ahora llamadas DAOs) voy a utilizar
	//deberemos tener un método get por cada DAO (interfaz).
	
	public abstract ProductoDAO getProductoDAO();
	public abstract UsuarioDAO getUsuarioDAO();
	public abstract ComboCatUsrDAO getComboCatUsr();
	public abstract ProveedorDAO getProveedorDAO();
	public abstract VentaDAO getVentaDAO();
	
	
	//Este método va a indicar con qué BD vamos a trabajar
	
		public static DAOFactory getDAOFactory(int qBD) {

			switch (qBD) {
			case MYSQL:
				return new MySQLDAOFactory();  // Clase que va a construir las interfaces o DAO con MYSQL (se crea dentro del paquete DAO)
			// otros

			default:
				return null;
			}
		}


}