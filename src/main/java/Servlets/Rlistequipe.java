package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import Model.equipe;
import bussnissLayer.Requestimpl;

/**
 * Servlet implementation class Rlistequipe
 */
@WebServlet("/Rlistequipe")
public class Rlistequipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rlistequipe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Requestimpl req=new Requestimpl();
		ArrayList<equipe> liste =req.listequipe();
	    System.out.println("le 1"+liste.get(0).getResponsable().getNom_responsable());
	    System.out.println("le 2"+liste.get(0).getId_equipe());
	    System.out.println("le 3"+liste.get(0).getNom_equipe());
	    System.out.println("le 4"+liste.get(0).getId_responsable());
		request.setAttribute("AllEquipe",liste);
		request.getRequestDispatcher("listequipe.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
