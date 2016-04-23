package Clases;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DepositoCC
 */
@WebServlet("/DepositoCC")
public class DepositoCC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositoCC() {
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
		String sValor = request.getParameter("txtSaldoDepositoCC");
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
		validaciones = cu.validaSaldoCC(sValor);
		if(validaciones=="")
		{
			dValor = Double.parseDouble(sValor);
			nuevoSaldo = u.getSaldo_ctaCte()+dValor;
			u.setSaldo_ctaCte(nuevoSaldo);
			try {
				cu.Update(u);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			validaciones = "Dinero depositado. Saldo actual: $"+u.getSaldo_ctaCte();
		}
		response.getWriter().write(validaciones);
		response.getWriter().write("<br><a href='gestionUsuario.jsp'>Volver</a>");
	}
}
