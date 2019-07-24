package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpView
 */
@WebServlet("/SignUpView")
public class SignUpView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        PrintWriter out=response.getWriter();
		
		out.println("<html><center>");
		
		out.println("<script src=assets/signup.js ></script>");
		
		out.println("<h2 style='font-family:cambria'>User SignUp</h2>");
		out.println("<hr width=40%><br>");
		out.println("<form action=SignUpSubmit method=get>");
		
		out.println("<table cellspacing=5 cellpadding=5>");
		out.println("<tr><td><font style='font-family:calibri; font-size:20px'><b>Name : </b></font></td>");
		out.println("<td><input type=text name=name></td></tr>");
		
		out.println("<tr><td><font style='font-family:calibri; font-size:20px'><b>User Name : </b></font></td>");
		out.println("<td><input type=text name=username></td></tr>");
		
		out.println("<tr><td><font style='font-family:calibri; font-size:20px'><b>Date of Birth : </b></font></td>");
		out.println("<td><input type=date name=dob></td></tr>");
		
		out.println("<tr><td><font style='font-family:calibri; font-size:20px'><b>Email ID : </b></font></td>");
		out.println("<td><input type=email name=emailid></td></tr>");
		
		out.println("<tr><td><font style='font-family:calibri; font-size:20px'><b>Password : </b></font></td>");
		out.println("<td><input type=password name=password id=password></td></tr>");
		
		out.println("<tr><td><font style='font-family:calibri; font-size:20px'><b>Confirm Password : </b></font></td>");
		out.println("<td><input type=password name=conpassword id=conpassword onkeyup=call()>&nbsp;<img src='' id=img></td></tr>");
		
		out.println("</table>");
		
		
		out.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=submit value=Submit>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println("<input type=reset value=Reset>");
		
		out.println("</center>");
		out.println("</table>");
		
		out.flush();
		
		
	}

}
