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
 * Servlet implementation class Rlistclient
 */
@WebServlet("/Rlistclient")
public class Rlistclient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rlistclient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Requestimpl req=new Requestimpl();
		ArrayList<client> listc =req.listclient();
		request.setAttribute("AllClient", listc);
		request.getRequestDispatcher("listclient.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Requestimpl req=new Requestimpl();
		ArrayList<client> listc =req.listclient();
		request.setAttribute("AllClient", listc);
		request.getRequestDispatcher("listclient.jsp").forward(request,response);
	}

}
