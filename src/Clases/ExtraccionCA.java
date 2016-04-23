package Clases;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExtraccionCA
 */
@WebServlet("/ExtraccionCA")
public class ExtraccionCA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExtraccionCA() {
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
		int id = Integer.parseInt(request.getParameter("idUsuario"));
		String sValor = request.getParameter("txtSaldoExtraccionCA");
		double dValor = 0, nuevoSaldo = 0;
		Usuario u = new Usuario();
		CatalogoUsuario cu = new CatalogoUsuario();
		String validaciones = "";
		try {
			u = cu.Buscar(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Validar que el valor ingresado sea numerico
		validaciones = cu.validaSaldoCA(sValor);
		if(validaciones=="")
		{
			dValor = Double.parseDouble(sValor);
			if(dValor>u.getSaldo_cajaAhorro())
				validaciones = validaciones + "<br>El valor ingresado es mayor al saldo disponible.";
			else
			{
				nuevoSaldo = u.getSaldo_cajaAhorro()-dValor;
				u.setSaldo_cajaAhorro(nuevoSaldo);
				try {
					cu.Update(u);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				validaciones = "Extraiga su dinero. Saldo actual: $"+u.getSaldo_cajaAhorro();
			}
		}
		response.getWriter().write(validaciones);
		response.getWriter().write("<br><a href='gestionUsuario.jsp'>Volver</a>");
	}
}
