package beans;

public class ProveedorDTO {
	
	int cod_prov;
	String nombre_pro, telefono, direccion, correo,	descripcion;
	
	
	public ProveedorDTO() {}
	
	
	public ProveedorDTO(int cod_prov, String nombre_pro, String telefono, String direccion, String correo,
			String descripcion) {
		super();
		this.cod_prov = cod_prov;
		this.nombre_pro = nombre_pro;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correo = correo;
		this.descripcion = descripcion;
	}
	

	public ProveedorDTO(String nombre_pro, String telefono, String direccion, String correo, String descripcion) {
		super();
		this.nombre_pro = nombre_pro;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correo = correo;
		this.descripcion = descripcion;
	}


	public int getCod_prov() {
		return cod_prov;
	}
	public void setCod_prov(int cod_prov) {
		this.cod_prov = cod_prov;
	}
	public String getNombre_pro() {
		return nombre_pro;
	}
	public void setNombre_pro(String nombre_pro) {
		this.nombre_pro = nombre_pro;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
