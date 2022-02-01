package pre_parcial1;

import java.io.Serializable;
import java.util.ArrayList;

public class Facultad implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private ArrayList<Programa> listaProgramas = new ArrayList<Programa>();
	
	public Facultad() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Programa> getListaProgramas() {
		return listaProgramas;
	}

	public void setListaProgramas(ArrayList<Programa> listaProgramas) {
		this.listaProgramas = listaProgramas;
	}
	
}
