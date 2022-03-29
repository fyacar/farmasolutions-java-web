package beans;

public class CategoriaDTO {

	private int idCategoria;
	private String descripcion;
	
	public CategoriaDTO() {}
	
	
	public CategoriaDTO(int int1, String string) {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "categoriaDTO [idCategoria=" + idCategoria + ", descripcion=" + descripcion + "]";
	}
	
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
