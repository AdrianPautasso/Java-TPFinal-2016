package Clases;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModificarPIN
 */
@WebServlet("/ModificarPIN")
public class ModificarPIN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarPIN() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sPinActual = request.getParameter("txtPINActual");
		String sPinNuevo = request.getParameter("txtNuevoPIN");
		int id = Integer.parseInt(request.getParameter("idUsuario"));
		Cliente u = new Cliente();
		CatalogoUsuario cu = new CatalogoUsuario();
		boolean error = true;
		
		try {
			u = cu.Buscar(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String validaciones = "";
		validaciones = cu.validaPIN(sPinActual);
		if(validaciones=="")
		{
			if(!(u.getPin().equals(sPinActual)))
				validaciones = "El PIN actual no es correcto.<br>";
			else
			{
				validaciones = cu.validaPIN(sPinNuevo);
				if(validaciones=="")
				{
					u.setPin(sPinNuevo);
					validaciones ="PIN modificado. Su nuevo PIN es: "+u.getPin()+"<br>";
					try {
						cu.Update(u);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
				else
					validaciones = "PIN nuevo tiene errores: <br>"+validaciones;
			}
		}
		else
			validaciones = "PIN actual tiene errores: <br>"+validaciones;	
		
		response.getWriter().write("<h2>"+validaciones+"</h2>");
		response.getWriter().write("<br><a href='gestionUsuario.jsp'>Volver</a>");
	}
}
