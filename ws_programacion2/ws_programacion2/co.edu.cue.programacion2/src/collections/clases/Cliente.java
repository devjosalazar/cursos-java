package collections.clases;

public class Cliente implements Comparable<Cliente>{
	
	String nombres;
	String apellidos;
	String cedula;
	String descripcion;
	
	
	public Cliente() {
		
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public int compareTo(Cliente clienteNuevo) {
		int valor = this.getCedula().compareTo(clienteNuevo.getCedula());
		return valor;
	}





//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int resultado = 1;
//		resultado = prime * resultado + ((cedula == null) ? 0: cedula.hashCode());
//		return resultado;
//	}
//
//	
//	@Override
//	public boolean equals(Object obj) {
//		
//		if(this == obj)
//			return true;
//		
//		if(obj == null)
//			return false;
//		
//		if(getClass() != obj.getClass())
//			return false;
//		
//		Cliente otro = (Cliente) obj;
//		if(cedula == null){
//			if(otro.cedula != null)
//				return false;
//		}else if(!cedula.equals(otro.cedula))
//			return false;
//		return true;
//	}
	


}
