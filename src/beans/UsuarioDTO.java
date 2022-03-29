package beans;

public class UsuarioDTO {

		private int codigo, tipo;
		private String nombre, apellido, usuario, clave, fnacim;
		
		public UsuarioDTO() {}	
		
		
		public UsuarioDTO(int codigo, int tipo, String nombre, String apellido, String usuario, String clave,
				String fnacim) {
			super();
			this.codigo = codigo;
			this.tipo = tipo;
			this.nombre = nombre;
			this.apellido = apellido;
			this.usuario = usuario;
			this.clave = clave;
			this.fnacim = fnacim;
		}


		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public int getTipo() {
			return tipo;
		}

		public void setTipo(int tipo) {
			this.tipo = tipo;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getClave() {
			return clave;
		}

		public void setClave(String clave) {
			this.clave = clave;
		}

		public String getFnacim() {
			return fnacim;
		}

		public void setFnacim(String fnacim) {
			this.fnacim = fnacim;
		}		

	
		
	
}
