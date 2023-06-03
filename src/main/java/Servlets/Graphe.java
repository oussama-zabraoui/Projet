package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import dataLayer.Aelement;
/**
 * Servlet implementation class Graphe
 */
public class Graphe extends HttpServlet {



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> nomes=new ArrayList<String>();
		ArrayList<String> etats=new ArrayList<String>();
		String partn = request.getParameter("partn");
		Aelement elements= new Aelement();
		//System.out.println(partn);
		nomes=elements.getNomes_Element(partn);
		etats=elements.getEtat_Element(partn);
		System.out.println(nomes.size());
		System.out.println(etats.size());
		request.setAttribute("Allname", nomes);
		request.setAttribute("Alletat", etats);
		request.getRequestDispatcher("chart.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
