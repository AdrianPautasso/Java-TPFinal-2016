package Clases;

import java.sql.Date;

public class Extraccion {

	private int id;
	private int id_cuenta;
	private double monto;
	private Date fecha;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_cuenta() {
		return id_cuenta;
	}
	public void setId_cuenta(int id_cuenta) {
		this.id_cuenta = id_cuenta;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Extraccion(int id, int id_cuenta, double monto, Date fecha) {
		super();
		this.id = id;
		this.id_cuenta = id_cuenta;
		this.monto = monto;
		this.fecha = fecha;
	}
	
	
}
