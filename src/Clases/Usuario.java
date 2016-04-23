package Clases;

public class Usuario {
	private String nombre_usuario;
	private String pin;
	private double saldo_ctaCte;
	private double saldo_cajaAhorro;
	private boolean estado;
	private int id;
	private int intentos;
	
	public int getIntentos() {
		return intentos;
	}
	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombreUsuario) {
		nombre_usuario = nombreUsuario;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public double getSaldo_ctaCte() {
		return saldo_ctaCte;
	}
	public void setSaldo_ctaCte(double saldo_ctaCte) {
		this.saldo_ctaCte = saldo_ctaCte;
	}
	public double getSaldo_cajaAhorro() 
	{
		return saldo_cajaAhorro;
	}
	public void setSaldo_cajaAhorro(double saldo_cajaAhorro) {
		this.saldo_cajaAhorro = saldo_cajaAhorro;
	}
	public Usuario(String nombre_usuario, String pin, double saldo_ctaCte,
			double saldo_cajaAhorro) {
		super();
		this.nombre_usuario = nombre_usuario;
		this.pin = pin;
		this.saldo_ctaCte = saldo_ctaCte;
		this.saldo_cajaAhorro = saldo_cajaAhorro;
	}
	public Usuario() {
		super();
	}

}
