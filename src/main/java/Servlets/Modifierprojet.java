package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import bussnissLayer.Requestimpl;

/**
 * Servlet implementation class Modifierprojet
 */
@WebServlet("/Modifierprojet")
public class Modifierprojet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifierprojet() {
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
		String nomp = request.getParameter("nomp");
		String partn = request.getParameter("partn");
		String partname = request.getParameter("partname");
		String drawing = request.getParameter("draw");
		String dates = request.getParameter("datess");
		String delai = request.getParameter("datede");
		String etat =request.getParameter("etat");
		String partncl=request.getParameter("numcl");
		int partn1= Integer.parseInt(partn);
		System.out.println(nomp);
		System.out.println(partn1);
		System.out.println(partname);
		System.out.println(drawing);
		System.out.println(dates);
		System.out.println(delai);
		System.out.println(etat);
		System.out.println(partncl);
		 request.setAttribute("nom_projet", nomp); 
		 request.setAttribute("part_number", partn1);
		 request.setAttribute("part_name", partname); 
		 request.setAttribute("drawing", drawing);
		 request.setAttribute("date_soumission",dates);
		 request.setAttribute("delai_projet",delai);
		 request.setAttribute("statu_PPAP",etat);
		 request.setAttribute("part_n",partncl);
		 Requestimpl cl=new Requestimpl();
			int c2=0;
			try {
				c2 = cl.updateProjet(nomp,partname,partn1,drawing,dates, delai, etat, partncl);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(c2!=0) { 
				 request.getRequestDispatcher("modifierprojetsucce.jsp").forward(request, response);
				
				
			 }
			 else {
				 request.getRequestDispatcher("modifierprojetfield.jsp").forward(request, response);
				
			 }
	}

}
