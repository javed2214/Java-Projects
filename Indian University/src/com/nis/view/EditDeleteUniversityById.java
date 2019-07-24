package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditDeleteUniversityById
 */
@WebServlet("/EditDeleteUniversityById")
public class EditDeleteUniversityById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDeleteUniversityById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		 out.println("<html>");
		 out.println("<form action='DisplayUniversityById'>");
		 out.println("<caption><i>Search By University ID</i></caption>");
		 out.println("<table>");
		 out.println("<tr><td><b><i>University Id:</i></b></td>");
		 out.println("<td><input type=text name=uid></td>");
		 out.println("<td><input type=submit value='Search'></td></tr>");
		 out.println("</table></form></html>");
		
		 
	}

}
