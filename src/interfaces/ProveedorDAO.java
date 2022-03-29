package interfaces;

import java.util.ArrayList;

import beans.ProveedorDTO;


public interface ProveedorDAO {
	public int registrar(ProveedorDTO p);	
	public int actualizar(ProveedorDTO p);
	public int eliminar(ProveedorDTO p);
	public ArrayList<ProveedorDTO> listado();
	public ProveedorDTO buscar(String cod_prov);
}
