package Clases;

public class Cliente {
	private String dni;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private Boolean baja;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Boolean getBaja() {
		return baja;
	}
	public void setBaja(Boolean baja) {
		this.baja = baja;
	}
	
	public Cliente(String dni, String nombre, String apellido,
			String direccion, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.baja = false;
	}

	

}
