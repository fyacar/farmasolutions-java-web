package interfaces;

import java.util.ArrayList;

import beans.CategoriaDTO;
import beans.ProductoDTO;
import beans.CategoriaDTO;

public interface ProductoDAO {
	public int registrar(ProductoDTO p);
	public int actualizar(ProductoDTO p);
	public int eliminar(ProductoDTO p);
	public ArrayList<ProductoDTO> listado();
	public ArrayList<ProductoDTO> listadoxCategoria(int categoria); //recibir� el tipo de categor�a.
	public ProductoDTO buscar(String codigo);
	public ArrayList<CategoriaDTO> listadoCategoria();
}
