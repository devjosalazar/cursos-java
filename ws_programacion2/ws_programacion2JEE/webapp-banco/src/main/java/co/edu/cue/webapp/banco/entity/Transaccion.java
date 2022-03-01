package co.edu.cue.webapp.banco.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the transaccion database table.
 * 
 */
@Entity
@NamedQuery(name="Transaccion.findAll", query="SELECT t FROM Transaccion t")
public class Transaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idtransaccion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String hora;

	private int numeroTransaccion;

	private String tipoTransaccion;

	private double valor;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	private Cliente cliente;

	//bi-directional many-to-one association to Cuenta
	@ManyToOne
	private Cuenta cuenta;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	private Empleado empleado;

	public Transaccion() {
	}

	public int getIdtransaccion() {
		return this.idtransaccion;
	}

	public void setIdtransaccion(int idtransaccion) {
		this.idtransaccion = idtransaccion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getNumeroTransaccion() {
		return this.numeroTransaccion;
	}

	public void setNumeroTransaccion(int numeroTransaccion) {
		this.numeroTransaccion = numeroTransaccion;
	}

	public String getTipoTransaccion() {
		return this.tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}