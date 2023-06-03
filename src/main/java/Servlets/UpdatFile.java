package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import bussnissLayer.Requestimpl;
import dataLayer.ConnectionDB;

/**
 * Servlet implementation class UpdatFile
 */
@WebServlet("/UpdatFile")
@MultipartConfig
public class UpdatFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatFile() {
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
		Part p = request.getPart("file");
		String fileName = p.getSubmittedFileName();
        String partn = request.getParameter("partn");
        String nomelement = request.getParameter("nomelement");
        String nomd = request.getParameter("nomd");
        String etat = request.getParameter("etat");
        String remarque = request.getParameter("remarque");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        request.setAttribute("part_number", partn);
        request.setAttribute("name_element", nomelement);
       
        int partn1 = Integer.parseInt(partn);
        java.sql.Timestamp dated = new java.sql.Timestamp(new java.util.Date().getTime());
		HttpSession session = request.getSession();
		System.out.println(nom);
		System.out.println(prenom);
		Requestimpl c1=new Requestimpl();
		Requestimpl c3=new Requestimpl();
		int c2 = c1.savedocumentsarchive(nomelement,partn1,dated,nomd,etat,remarque,fileName,nom,prenom);
        int c4 = c3.updatedocument(nomelement,partn1,dated,nomd,etat,remarque,fileName,nom,prenom);
		
			

			if (c4 == 1) {
				 request.setAttribute("part_number", partn);
			     request.setAttribute("name_element", nomelement);

				String path = getServletContext().getRealPath("") + "doc";

				File file = new File(path);

				p.write(path + File.separator + fileName);

				session.setAttribute("msg", "Upload Sucess");

				request.getRequestDispatcher("document.jsp").forward(request,response);

			} else {
				 request.setAttribute("part_number", partn);
			     request.setAttribute("name_element", nomelement);
			     System.out.println(partn);
				
				session.setAttribute("msg", "Upload Field");
               
				request.getRequestDispatcher("document.jsp").forward(request,response);
			}

		

	}
	

}
