package co.edu.cue.webapp.banco.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEmpleado;

	private String nombre;
	private String apellido;
	private String cedula;
	private String direccion;
	private String telefono;
	private String correo;
	private String fechaNacimiento;
	private double sueldo;
	private String codigo;

	//bi-directional many-to-one association to Transaccion
	@OneToMany(mappedBy="empleado")
	private List<Transaccion> transaccions;

	public Empleado() {
	}

	public int getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(int idempleado) {
		this.idEmpleado = idempleado;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSueldo() {
		return this.sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	@Override
	public String toString() {
		return "Empleado{" +
				"idEmpleado=" + idEmpleado +
				", nombre='" + nombre + '\'' +
				", apellido='" + apellido + '\'' +
				", cedula='" + cedula + '\'' +
				", direccion='" + direccion + '\'' +
				", telefono='" + telefono + '\'' +
				", correo='" + correo + '\'' +
				", fechaNacimiento='" + fechaNacimiento + '\'' +
				", sueldo=" + sueldo +
				", codigo='" + codigo + '\'' +
				'}';
	}

}