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
 * Servlet implementation class AltaServlet
 */
@WebServlet("/agregar")
public class AltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaServlet() {
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
			String base =  request.getParameter("base");
			String color =  request.getParameter("cmbColor");
			String peso = request.getParameter("peso");
			char letra = request.getParameter("cmb").charAt(0);
			char tipo = request.getParameter("cmbTipo").charAt(0);
			System.out.println(tipo);
			if (tipo=='1')
			{
				String carga =  request.getParameter("carga");
				new ElectrodomesticoLogic().AddLavarropas(Double.parseDouble(base),Double.parseDouble(peso),color,letra,Double.parseDouble(carga));
			}
			else 
			{
				String resol =  request.getParameter("resol");
				boolean tdt = Boolean.valueOf(request.getParameter("tdt"));
				new ElectrodomesticoLogic().AddTelevision(Double.parseDouble(base),Double.parseDouble(peso),color,letra,Double.parseDouble(resol),tdt);
			}
			request.setAttribute("mensaje", "El electrodomestico se ha dado de alta correctamente.");
		}
		catch (NumberFormatException e)
		{
			request.setAttribute("mensaje", "Ha ocurrido un error!");
		}	
		finally
		{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
	}

}
