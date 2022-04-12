package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Coche;

public interface DaoCoche {

	boolean alta(Coche c);
	boolean baja(int id);
	boolean modificar(Coche c);
	Coche obtenerID(int id);
	Coche obtenerMatricula(String matricula);
	List<Coche> obtenerMarca(String marca);
	List<Coche> obtenerModelo(String modelo);
	List<Coche> listar();

}
