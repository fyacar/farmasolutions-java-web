package interfaces;

import beans.UsuarioDTO;

public interface UsuarioDAO {

	public int registrar(UsuarioDTO u);
	public UsuarioDTO validar(String usuario, String clave);
	public int actualizar(UsuarioDTO u);
	
}
