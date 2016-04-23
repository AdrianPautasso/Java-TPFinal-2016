package Clases;


import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.sql.SQLException;

import javax.naming.LinkRef;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.swing.text.html.HTML;

/**
 * Servlet implementation class BuscarUsuario
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private CatalogoUsuario cu = new CatalogoUsuario();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = new Usuario();
		String usuario = request.getParameter("txtUsuario");
		String pin = request.getParameter("txtPIN");
		HttpSession session = request.getSession();		
		boolean bloqueado = false;
		String validaciones="";
		try {
			validaciones = cu.validaUsuario(usuario, false)
					+cu.validaPIN(pin);
			response.getWriter().write(validaciones);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (validaciones.equals(""))
		{
			try {
				if(!(usuario.isEmpty()&&pin.isEmpty()))
				{
					u = cu.Buscar(usuario);
					if((u!=null)&&(u.getEstado()==true))
					{
						if(!u.getPin().equals(pin))
						{
							response.getWriter().write("PIN incorrecto.<br>");
							u.setIntentos(u.getIntentos()+1);
							cu.Update(u);
							if(u.getIntentos()==3)
							{
								u.setEstado(false);
								cu.Update(u);
							}
						}
						else
						{
							u.setIntentos(0);
							cu.Update(u);
							session.setAttribute("usuario", u);	
							response.getWriter().write("<script>window.location.href = 'gestionUsuario.jsp';</script>");	
							//response.getWriter().write("<script>window.location.href = 'index.html';</script>");
						}	
					}
					else if((u!=null)&&(u.getEstado()==false))
						response.getWriter().write("<br>El usuario se encuentra bloqueado.<br>");	
					else
						response.getWriter().write("Usuario incorrecto.<br>");	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		response.getWriter().println("<a href ='login.jsp' >Volver</a>");
	}//Fin doPost()
	
}
