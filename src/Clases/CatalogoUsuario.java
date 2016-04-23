package Clases;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;

public class CatalogoUsuario {
	public Connection conn = (Connection) Conexion.GetConnection();
	
	public void Add(Usuario u) throws SQLException 
	{
		String query = " insert into usuarios "
				+"(nombre_usuario, pin, saldo_ctaCte, saldo_cajaAhorro, estado, intentos)"
		        + " values (?, ?, ?, ?, ?, 0)";
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query);
		stmt.setString(1, u.getNombre_usuario());
		stmt.setString(2, u.getPin());
		stmt.setDouble(3, u.getSaldo_ctaCte());
		stmt.setDouble(4, u.getSaldo_cajaAhorro());
		stmt.setBoolean(5, u.getEstado());
		stmt.execute();
		//conn.close();
	}
	
	public void Update(Usuario u) throws SQLException
	{
		String query = "update usuarios set nombre_usuario = ?, pin = ?, "
				+ "saldo_ctaCte = ?, saldo_cajaAhorro = ?, "
				+ "estado = ?, intentos = ? where id = ?";
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(query);
		stmt.setString(1, u.getNombre_usuario());
		stmt.setString(2, u.getPin());
		stmt.setDouble(3, u.getSaldo_ctaCte());
		stmt.setDouble(4, u.getSaldo_cajaAhorro());
		stmt.setBoolean(5, u.getEstado());
		stmt.setInt(6, u.getIntentos());
		stmt.setInt(7, u.getId());
		stmt.execute();
		//conn.close();
	}
	
	public void Delete(int id)
	{
		
	}
	
	public Usuario Buscar(String nombre_usuario) throws SQLException 
	{
		Usuario u = new Usuario();
		boolean encontro = false;
		String usuarioDB = "";
		String query = "SELECT * FROM usuarios";
		PreparedStatement stmt = conn.prepareStatement(query);
		ResultSet rs = null;
		rs = stmt.executeQuery();
		while(rs.next())
		{
			usuarioDB = rs.getString("nombre_usuario");
			if(nombre_usuario.equals(usuarioDB))
			{
				u.setNombre_usuario(rs.getString("nombre_usuario"));
				u.setPin(rs.getString("PIN"));
				u.setSaldo_cajaAhorro(Double.parseDouble(rs.getString("saldo_cajaAhorro")));
				u.setSaldo_ctaCte(Double.parseDouble(rs.getString("saldo_ctaCte")));
				u.setId(Integer.parseInt(rs.getString("id")));
				u.setIntentos(Integer.parseInt(rs.getString("intentos")));
				if(rs.getString("estado").equals("1"))
					u.setEstado(true);
				else
					u.setEstado(false);
				encontro = true;
			}
		}
		if(encontro==false)
			u = null;
		//conn.close();
		return u;
	}
	
	public Usuario Buscar(int id) throws SQLException
	{
		Usuario u = new Usuario();
		int idUsuarioDB;
		String query = "SELECT * FROM usuarios";
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(query);
		ResultSet rs = null;
		rs = stmt.executeQuery();
		while(rs.next())
		{
			idUsuarioDB = Integer.parseInt(rs.getString("id"));
			if(id==idUsuarioDB)
			{
				u.setNombre_usuario(rs.getString("nombre_usuario"));
				u.setPin(rs.getString("PIN"));
				u.setSaldo_cajaAhorro(Double.parseDouble(rs.getString("saldo_cajaAhorro")));
				u.setSaldo_ctaCte(Double.parseDouble(rs.getString("saldo_ctaCte")));
				u.setId(Integer.parseInt(rs.getString("id")));
				u.setIntentos(Integer.parseInt(rs.getString("intentos")));
				if(rs.getString("estado").equals("1"))
					u.setEstado(true);
				else
					u.setEstado(false);
			}
		}
		//conn.close();
		return u;
	}
	
	public String validaUsuario(String usuario , boolean buscaExistente) throws SQLException
	{
		String mensaje = "";
		if(usuario.isEmpty())
			mensaje = mensaje+"Ingrese nombre de usuario.<br>";
		else if(usuario.length()<8 || usuario.length()>20)
			mensaje = mensaje+"El nombre de usuario debe tener entre 8 y 20 caracteres.<br>";
		if(buscaExistente)
		{
			Usuario u = new Usuario();
			u = this.Buscar(usuario);
			if(u!=null)
				mensaje = mensaje+"El usuario ingresado ya existe.<br>";
		}
		return mensaje;
	}
	
	public String validaPIN(String PIN)
	{
		String mensaje = "";
		if(PIN.isEmpty())
			mensaje = mensaje+"Ingrese PIN.<br>";
		else if(PIN.length()!=8)
			mensaje = mensaje+"El PIN debe ser de 8 digitos.<br>";
		else if(!PIN.matches("[0-9]*"))
			mensaje = mensaje+"El PIN debe contener solo n&uacutemeros.<br>";
		return mensaje;
	}
	
	public String validaSaldoCA(String saldoCA)
	{
		String mensaje = "";
		if(saldoCA.isEmpty())
			mensaje = mensaje+"Ingrese el saldo de la caja de ahorro.<br>";
		if(!saldoCA.matches("[0-9]*|[0-9]*[.][0-9]*"))
			mensaje = mensaje+"El saldo de la caja de ahorro debe ser un valor num&eacuterico (separe decimales con punto).<br>";
		return mensaje;
	}
	
	public String validaSaldoCC(String saldoCC)
	{
		String mensaje = "";
		if(saldoCC.isEmpty())
			mensaje = mensaje+"Ingrese el saldo de la cuenta corriente.<br>";
		if(!saldoCC.matches("[0-9]*|[0-9]*[.][0-9]*"))
			mensaje = mensaje+"El saldo de la cuenta corriente debe ser un valor num&eacuterico (separe decimales con punto).<br>";
		return mensaje;
	}
	
}
