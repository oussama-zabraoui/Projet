package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.FileInputStream;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.ddocument;
import dataLayer.*;

/**
 * Servlet implementation class DowloadingFile
 */
@WebServlet("/download")
@MultipartConfig
public class DowloadingFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DowloadingFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nameElement = request.getParameter("al1");
		String partNumber = request.getParameter("al2");
		String namedoc = request.getParameter("al3");
		String fic = request.getParameter("al4");
		int partNumber1 = Integer.parseInt(partNumber);
		System.out.println(namedoc);
		
		System.out.println(fic);
		ConnectionDB c=new ConnectionDB();
	    Connection con = c.getConnection();
	    try {
	        PreparedStatement ps = con.prepareStatement("SELECT  fichier FROM document WHERE name_element=? AND part_number=? AND name_document=?");
	        ps.setString(1, nameElement);
	        ps.setInt(2, partNumber1);
	        ps.setString(3, namedoc);
	        
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	       
	              String path = getServletContext().getRealPath("")+ "doc" + File.separator+rs.getString(1) ;
	              System.out.println(path);
	              File file = new File(path);
	              OutputStream os = null;
	              FileInputStream inputStream = new FileInputStream(file);
	              OutputStream outputStream = response.getOutputStream();
	              response.setContentType("application/octet-stream");
	              response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
	           
	          
	           
	            
	            
	            // Send the binary data of the file to the client
	           
	            byte[] buffer = new byte[1024*1000];
	           int byteRead =-1;
	            while ((byteRead = inputStream.read(buffer)) != -1) {
	            	outputStream.write(buffer, 0, byteRead);
	            }
	            inputStream.close();
	            outputStream.flush();
	            
	        } else {
	            response.sendError(HttpServletResponse.SC_NOT_FOUND);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nameElement = request.getParameter("al1");
		String partNumber = request.getParameter("al2");
		String namedoc = request.getParameter("al3");
		String fic = request.getParameter("al4");
		
		System.out.println( fic);
		int partNumber1 = Integer.parseInt(partNumber);
		System.out.println(namedoc);
		
		ConnectionDB c=new ConnectionDB();
	    Connection con = c.getConnection();
	    try {
	        PreparedStatement ps = con.prepareStatement("SELECT  fichier FROM document WHERE name_element=? AND part_number=? AND name_document=?");
	        ps.setString(1, nameElement);
	        ps.setInt(2, partNumber1);
	        ps.setString(3, namedoc);
	        
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	        	 
	              String path = getServletContext().getRealPath("")+ "doc" + File.separator + fic;
	              File file = new File(path);
	              FileInputStream inputStream = new FileInputStream(file);
	              
	              response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
	              response.setContentType("application/octet-stream");
	              
	              
	           
	          
	            
	            
	            
	            // Send the binary data of the file to the client
	            OutputStream outputStream = response.getOutputStream();
	            byte[] buffer = new byte[1024*1000];
	           int byteRead =-1;
	            while ((byteRead = inputStream.read(buffer)) != -1) {
	                outputStream.write(buffer, 0, byteRead);
	            }
	            inputStream.close();
	            outputStream.flush();
	        } else {
	            response.sendError(HttpServletResponse.SC_NOT_FOUND);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    }
	}

	}


