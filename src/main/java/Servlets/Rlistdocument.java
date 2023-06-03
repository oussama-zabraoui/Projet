package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import Model.*;
import bussnissLayer.Requestimpl;

/**
 * Servlet implementation class Rlistdocument
 */
@WebServlet("/Rlistdocument")
public class Rlistdocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rlistdocument() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomelement = request.getParameter("nomelement");
		String partn = request.getParameter("partn");
		int partn1= Integer.parseInt(partn);
		System.out.println(nomelement);
		System.out.println(partn1);
		Requestimpl req=new Requestimpl();
	    ArrayList<ddocument> listd =req.listdocument(partn1,nomelement);
	    request.setAttribute("name_element", nomelement); 
		request.setAttribute("part_number", partn1);
		request.setAttribute("Alldocument", listd);
		request.getRequestDispatcher("listdocument.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
