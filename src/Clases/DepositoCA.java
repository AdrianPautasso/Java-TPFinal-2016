package Clases;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DepositoCA
 */
@WebServlet("/DepositoCA")
public class DepositoCA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositoCA() {
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
		int id = Integer.parseInt(request.getParameter("idUsuario"));
		String sValor = request.getParameter("txtSaldoDepositoCA");
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
			nuevoSaldo = u.getSaldo_cajaAhorro()+dValor;
			u.setSaldo_cajaAhorro(nuevoSaldo);
			try {
				cu.Update(u);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			validaciones = "Dinero depositado. Saldo actual: $"+u.getSaldo_cajaAhorro();
		}
		response.getWriter().write(validaciones);
		response.getWriter().write("<br><a href='gestionUsuario.jsp'>Volver</a>");
	}
}
