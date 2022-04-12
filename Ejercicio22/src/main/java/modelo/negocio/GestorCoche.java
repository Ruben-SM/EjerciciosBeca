package modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.gson.Gson;

import modelo.entidad.Coche;
import modelo.persistencia.interfaces.DaoCoche;
import modelo.persistencia.DaoCocheMySql;

public class GestorCoche {
	
	private DaoCoche daoCoche = new DaoCocheMySql();
	
	/**
	 * Metodo que da de alta un coche en base de datos. La matricula 
	 * debe de tener una longitud de 7, los km >= 0 y no puede haber matriculas repetidas.
	 * @param c el coche a dar de alta
	 * @return 0 en caso de que hayamos dado de alta el coche, 1 en caso
	 * de algun error de conexión con la bbdd y 2 en caso de que el coche
	 * no cumpla los requisitos
	 */
	public int alta(Coche c){
		if( (c.getMatricula().length() == 7) && (c.getKm() >= 0)) {
			boolean alta = daoCoche.alta(c);
			if(alta) {
				return 0;
			}else {
				return 1;
			}
		}else {
			return 2;
		}
	}
	
	public boolean baja(int id){
		boolean baja = daoCoche.baja(id);
		return baja;
	}
	
	/**
	 * Metodo que da modifica un coche en base de datos. La matricula 
	 * debe de tener una longitud de 7 y los km >= 0 y no puede haber matriculas repetidas.
	 * La modificación sera a partir del id del coche
	 * @param c el coche a modificar. Dentro tiene que tener el id
	 * @param id 
	 * @return 0 en caso de que hayamos modificado el coche, 1 en caso
	 * de algun error de conexión con la bbdd y 2 en caso de que el coche
	 * no cumpla los requisitos
	 */
	public int modificar(Coche c){
		if((c.getMatricula().length() == 7) && (c.getKm()>=0)) {
			boolean modificada = daoCoche.modificar(c);
			if(modificada) {
				return 0;
			}else {
				return 1;
			}
		}
		return 2;
	}
	
	public Coche obtenerID(int id){
		Coche coche = daoCoche.obtenerID(id);
		return coche;
	}
	
	public Coche obtenerMatricula(String matricula) {
		Coche coche = daoCoche.obtenerMatricula(matricula);
		return coche;
	}
	
	public List<Coche> obtenerMarca(String marca){
		List<Coche> listaCoches = daoCoche.obtenerMarca(marca);
		return listaCoches;
	}
	
	public List<Coche> obtenerModelo(String modelo){
		List<Coche> listaCoches = daoCoche.obtenerModelo(modelo);
		return listaCoches;
	}
	
	public List<Coche> listar(){
		List<Coche> listaCoches = daoCoche.listar();
		return listaCoches;
	}
	
	/**
	 * Metodo que convierte todos los coches de la BBDD en formato json
	 * @return null si no hay coches en la BBDD, lista de String que contiene los coches en formato json
	 */
	
	public List<String> crearJsonCoches() {
		List<Coche> listaCoches = daoCoche.listar();
		List<String> listaJson = new ArrayList<>();
		if (listaCoches == null) {
			return null;
		}
		
		Gson gson = new Gson();
		for (Coche coche : listaCoches) {
			listaJson.add(gson.toJson(coche));
		}
		
		return listaJson;
		
	}
	
	/**
	 * Metodo que genera un libro excel de todos los coches de la BBDD
	 * @return null si no hay coches en la BBDD, libro excel con el listado de coches
	 */

	public XSSFWorkbook crearExcel() {
		List<Coche> listaCoches = daoCoche.listar();
		
		if(listaCoches == null) {
			return null;
		}
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet(" Coches ");
		XSSFRow row = null;
		int rowid = 0;
		int cellid = 0;
		Cell cell ;
		
		row = spreadsheet.createRow(rowid++);
		cell = row.createCell(cellid++);
		cell.setCellValue("id");
		cell = row.createCell(cellid++);
		cell.setCellValue("matricula");
		cell = row.createCell(cellid++);
		cell.setCellValue("marca");
		cell = row.createCell(cellid++);
		cell.setCellValue("modelo");
		cell = row.createCell(cellid++);
		cell.setCellValue("km");
	
		
		for (Coche coche : listaCoches) {
			cellid = 0;
			row = spreadsheet.createRow(rowid++);
			cell = row.createCell(cellid++);
			cell.setCellValue(coche.getId());
			cell = row.createCell(cellid++);
			cell.setCellValue(coche.getMatricula());
			cell = row.createCell(cellid++);
			cell.setCellValue(coche.getMarca());
			cell = row.createCell(cellid++);
			cell.setCellValue(coche.getModelo());
			cell = row.createCell(cellid++);
			cell.setCellValue(coche.getKm());
			
		}
		
		return workbook;

	}
}
