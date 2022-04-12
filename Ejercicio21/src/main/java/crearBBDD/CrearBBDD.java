package crearBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBBDD {
	
	private Connection conexion;

	public boolean abrirConexion(){
		String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = "";
		
		try {
			conexion = DriverManager.getConnection(cadenaConexion, user, pass);
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean cerrarConexion(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean crearBBDD() {
		if(!abrirConexion()){
			return false;
		}
		boolean estaCreada = true;
		
		try {
			Statement state = conexion.createStatement();
			state.execute("CREATE TABLE `usuarios` ("
					+ "  `id` int NOT NULL AUTO_INCREMENT,"
					+ "  `nombre` varchar(20) DEFAULT NULL UNIQUE,"
					+ "  `contraseña` varchar(20) DEFAULT NULL,"
					+ "   PRIMARY KEY (`id`)"
					+ ");");
			
		} catch (SQLException e) {
			System.out.println("alta -> Error al crear: ");
			estaCreada = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return estaCreada;
	}
	
	public static void main(String[] args) {
		CrearBBDD cdb = new CrearBBDD();
		cdb.crearBBDD();
	}
	
	
}