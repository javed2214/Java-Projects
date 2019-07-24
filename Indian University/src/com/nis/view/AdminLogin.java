package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
	 out.println("<form action='CheckAdminLogin' method='post'>");
	 out.println("<caption><i>Administrative Login</i></caption>");
	 out.println("<table>");
	 out.println("<tr><td><b><i>Admin Id:</i></b></td>");
	 out.println("<td><input type=text name=aid></td></tr>");
	 out.println("<tr><td><b><i>Password:</i></b></td>");
	 out.println("<td><input type=password name=pwd></td></tr>");
	 out.println("<tr><td>&nbsp;</td>");
	 out.println("<td><input type=submit value='Sign in'></td></tr>");
	 out.println("</table></form></html>");
	 
	 
	 	 
	}

}





