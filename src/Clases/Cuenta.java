package Clases;

public class Cuenta {
	
	private int tipo_cuenta;
	private int id_usuario;
	private double saldo;
	private int id_cuenta;
	public int getTipo_cuenta() {
		return tipo_cuenta;
	}
	public void setTipo_cuenta(int tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public int getId_cuenta() {
		return id_cuenta;
	}
	public void setId_cuenta(int id_cuenta) {
		this.id_cuenta = id_cuenta;
	}
	
	public Cuenta(int tipo_cuenta, int id_usuario, double saldo, int id_cuenta) {
		super();
		this.tipo_cuenta = tipo_cuenta;
		this.id_usuario = id_usuario;
		this.saldo = saldo;
		this.id_cuenta = id_cuenta;
	}
	

}
