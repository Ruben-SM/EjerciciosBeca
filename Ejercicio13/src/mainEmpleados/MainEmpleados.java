package mainEmpleados;

import java.util.ArrayList;

import entidades.Directivo;
import entidades.Empleado;
import entidades.Incentivos;
import entidades.Jefe;
import entidades.Trabajador;

public class MainEmpleados {

	public static void main(String[] args) {
		
		ArrayList<Empleado> empleados = new ArrayList<>();
		ArrayList<Empleado> empleadosDirectivo = new ArrayList<>();
		
		Empleado e = null;
		
		// Trabajadores
		
		e = new Trabajador ("Raúl",1000.0);
		((Trabajador) e).setValoracion(5);
		empleados.add(e);
		
		e = new Trabajador ("Julio", 1500.0);
		((Trabajador) e).setValoracion(7);
		empleados.add(e);
		
		e = new Trabajador ("Lucía", 1700.0);
		((Trabajador) e).setValoracion(9);
		empleados.add(e);
		
		// Jefes
		
		e = new Jefe("Javier",2000.0);
		((Jefe)e).setIncentivos(Incentivos.MERITOS);
		empleados.add(e);
		
		// Director
		
		e = new Directivo("Victor",3000.0);
		empleadosDirectivo.add(empleados.get(0));
		empleadosDirectivo.add(empleados.get(2));
		empleadosDirectivo.add(empleados.get(3));
		((Directivo)e).setEmpleadosACargo(empleadosDirectivo);
		empleados.add(e);
		
		for (Empleado em : empleados) {
			System.out.println(em.calcularSueldoFinal());
		}
	}
}
