package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import Model.element;
import bussnissLayer.Requestimpl;

/**
 * Servlet implementation class Rlistelement
 */
@WebServlet("/Rlistelement")
public class Rlistelement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rlistelement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String partn = request.getParameter("partn");
		int partn1= Integer.parseInt(partn);
		System.out.println(partn1);
		Requestimpl req=new Requestimpl();
	    ArrayList<element> liste =req.loadelement(partn1);
	    request.setAttribute("part_number", partn1);
		request.setAttribute("AllElement", liste);
		request.getRequestDispatcher("listelement.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
