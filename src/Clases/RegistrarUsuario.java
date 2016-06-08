package Clases;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

import java.sql.*;
import java.util.ArrayList;
/**
 * Servlet implementation class RegistrarUsuario
 */
@WebServlet("/RegistrarUsuario")
public class RegistrarUsuario extends HttpServlet implements Servlet {
	
	private static final long serialVersionUID = 1L;
    
	private CatalogoUsuario cu = new CatalogoUsuario();
	
    public RegistrarUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente u = new Cliente();
		
		String usuario = request.getParameter("txtNombreUsuario");
		String PIN = request.getParameter("txtPIN");
		String saldoCA = request.getParameter("txtSaldoCA");
		String saldoCC = request.getParameter("txtSaldoCC");
		String validaciones = "";
		String enlace = "";
		try {
			validaciones = cu.validaUsuario(usuario, true)
					+cu.validaPIN(PIN)
					+cu.validaSaldoCA(saldoCA)
					+cu.validaSaldoCC(saldoCC);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		enlace = "<a href ='registrarUsuario.jsp' >Volver</a>";
		if (validaciones.equals(""))
		{
			u.setEstado(true);
			u.setNombre_usuario(usuario);
			u.setPin(PIN);
			u.setSaldo_cajaAhorro(Double.parseDouble(saldoCA));
			u.setSaldo_ctaCte(Double.parseDouble(saldoCC));
			u.setIntentos(0);
			try {
				cu.Add(u);
				HttpSession session = request.getSession();
				session.setAttribute("usuario", u);
				validaciones = "<br><h2>Usuario registrado.</h2>"
						+"<br>Usuario: "+u.getNombre_usuario()
						+"<br>PIN: "+u.getPin()
						+"<br>Saldo Cuenta Corriente: $"+u.getSaldo_ctaCte()
						+"<br>Saldo Caja Ahorro: $"+u.getSaldo_cajaAhorro()
						+"<br>Estado del usuario: "+u.getEstado()
						+"<br>Intentos de Pin incorrectos: "+u.getIntentos();
						enlace = "<br><a href='gestionUsuario.jsp'>Iniciar Sesi&oacuten.</a>";
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		response.getWriter().write(validaciones);
		response.getWriter().write(enlace);
	}//Fin doPost()
	
}
