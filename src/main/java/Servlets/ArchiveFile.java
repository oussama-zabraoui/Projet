package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ArchiveFile
 */
public class ArchiveFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArchiveFile() {
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

		String nomelement = request.getParameter("al1");
		String partn = request.getParameter("al2");
		String nomd = request.getParameter("al3");
		String fic = request.getParameter("al4");
		String remarque= request.getParameter("al7");
		String etat = request.getParameter("al6");
	
		request.setAttribute("part_number", partn);
        request.setAttribute("name_element", nomelement);
        request.setAttribute("name_document",nomd);
        request.setAttribute("remarque",remarque);
        request.setAttribute("etat",etat);
        request.getRequestDispatcher("modifierdocument.jsp").forward(request,response);
	}

}
