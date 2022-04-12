package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.entidad.Usuario;

public class DaoUsuario {
	
	private Connection conexion;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver para MySQL");
		}
	}
	
	public boolean abrirConexion(){
		String url = "jdbc:mysql://localhost:3306/bbdd";
		String usuario = "root";
		String password = "";
		try {
			conexion = DriverManager.getConnection(url,usuario,password);
		} catch (SQLException e) {
			//e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean cerrarConexion(){
		try {
			conexion.close();
		} catch (SQLException e) {
			//e.printStackTrace();
			return false;
		}
		return true;
	}
	

	public boolean insertarUsuario(Usuario u) {
		if(!abrirConexion()){
			return false;
		}
		boolean alta = true;
		
		String query = "insert into usuarios (NOMBRE,CONTRASEÑA) "
				+ " values(?,?)";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, u.getNombre());
			ps.setString(2, u.getPass());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0) {
				alta = false;
			}
			
		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + u);
			alta = false;
			//e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return alta;
	}

	/**
	 * Metodo que obtiene un usuario segun nombre
	 * @param nombre de usuario
	 * @return null si el usuario no existe o no se ha establecido conexion con la BBDD, usuario si el usuario existe en la BBDD
	 */
	public Usuario obtenerUsuarioNombre(String nombre) {
		if(!abrirConexion()){
			return null;
		}
		Usuario usuario = null;
		
		String query = "select ID,NOMBRE,CONTRASEÑA from usuarios "
				+ "where nombre = ?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, nombre);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				usuario = new Usuario();
				usuario.setId(rs.getInt(1));
				usuario.setNombre(rs.getString(2));
				usuario.setPass(rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener el "
					+ "usuario con nombre " + nombre);
			//e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		return usuario;
		
	}


}
