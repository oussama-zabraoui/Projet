package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

import bussnissLayer.Requestimpl;

/**
 * Servlet implementation class Relement
 */
@WebServlet("/Relement")
public class Relement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Relement() {
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
		String nomelement = request.getParameter("nomelement");
		String partn = request.getParameter("partn");
		String dated = request.getParameter("dated");
		String datef = request.getParameter("datef");
		String etat =request.getParameter("etat");
		String mateq=request.getParameter("mateq");
		int partn1= Integer.parseInt(partn);
		int mateq1 = Integer.parseInt(mateq);
		//Date delai1 = LocalDate.parse(delai, DateTimeFormatter.ISO_DATE); 
		System.out.println(nomelement);
		System.out.println(partn1);
		System.out.println(dated);
		System.out.println(datef);
		System.out.println(etat);
		System.out.println(mateq1);
		Requestimpl cl=new Requestimpl();
		int c2=0;
		try {
			c2=cl.saveelement(nomelement,dated,datef,etat,partn1,mateq1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 request.setAttribute("name_element", nomelement); 
		 request.setAttribute("part_number", partn1);
		 request.setAttribute("id_equipe", mateq1); 
		 request.setAttribute("date_debut", dated);
		 request.setAttribute("date_fin",datef);
		 request.setAttribute("statu_element",etat);
		 
		 
		 if(c2!=0) { 
			 request.getRequestDispatcher("elementsucce.jsp").forward(request, response);
			
			
		 }
		 else {
			 request.getRequestDispatcher("elementfield.jsp").forward(request, response);
			
		 }
	}
	

}
