package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.interfaces.DaoCoche;

public class DaoCocheMySql implements DaoCoche {
	
	private Connection conexion;
	
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

	@Override
	public boolean alta(Coche c) {
		if(!abrirConexion()){
			return false;
		}
		boolean alta = true;
		
		String query = "insert into coches (MATRICULA,MARCA,MODELO,KILOMETROS) "
				+ " values(?,?,?,?)";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ps.setString(1, c.getMatricula());
			ps.setString(2, c.getMarca());
			ps.setString(3, c.getModelo());
			ps.setDouble(4, c.getKm());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0) {
				alta = false;
			}
			
		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + c);
			alta = false;
			//e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return alta;
	}

	@Override
	public boolean baja(int id) {
		if(!abrirConexion()){
			return false;
		}
		
		boolean borrado = true;
		String query = "delete from coches where id = ?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				borrado = false;
		} catch (SQLException e) {
			System.out.println("baja -> No se ha podido dar de baja"
					+ " el id " + id);
			//e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return borrado; 
	}

	@Override
	public boolean modificar(Coche c) {
		if(!abrirConexion()){
			return false;
		}
		boolean modificado = true;
		String query = "update coches set MATRICULA=?, MARCA=?, "
				+ "MODELO =?, KILOMETROS=? WHERE ID=?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, c.getMatricula());
			ps.setString(2, c.getMarca());
			ps.setString(3, c.getModelo());
			ps.setDouble(4, c.getKm());
			ps.setInt(5, c.getId());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				modificado = false;
			else
				modificado = true;
		} catch (SQLException e) {
			System.out.println("modificar -> error al modificar el "
					+ " coche " + c);
			modificado = false;
			//e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return modificado;
	}

	@Override
	public Coche obtenerID(int id) {
		if(!abrirConexion()){
			return null;
		}
		Coche coche = null;
		
		String query = "select ID,MATRICULA,MARCA,MODELO,KILOMETROS from coches "
				+ "where id = ?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				coche = new Coche();
				coche.setId(rs.getInt(1));
				coche.setMatricula(rs.getString(2));
				coche.setMarca(rs.getString(3));
				coche.setModelo(rs.getString(4));
				coche.setKm(rs.getDouble(5));
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener el "
					+ "coche con id " + id);
			//e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		return coche;
	}

	@Override
	public Coche obtenerMatricula(String matricula) {
		if(!abrirConexion()){
			return null;
		}
		Coche coche = null;
		
		String query = "select ID,MATRICULA,MARCA,MODELO,KILOMETROS from coches "
				+ "where matricula = ?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, matricula);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				coche = new Coche();
				coche.setId(rs.getInt(1));
				coche.setMatricula(rs.getString(2));
				coche.setMarca(rs.getString(3));
				coche.setModelo(rs.getString(4));
				coche.setKm(rs.getDouble(5));
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener el "
					+ "coche con matricula " + matricula);
			//e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		return coche;
	}

	@Override
	public List<Coche> obtenerMarca(String marca) {
		if(!abrirConexion()){
			return null;
		}
		Coche coche = null;
		List<Coche> listaCoches = new ArrayList<>();

		String query = "select ID,MATRICULA,MARCA,MODELO,KILOMETROS from coches "
				+ "where marca = ?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, marca);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				coche = new Coche();
				coche.setId(rs.getInt(1));
				coche.setMatricula(rs.getString(2));
				coche.setMarca(rs.getString(3));
				coche.setModelo(rs.getString(4));
				coche.setKm(rs.getDouble(5));
				
				listaCoches.add(coche);
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener los "
					+ "coches de marca " + marca);
			//e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		return listaCoches;
	}

	@Override
	public List<Coche> obtenerModelo(String modelo) {
		if(!abrirConexion()){
			return null;
		}
		Coche coche = null;
		List<Coche> listaCoches = new ArrayList<>();

		String query = "select ID,MATRICULA,MARCA,MODELO,KILOMETROS from coches "
				+ "where modelo = ?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, modelo);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				coche = new Coche();
				coche.setId(rs.getInt(1));
				coche.setMatricula(rs.getString(2));
				coche.setMarca(rs.getString(3));
				coche.setModelo(rs.getString(4));
				coche.setKm(rs.getDouble(5));
				
				listaCoches.add(coche);
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener los "
					+ "coches del modelo " + modelo);
			//e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		return listaCoches;
	}

	@Override
	public List<Coche> listar() {
		if(!abrirConexion()){
			return null;
		}		
		List<Coche> listaCoches = new ArrayList<>();
		
		String query = "select ID,MATRICULA,MARCA,MODELO,KILOMETROS from coches";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Coche coche = new Coche();
				coche.setId(rs.getInt(1));
				coche.setMatricula(rs.getString(2));
				coche.setMarca(rs.getString(3));
				coche.setModelo(rs.getString(4));
				coche.setKm(rs.getDouble(5));
				
				listaCoches.add(coche);
			}
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener los "
					+ "coches");
			//e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return listaCoches;
	}


}
