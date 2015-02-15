package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Negocio.ElectrodomesticoLogic;

/**
 * Servlet implementation class ActualizarServlet
 */
@WebServlet("/modificar")
public class ActualizarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarServlet() {
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
		try
		{		
			String tipo = request.getParameter("tipo");
			double precio = Double.parseDouble(request.getParameter("base"));
			String color = request.getParameter("cmb");
			double peso = Double.parseDouble(request.getParameter("peso"));
			char letra = request.getParameter("cmb").charAt(0);
			if(tipo == "Lavarropas")
			{
				double carga =  Double.parseDouble(request.getParameter("carga"));
				new ElectrodomesticoLogic().AddLavarropas(precio, peso, color, letra, carga);
			}
			else
			{
				double resol =  Double.parseDouble(request.getParameter("resol"));
				boolean tdt = Boolean.valueOf(request.getParameter("tdt"));
				new ElectrodomesticoLogic().AddTelevision(precio, peso, color, letra, resol, tdt);
			}
			new ElectrodomesticoLogic().Delete(Integer.parseInt(request.getParameter("idElec")));
			request.setAttribute("mensaje", "El electrodomestico se ha modificado correctamente.");
		}
		catch (NumberFormatException e)
		{
			request.setAttribute("mensaje", "Ha ocurrido un error en la modificación del electrodomestico.");
		}	
		finally
		{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}
}
