package Clases;

import java.sql.Date;

public class Transferencia {

	private int id;
	private int id_cuenta_origen;
	private double monto;
	private Date fecha;
	private int id_cuenta_destino;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_cuenta_origen() {
		return id_cuenta_origen;
	}
	public void setId_cuenta_origen(int id_cuenta_origen) {
		this.id_cuenta_origen = id_cuenta_origen;
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
	public int getId_cuenta_destino() {
		return id_cuenta_destino;
	}
	public void setId_cuenta_destino(int id_cuenta_destino) {
		this.id_cuenta_destino = id_cuenta_destino;
	}
	public Transferencia(int id, int id_cuenta_origen, double monto,
			Date fecha, int id_cuenta_destino) {
		super();
		this.id = id;
		this.id_cuenta_origen = id_cuenta_origen;
		this.monto = monto;
		this.fecha = fecha;
		this.id_cuenta_destino = id_cuenta_destino;
	}
	
	
}
