package Clases;

import java.sql.Date;

public class Prestamo {

	private int id;
	private int id_cuenta;
	private double importe;
	private Date fecha;
	private int cant_cuotas;
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
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getCant_cuotas() {
		return cant_cuotas;
	}
	public void setCant_cuotas(int cant_cuotas) {
		this.cant_cuotas = cant_cuotas;
	}
	
	public Prestamo(int id, int id_cuenta, double importe, Date fecha,
			int cant_cuotas) {
		super();
		this.id = id;
		this.id_cuenta = id_cuenta;
		this.importe = importe;
		this.fecha = fecha;
		this.cant_cuotas = cant_cuotas;
	}
	
	
}
