package Servlets;

import jakarta.servlet.ServletException;
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
import java.sql.Timestamp;

import bussnissLayer.Requestimpl;
import dataLayer.*;
/**
 * Servlet implementation class UploadFile
 */
@WebServlet("/UploadFile")
@MultipartConfig
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFile() {
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
        request.setAttribute("name_document", nomd);
        int partn1 = Integer.parseInt(partn);
        java.sql.Timestamp dated = new java.sql.Timestamp(new java.util.Date().getTime());
		HttpSession session = request.getSession();
		System.out.println(nom);
		System.out.println(prenom);
		Requestimpl c1=new Requestimpl();
		Requestimpl c3=new Requestimpl();
		
        int c4 = c3.savedocumentsarchive(nomelement,partn1,dated,nomd,etat,remarque,fileName,nom,prenom);
		try {

			ConnectionDB c=new ConnectionDB();
			Connection con =c.getConnection();

			PreparedStatement ps = con.prepareStatement("INSERT INTO document(name_element, part_number,dated,name_document,etat,remarque,fichier,nom,prenom) VALUES (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, nomelement);
			ps.setInt(2, partn1);
			ps.setString(4, nomd);
			ps.setTimestamp(3, dated);
			ps.setString(5, etat);
			ps.setString(6, remarque);
			ps.setString(7, fileName);
			ps.setString(8, nom);
			ps.setString(9, prenom);
			int i = ps.executeUpdate();

			if (i == 1) {
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

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
	


