package modelo.negocio;

import modelo.entidad.Usuario;
import modelo.persistencia.DaoUsuario;

public class GestorUsuario {

	/**
	 * Este método valida si un usuario esta registrado en el sistema
	 * @param usuario a validar
	 * @return 0 en caso de que el usuario este validado, 1 en caso de
	 * que el usuario no exista y un 2 en caso de que el usuario y el 
	 * password sean incorectos.
	 */
	public int validarUsuario(Usuario usuario) {
		DaoUsuario du = new DaoUsuario();
		Usuario user = du.obtenerUsuarioNombre(usuario.getNombre());
		
		if(user == null) {
			return 1;
		}
		
		if(user.getPass().equals(usuario.getPass())) {
			return 0;
		}else {
			return 2;
		}
	}
	
	/*
	 * Inserta usuarios de ejemplo en la BBDD
	 */
	public void insertarUsuarios() {
		DaoUsuario du = new DaoUsuario();
		Usuario user = null;
		user = new Usuario ("Jose","1234");
		du.insertarUsuario(user);
		
		user = new Usuario ("Alberto","5678");
		du.insertarUsuario(user);
		
		user = new Usuario ("Maria","2468");
		du.insertarUsuario(user);
	}
	
	public boolean insertarUsuario(Usuario usuario) {
		DaoUsuario du = new DaoUsuario();
		return du.insertarUsuario(usuario);
		
	}
	
	/**
	 * Comprueba que el usuario Jose esta en la BBDD
	 * @return true si el usuario esta en la BBDD, false en caso contrario
	 */
	
	public boolean hayUsuarios(){
		DaoUsuario du = new DaoUsuario();
		Usuario user = du.obtenerUsuarioNombre("Jose");
		return (user != null);
	}
}
