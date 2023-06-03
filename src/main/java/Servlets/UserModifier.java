package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class UserModifier
 */
@WebServlet("/UserModifier")
public class UserModifier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserModifier() {
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
		String nom =  request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email= request.getParameter("email");
		String mot_de_passe= request.getParameter("mot_de_passe");
		String role= request.getParameter("role");
		
		System.out.println(nom);
		System.out.println(prenom);
		System.out.println(email);
		System.out.println(mot_de_passe);
		System.out.println(role);
		
		 request.setAttribute("nom", nom); 
		 request.setAttribute("prenom", prenom); 
		 request.setAttribute("email", email); 
		 request.setAttribute("mot_de_passe", mot_de_passe); 
		 request.setAttribute("role", role); 
		 request.getRequestDispatcher("modifieruser.jsp").forward(request, response);
		
		
	}

}
