package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TableModelElectrodomesticos.xTableModelElectrodomesticos;

/**
 * Servlet implementation class ListadoServlet
 */
@WebServlet("/lista")
public class ListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoServlet() {
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
		String minimo =  request.getParameter("minimo");
		String maximo =  request.getParameter("maximo");
		char letra = request.getParameter("cmb").charAt(0);
		xTableModelElectrodomesticos model = new xTableModelElectrodomesticos(minimo, maximo, letra);
		request.setAttribute("electros", model.getDataSource());
		request.getRequestDispatcher("listado.jsp").forward(request, response);
		
	}

}
