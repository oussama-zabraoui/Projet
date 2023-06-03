package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import bussnissLayer.Requestimpl;

/**
 * Servlet implementation class Requipe
 */
@WebServlet("/Requipe")
public class Requipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Requipe() {
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
		String mateq = request.getParameter("mateq");
		String nomeq = request.getParameter("nomeq");
		String matres = request.getParameter("matree");
		int matres1= Integer.parseInt(matres);
		int mateq1 = Integer.parseInt(mateq);
		System.out.println(mateq1);
		System.out.println(nomeq);
		System.out.println(matres);
		Requestimpl cl=new Requestimpl();
		int c2= cl.saveequipe(mateq1, nomeq, matres1);
		 request.setAttribute("mateq", mateq1); 
		 request.setAttribute("nomeq", nomeq);
		 request.setAttribute("matres", matres1);
		
		 if(c2!=0) { 
			 request.getRequestDispatcher("equipeadd.jsp").forward(request, response);
			
			
		 }
		 else {
			 request.getRequestDispatcher("equipefield.jsp").forward(request, response);
			
		 }
	}

}
