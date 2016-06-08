package Clases;

import java.sql.Date;

public class Cuota {

	private int nro_cuota;
	private int id_prestamo;
	private double importe;
	private Date fec_venc;
	private Date fec_pago;
	public int getNro_cuota() {
		return nro_cuota;
	}
	public void setNro_cuota(int nro_cuota) {
		this.nro_cuota = nro_cuota;
	}
	public int getId_prestamo() {
		return id_prestamo;
	}
	public void setId_prestamo(int id_prestamo) {
		this.id_prestamo = id_prestamo;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public Date getFec_venc() {
		return fec_venc;
	}
	public void setFec_venc(Date fec_venc) {
		this.fec_venc = fec_venc;
	}
	public Date getFec_pago() {
		return fec_pago;
	}
	public void setFec_pago(Date fec_pago) {
		this.fec_pago = fec_pago;
	}
	
	public Cuota(int nro_cuota, int id_prestamo, double importe, Date fec_venc,
			Date fec_pago) {
		super();
		this.nro_cuota = nro_cuota;
		this.id_prestamo = id_prestamo;
		this.importe = importe;
		this.fec_venc = fec_venc;
		this.fec_pago = fec_pago;
	}	
	
}
