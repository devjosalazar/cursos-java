package co.edu.cue.banco.controllers;


import java.beans.PersistenceDelegate;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.cue.banco.exceptions.EmpleadoException;
import co.edu.cue.banco.model.Banco;
import co.edu.cue.banco.model.Cliente;
import co.edu.cue.banco.model.Empleado;
import co.edu.cue.banco.persistencia.Persistencia;
import co.edu.cue.banco.services.IModelFactoryService;
import javafx.collections.ObservableList;

public class ModelFactoryController implements IModelFactoryService, Runnable{

	Banco banco;
	
	
	//------------------------------  Singleton ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder { 
		// El constructor de Singleton puede ser llamado desde aqu� al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// M�todo para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}
	
	public ModelFactoryController() {
		
		banco = new Banco();
		
		// 1 inicializar los datos del modelo
//		inicializarDatos();
		
		
		//2. Guardar los datos de los empleados en un archivo
//		try {
//			Persistencia.guardarEmpleados(getBanco().getListaEmpleados());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//3. Cargar la informaci�n de los empleados desde un archivo
//		try {
//			Persistencia.cargarDatosArchivos(banco);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		//4. Persistir la informaci�n en un archivo Binario
//		guardarResourceBinario();
//		cargarResourceBinario();
		
		
		//5. Persistir la informaci�n en un archivo XML
//		guardarResourceXML();
		cargarResourceXML();
		
		if(banco == null){
			inicializarDatos();
			guardarResourceXML();
		}
	}



	public void guardarResourceXML() {
		Persistencia.guardarRecursoBancoXML(banco);
	}
	
	public void cargarResourceXML() {
		banco = Persistencia.cargarRecursoBancoXML();
	}



	public void guardarResourceBinario() {
		Persistencia.guardarRecursoBancoBinario(banco);
	}
	
	public void cargarResourceBinario() {
		banco = Persistencia.cargarRecursoBancoBinario();
	}

	private void inicializarDatos() {

		banco = new Banco();
		
		Cliente cliente = new Cliente();
		cliente.setNombre("juan");
		cliente.setApellido("arias");
		cliente.setCedula("125454");
		cliente.setDireccion("Armenia");
		cliente.setCorreo("uni1@");
		cliente.setFechaNacimiento("12454");
		cliente.setTelefono("125444");

		banco.getListaClientes().add(cliente);

		cliente = new Cliente();
		cliente.setNombre("Pedro");
		cliente.setApellido("Perez");
		cliente.setCedula("77787");
		cliente.setDireccion("Pererira");
		cliente.setCorreo("uni2@");
		cliente.setFechaNacimiento("12454");
		cliente.setTelefono("125444");

		banco.getListaClientes().add(cliente);
		
		cliente = new Cliente();
		cliente.setNombre("Alberto");
		cliente.setApellido("Arias");
		cliente.setCedula("12555");
		cliente.setDireccion("Pererira");
		cliente.setCorreo("uni3@");
		cliente.setFechaNacimiento("12454");
		cliente.setTelefono("125444");

		banco.getListaClientes().add(cliente);
		
		
		Empleado empleado = new Empleado();
		empleado.setNombre("juan");
		empleado.setApellido("arias");
		empleado.setCedula("125454");
		empleado.setFechaNacimiento("12454");
		banco.getListaEmpleados().add(empleado);
		
		
		empleado = new Empleado();
		empleado.setNombre("Ana");
		empleado.setApellido("alzate");
		empleado.setCedula("125454");
		empleado.setFechaNacimiento("12454");
		banco.getListaEmpleados().add(empleado);
		
		empleado = new Empleado();
		empleado.setNombre("Pedro");
		empleado.setApellido("perez");
		empleado.setCedula("125454");
		empleado.setFechaNacimiento("12454");
		banco.getListaEmpleados().add(empleado);
		
		System.out.println("Banco inicializado "+banco );
		
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}


	@Override
	public Empleado crearEmpleado(String nombre, String apellido, String cedula, String fechaNacimiento) {
		
		
		Empleado empleado = null;
		
		try {
			empleado = getBanco().crearEmpleado(nombre, apellido, cedula, fechaNacimiento);
		} catch (EmpleadoException e) {
			e.getMessage();
		}
		
		return empleado;
		
	}

	@Override
	public boolean actualizarEmpleado(String cedulaActual, String nombre, String apellido, String cedula, String fechaNacimiento) {
		
		return getBanco().actualizarEmpleado(cedulaActual, nombre, apellido, cedula, fechaNacimiento);
	}

	@Override
	public Boolean eliminarEmpleado(String cedula) {
		
		boolean flagEmpleadoExiste = false;
		
		try {
			flagEmpleadoExiste = getBanco().eliminarEmpleado(cedula);
		} catch (EmpleadoException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return flagEmpleadoExiste;
	}

	@Override
	public Empleado obtenerEmpleado(String cedula) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Empleado> obtenerEmpleados() {
		
		return banco.getListaEmpleados();
	}

	@Override
	public void run() {
	
		//1. hilo 1 para manejar la persistencia
		
		//2. hilo 2 para registrar las acciones del sistema
		
		//3. Para genera un archivo de integracion
		
		//4. Para generar reporte
		
	}


	
	
	
}
