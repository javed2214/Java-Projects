package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginView
 */
@WebServlet("/LoginView")
public class LoginView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		out.println("<html><center>");
	
		
		out.println("<link rel=stylesheet href=assets/login.css type=text/css>");
		
		out.println("<script src='assets/login.js' type='text/javascript'>");
		out.println("</script>");
		
		out.println("<div class=divmain>");
		out.println("<h1 class=userlogin>User Login</h1>");
		out.println("<hr width=60%><br>");
		
		
		out.println("<form action='LoginSubmit' method='get' name='loginform' onsubmit='return validateForm()'>");
		
		
		
		out.println("<table cellspacing=5 cellpadding=5>");
		
		out.println("<tr><td><font style='font-family:calibri; font-size:20px'><b>User Name  </b></font></td>");
		out.println("<td><input type=text name=username id=username></td></tr>");   //  required pattern='[0-9a-zA-Z_.-]*'
		
		
		out.println("<tr><td><font style='font-family:calibri;font-size:20px'><b>Password  </b></font></td>");
		out.println("<td><input type=password name=password id=password></td></tr>");
	
		out.println("</table>");
		out.println("</form>");
		
		
		out.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=submit class=button value=Login onclick=call();>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println("<input type=reset class=button value=Reset>");
		out.println("<br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=SignUpView class=signup>Sign Up</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println("<a href=ForgotPasswordView class=signup>Forgot Password</a>");
		out.println("</center>");
		
		out.println("</div>");
		
		out.println("</html>");
		
		out.flush(); 
		
	}

}
