package modelo.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCocheMySql;

public class GestorCocheTest {

	/**
	 * Comprueba si se ha establecido conexión con la BBDD
	 */
	
	@Test
	public void conexionOkTest() {
		DaoCocheMySql dao = new DaoCocheMySql();
		assertEquals(true,dao.abrirConexion());
	}
	
	/**
	 * Comprueba si el id del coche obtenido en la BBDD es el mismo que el esperado
	 */
	
	@Test
	public void obtenerCocheIdOKTest() {
		
		int esperado = 5;
		DaoCocheMySql dao = new DaoCocheMySql();
		
		Coche c = dao.obtenerID(5);
		int obtenido = c.getId();
		
		assertEquals(esperado,obtenido);
	}
	
	
	/**
	 * Comprueba que no puede obtener un coche que no existe en la BBDD
	 */
	
	@Test
	public void obtenerCocheIdErrorTest() {
		
		DaoCocheMySql dao = new DaoCocheMySql();
		Coche c =  dao.obtenerID(1500);
		
		assertEquals(null,c);

	}
	
}
