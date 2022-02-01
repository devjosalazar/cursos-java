package persistencia;

import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import pre_parcial1.Universidad;




public class Persistencia {

	public static final String RUTA_ARCHIVO_MODALIDADES = "src/resources/modalidades.txt";
	public static final String RUTA_ARCHIVO_MODELO_UNIVERSIDAD_XML = "src/resources/model.xml";
//	C:\td\persistencia

	
	
//	public static void cargarDatosArchivos(Banco banco) throws FileNotFoundException, IOException {
//		
//		
//
//
//		
//		
//	}
	
	
	




	/**
	 * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
	 * @param objetos
	 * @param ruta
	 * @throws IOException
	 */
//	public static void guardarClientes(ArrayList<Cliente> listaClientes) throws IOException {
//		// TODO Auto-generated method stub
//		String contenido = "";
//		
//		for(Cliente cliente:listaClientes) 
//		{
//			contenido+= cliente.getNombre()+","+cliente.getApellido()+","+cliente.getCedula()+","+cliente.getDireccion()
//		     +","+cliente.getCorreo()+","+cliente.getFechaNacimiento()+","+cliente.getTelefono()+"\n";
//		}
//		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_CLIENTES, contenido, false);
//		
//	}
	
	
//	public static void guardarEmpleados(ArrayList<Empleado> listaEmpleados) throws IOException {
//		
//		// TODO Auto-generated method stub
//		String contenido = "";
//		
//		for(Empleado empleado:listaEmpleados) 
//		{
//			contenido+= empleado.getNombre()+","+empleado.getApellido()+","+empleado.getCedula()+","+empleado.getFechaNacimiento()+"\n";
//		}
//		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EMPLEADOS, contenido, false);
//	}
//	----------------------LOADS------------------------
	
	/**
	 * 
	 * @param tipoPersona
	 * @param ruta
	 * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static ArrayList<String> cargarModalidades() throws FileNotFoundException, IOException 
	{
		ArrayList<String> modalidades =new ArrayList<String>();
		
		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_MODALIDADES);
		String linea="";
		String modalida = "";
		
		for (int i = 0; i < contenido.size(); i++)
		{
			linea = contenido.get(i);//distancia,presencial
			modalida = "";
			modalida = linea.split(",")[0];
			modalidades.add(modalida);
			
			modalida = linea.split(",")[1];
			modalidades.add(modalida);
		}
		return modalidades;
	}
	

	
//	----------------------SAVES------------------------
	
	/**
	 * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
	 * @param objetos
	 * @param ruta
	 * @throws IOException
	 */
	


	
	
	
	//------------------------------------SERIALIZACIÓN  y XML
	
	
	

	public static void guardarRecursoUniversidadXML(Universidad universidad) {
		
		try {
			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_UNIVERSIDAD_XML, universidad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	
	



}
