package pre_parcial1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import persistencia.Persistencia;

public class Ejercicio2_Persistencia {

	public static void main(String[] args) {

		Universidad universidad = null;	
		
		universidad = inicializarDatos(universidad);
		crearPrograma(universidad.getListaFacultades().get(1));
		Persistencia.guardarRecursoUniversidadXML(universidad);
	}

	private static void crearPrograma(Facultad facultad) {
	
		String modalidaSeleccionada = "";
		
		Programa programa = new Programa();
		programa.setNombre("Ing software");
		programa.setCodigo(1);
		
		modalidaSeleccionada = obtenerModalidad();
		programa.setModalidad(modalidaSeleccionada);
		facultad.getListaProgramas().add(programa);
	}

	private static String obtenerModalidad() {
		
		ArrayList<String> listaModalidades = null;
		String modalidadSeleccionada = "";
		
		try {
			listaModalidades = Persistencia.cargarModalidades();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Lista de modalidades disponibles");
		
		for (int i = 0; i < listaModalidades.size(); i++) {
			System.out.println(i + ". "+listaModalidades.get(i));
		}
		
		modalidadSeleccionada = leerStringConsola("Escriba el nombre de la modalidad");	
		return modalidadSeleccionada;
	}
	
	public static String leerStringConsola(String mensaje)
	{
		String captura="";
		System.out.println(mensaje);
		Scanner teclado = new Scanner(System.in);
		captura = teclado.nextLine();
		return captura;
	}


	private static Universidad inicializarDatos(Universidad universidad) {
		universidad = new Universidad();
		
		Facultad facultad = new Facultad();
		facultad.setNombre("Medicina");
		universidad.getListaFacultades().add(facultad);
		
		facultad = new Facultad();
		facultad.setNombre("Ingenieria");
		universidad.getListaFacultades().add(facultad);
		
		return universidad;
	}

}
