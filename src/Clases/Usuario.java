package Clases;

public class Usuario {

	private String dni_cliente;
	private int id;
	private String tipo;
	private String contrasena;
	private int intentos;
	private Boolean bloqueado;
	private Boolean baja;
	
	public String getDni_cliente() {
		return dni_cliente;
	}
	public void setDni_cliente(String dni_cliente) {
		this.dni_cliente = dni_cliente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public int getIntentos() {
		return intentos;
	}
	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
	public Boolean getEstado() {
		return bloqueado;
	}
	public void setEstado(Boolean estado) {
		this.bloqueado = estado;
	}
	public Boolean getBaja() {
		return baja;
	}
	public void setBaja(Boolean baja) {
		this.baja = baja;
	}
	public Usuario(String dni_cliente, int id, String tipo, String contrasena) {
		super();
		this.dni_cliente = dni_cliente;
		this.id = id;
		this.tipo = tipo;
		this.contrasena = contrasena;
		this.intentos = 0;
		this.bloqueado = false;
		this.baja = false;
	}
	
}
