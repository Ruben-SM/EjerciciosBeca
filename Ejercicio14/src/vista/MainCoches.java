package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.negocio.GestorCoche;

public class MainCoches {

	public static void main(String[] args) {
		System.out.println("Bienvenidos a nuestra CRUD de personas");
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		GestorCoche gp = new GestorCoche();
		
		int id;
		String matricula;
		String marca;
		String modelo;
		double km;
		Coche c;
		List<Coche> listaCoches = new ArrayList<Coche>();
		
		do {
			menu();
			int opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Introduzca los datos del coche (Matricula/Marca/Modelo/KM)");
				
				matricula = sc.next();
				marca = sc.next();
				modelo = sc.next();
				km = sc.nextDouble();
				c = new Coche();
				
				c.setMatricula(matricula);
				c.setMarca(marca);
				c.setModelo(modelo);
				c.setKm(km);
				
				int alta = gp.alta(c);
				if(alta == 0) {
					System.out.println("Coche dado de alta");
				}else if(alta == 1) {
					System.out.println("Error de conexión con la BBDD");
				}else if(alta == 2){
					System.out.println("La matricula no tiene longitud de 7, km < 0 o matricula ya existente");
				}
				break;
			case 2:
				System.out.println("Introduzca el ID del coche a eliminar");
				id = sc.nextInt();
				
				boolean baja = gp.baja(id);
				
				if(baja){
					System.out.println("Coche dado de baja");
				}else {
					System.out.println("No se ha podido dar de baja");
				}
				break;
			case 3:
				System.out.println("Introduzca el ID del coche a modificar");
				id = sc.nextInt();

				System.out.println("Introduzca los nuevos datos del coche (Matricula/Marca/Modelo/KM)");
				matricula = sc.next();
				marca = sc.next();
				modelo = sc.next();
				km = sc.nextDouble();
				
				c = gp.obtenerID(id);
				
				c.setMatricula(matricula);
				c.setMarca(marca);
				c.setModelo(modelo);
				c.setKm(km);
				int modifica = gp.modificar(c);
				
				if(modifica == 0) {
					System.out.println("Coche modificado");
				}else if(modifica == 1) {
					System.out.println("Error de conexión con la BBDD");
				}else if(modifica == 2){
					System.out.println("La matricula no tiene longitud de 7, km < 0 o matricula ya existente");
				}
				break;
			case 4:
				System.out.println("Introduzca el ID del coche a buscar");
				id = sc.nextInt();
				

				c = gp.obtenerID(id);
				
				if (c == null) {
					System.out.println("coche no encontrado");
				}else {
					 System.out.println(c.toString()); 
				}
				
				break;
			case 5:
				System.out.println("Introduzca la matricula del coche a buscar");
				matricula = sc.next();
				
				c = gp.obtenerMatricula(matricula);
				
				if (c == null) {
					System.out.println("coche no encontrado");
				}else {
					System.out.println(c.toString()); 
				}
				
				break;
			case 6:
				System.out.println("Introduzca la marca de los coches a buscar");
				marca = sc.next();
				listaCoches = gp.obtenerMarca(marca);
				
				if (listaCoches == null) {
					System.out.println("coches no encontrados");
				}else {
					for (Coche coche : listaCoches) {
						System.out.println(coche.toString()); 
					}
				}
				break;
			case 7:
				System.out.println("Introduzca el modelo de los coches a buscar");
				modelo = sc.next();
				listaCoches = gp.obtenerModelo(modelo);
				
				if (listaCoches == null){
					System.out.println("coches no encontrados");
				} else {
					for (Coche coche : listaCoches) {
						System.out.println(coche.toString()); 
					}
				}
				break;
			case 8:
				listaCoches = gp.listar();
				if (listaCoches == null){
					System.out.println("coches no encontrados");
				}else {
					for (Coche coche : listaCoches) {
						System.out.println(coche.toString()); 
					}
				}
				break;
			case 9:
				fin = true;
				break;
			}
		}while(!fin);
		sc.close();
		System.out.println("Fin de programa");

	}

	private static void menu() {
		System.out.println("Elija una opción:");
		System.out.println("1- Alta de coche");
		System.out.println("2- Eliminar coche por ID");
		System.out.println("3- Modificar coche por ID");
		System.out.println("4- Buscar coche por ID");
		System.out.println("5- Buscar coche por matricula");
		System.out.println("6- Buscar coche por marca");
		System.out.println("7- Buscar coche por modelo");
		System.out.println("8- Listar todos los coches");
		System.out.println("9- Salir del programa");
	}
	

}
