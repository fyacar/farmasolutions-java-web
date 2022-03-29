package beans;

public class ProductoDTO {

	private String id, descripcion, fcha_registro, fcha_vencimiento;
	private int stock, idCategoria, cod_prov;
	private double precio;
	
	
	public ProductoDTO () {}
	
	
	public ProductoDTO(String id, String descripcion, String fcha_registro, String fcha_vencimiento, int stock,
			int idCategoria, int cod_prov, double precio) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fcha_registro = fcha_registro;
		this.fcha_vencimiento = fcha_vencimiento;
		this.stock = stock;
		this.idCategoria = idCategoria;
		this.cod_prov = cod_prov;
		this.precio = precio;
	}
	
	
	@Override
	public String toString() {
		return "ProductoDTO [id=" + id + ", descripcion=" + descripcion + ", fcha_registro=" + fcha_registro
				+ ", fcha_vencimiento=" + fcha_vencimiento + ", stock=" + stock + ", idCategoria=" + idCategoria
				+ ", cod_prov=" + cod_prov + ", precio=" + precio + "]";
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFcha_registro() {
		return fcha_registro;
	}
	public void setFcha_registro(String fcha_registro) {
		this.fcha_registro = fcha_registro;
	}
	public String getFcha_vencimiento() {
		return fcha_vencimiento;
	}
	public void setFcha_vencimiento(String fcha_vencimiento) {
		this.fcha_vencimiento = fcha_vencimiento;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public int getCod_prov() {
		return cod_prov;
	}
	public void setCod_prov(int cod_prov) {
		this.cod_prov = cod_prov;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	

		
	
}
	
	
	

