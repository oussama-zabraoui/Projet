package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import com.oracle.wls.shaded.org.apache.bcel.generic.DADD;

import Model.client;

import java.text.SimpleDateFormat;

import bussnissLayer.Requestimpl;

/**
 * Servlet implementation class Rprojet
 */
@WebServlet("/Rprojet")
public class Rprojet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rprojet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomp = request.getParameter("nomp");
		String partn = request.getParameter("partn");
		String partname = request.getParameter("partname");
		String drawing = request.getParameter("draw");
		String dates = request.getParameter("datess");
		String delai = request.getParameter("datede");
		String statu =request.getParameter("etat");
		String partncl=request.getParameter("numcl");
		int partn1= Integer.parseInt(partn);
		//Date delai1 = LocalDate.parse(delai, DateTimeFormatter.ISO_DATE); 
		
		System.out.println(nomp);
		System.out.println(partn1);
		System.out.println(partname);
		System.out.println(drawing);
		System.out.println(dates);
		System.out.println(delai);
		System.out.println(statu);
		System.out.println(partncl);
		Requestimpl cl=new Requestimpl();
		int c2=0;
		try {
			c2 = cl.saveProjet(nomp,partname,partn1,drawing,dates, delai, statu, partncl);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 request.setAttribute("nom_projet", nomp); 
		 request.setAttribute("part_number", partn1);
		 request.setAttribute("part_name", partname); 
		 request.setAttribute("drawing", drawing);
		 request.setAttribute("date_soumission",dates);
		 request.setAttribute("delai_projet",delai);
		 request.setAttribute("statu_PPAP",statu);
		 request.setAttribute("part_n",partncl);

		 
		 if(c2!=0) { 
			 request.getRequestDispatcher("projetadd.jsp").forward(request, response);
			
			
		 }
		 else {
			 request.getRequestDispatcher("projetfield.jsp").forward(request, response);
			
		 }
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
		String statu =request.getParameter("etat");
		String partncl=request.getParameter("numcl");
		int partn1= Integer.parseInt(partn);
		//Date delai1 = LocalDate.parse(delai, DateTimeFormatter.ISO_DATE); 
		
		System.out.println(nomp);
		System.out.println(partn1);
		System.out.println(partname);
		System.out.println(drawing);
		System.out.println(dates);
		System.out.println(delai);
		System.out.println(statu);
		System.out.println(partncl);
		Requestimpl cl=new Requestimpl();
		int c2=0;
		try {
			c2 = cl.saveProjet(nomp,partname,partn1,drawing,dates, delai, statu, partncl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 request.setAttribute("nom_projet", nomp); 
		 request.setAttribute("part_number", partn1);
		 request.setAttribute("part_name", partname); 
		 request.setAttribute("drawing", drawing);
		 request.setAttribute("date_soumission",dates);
		 request.setAttribute("delai_projet",delai);
		 request.setAttribute("statu_PPAP",statu);
		 request.setAttribute("part_n",partncl);
		 
		 if(c2!=0) { 
			 request.getRequestDispatcher("projetadd.jsp").forward(request, response);
			
			
		 }
		 else {
			 request.getRequestDispatcher("projetfield.jsp").forward(request, response);
			
		 }
	}

}
