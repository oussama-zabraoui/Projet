package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import bussnissLayer.Requestimpl;

/**
 * Servlet implementation class Modifierresponsable
 */
@WebServlet("/Modifierresponsable")
public class Modifierresponsable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifierresponsable() {
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
		Requestimpl cl=new Requestimpl();
		int c2= cl.modifiersponsable(nomre,matre1) ;
		 request.setAttribute("nom_responsable", nomre); 
		 request.setAttribute("matricule_responsable", matre1);
	
		 if(c2!=0) { 
			 request.getRequestDispatcher("mresponsableadd.jsp").forward(request, response);
			
		 }
		 else {
			 request.getRequestDispatcher("mresponsablefield.jsp").forward(request, response);
	
		 }
	
	}

}
