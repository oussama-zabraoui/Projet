package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dataLayer.ConnectionDB;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		
	     String email = request.getParameter("email");
	     String password = request.getParameter("password");
		 String msg ="Mot de passe ou Email est incorrect";
	    
		
		
		
		
		try {
			ConnectionDB c=new ConnectionDB();
			Connection con =c.getConnection();
	            PreparedStatement stmt = con.prepareStatement("SELECT * FROM users WHERE email = ? AND mot_de_passe = ?");
	            stmt.setString(1, email);
	            stmt.setString(2, password);
	            
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                String role = rs.getString("role");
	                String nom = rs.getString("nom");
	                String prenom = rs.getString("prenom");
	                
	                //request.login(email, password);
	                request.getSession().setAttribute("role", role);
	                if(role.equals("admin")) {
	                	 session.setAttribute("email", email);
	                	 session.setAttribute("nom",nom);
	                	 session.setAttribute("prenom",prenom);
	                	request.getRequestDispatcher("projet.jsp").forward(request, response);
	                	
	                }
	                else {
	                	session.setAttribute("email", email);
	                	 session.setAttribute("nom",nom);
	                	 session.setAttribute("prenom",nom);
	                	request.getRequestDispatcher("projet.jsp").forward(request, response);
	                	request.getRequestDispatcher("document.jsp").forward(request, response);
	                	request.getRequestDispatcher("modifierdocument.jsp").forward(request, response);
	                	request.getRequestDispatcher("listdocument.jsp").forward(request, response);
	                	request.getRequestDispatcher("listdocumentarchives.jsp").forward(request, response);
	                	request.getRequestDispatcher("Ajouteruser.jsp").forward(request, response);
	                	request.getRequestDispatcher("client.jsp").forward(request, response);
	                	request.getRequestDispatcher("element.jsp").forward(request, response);
	                	request.getRequestDispatcher("equipe.jsp").forward(request, response);
	                	request.getRequestDispatcher("listclient.jsp").forward(request, response);
	                	request.getRequestDispatcher("listdocument.jsp").forward(request, response);
	                	request.getRequestDispatcher("listprojet.jsp").forward(request, response);
	                	request.getRequestDispatcher("listresp.jsp").forward(request, response);
	                	request.getRequestDispatcher("listuser.jsp").forward(request, response);
	                	request.getRequestDispatcher("listuser.jsp").forward(request, response);
	                	request.getRequestDispatcher("modifierelement.jsp").forward(request, response);
	                	request.getRequestDispatcher("modifierequipe.jsp").forward(request, response);
	                	request.getRequestDispatcher("modifierprojet.jsp").forward(request, response);
	                	request.getRequestDispatcher("modifierresponsable.jsp").forward(request, response);
	                	request.getRequestDispatcher("modifieruser.jsp").forward(request, response);
	                	request.getRequestDispatcher("responsable.jsp").forward(request, response);
	                
	                
	                }
	               
	            } else {
	            	session.setAttribute("errmsg",msg);
	                response.sendRedirect("login.jsp");
	            }
	            
	            con.close();
	        } catch (Exception e) {
	            throw new ServletException(e);
	        }
	    }
	
	}

