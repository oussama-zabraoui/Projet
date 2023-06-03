package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import bussnissLayer.Requestimpl;

/**
 * Servlet implementation class Rclients
 */
@WebServlet("/Rclients")
public class Rclients extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rclients() {
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
		String nom = request.getParameter("nomcl");
		String prenom = request.getParameter("prenomcl");
		String email = request.getParameter("emailcl");
		String tele = request.getParameter("numtelcl");
		String part = request.getParameter("partncl");
		
		System.out.println(nom);
		System.out.println(prenom);
		System.out.println(email);
		System.out.println(tele);
		System.out.println(part);
		Requestimpl cl=new Requestimpl();
		int c2= cl.saveclient(part, tele, prenom, nom, email);
		 request.setAttribute("nom", nom); 
		  request.setAttribute("prenom", prenom);
		  request.setAttribute("email", email); 
		  request.setAttribute("num_telephone", tele);
		  request.setAttribute("part_n", part);
		 if(c2!=0) { 
			 request.getRequestDispatcher("clientadd.jsp").forward(request, response);
			
			 
		 }
		 else {
			 request.getRequestDispatcher("clientfield.jsp").forward(request, response);
			
		 }
		 
		
	}

}
