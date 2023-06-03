package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import bussnissLayer.Requestimpl;

/**
 * Servlet implementation class Editresponsable
 */
@WebServlet("/Editresponsable")
public class Editresponsable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editresponsable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomre = request.getParameter("nomr");
		String matre = request.getParameter("matr");
		
		int matre1= Integer.parseInt(matre);
		System.out.println(nomre);
		System.out.println(matre1);
		 request.setAttribute("nomr", nomre); 
		 request.setAttribute("matr", matre1);
		 request.getRequestDispatcher("modifierresponsable.jsp").forward(request, response);
		 
	
	}
	

}
