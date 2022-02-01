package pre_parcial1;

import java.io.Serializable;
import java.util.ArrayList;

public class Universidad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private ArrayList<Facultad> listaFacultades = new ArrayList<Facultad>();
	
	public Universidad() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Facultad> getListaFacultades() {
		return listaFacultades;
	}

	public void setListaFacultades(ArrayList<Facultad> listaFacultades) {
		this.listaFacultades = listaFacultades;
	}
}
