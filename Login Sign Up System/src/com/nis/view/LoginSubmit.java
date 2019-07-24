package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.nis.controller.LoginController;
import com.nis.controller.SignUpController;

import com.nis.model.LoginSignUpModel;

/**
 * Servlet implementation class LoginSubmit
 */
@WebServlet("/LoginSubmit")
public class LoginSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 PrintWriter out=response.getWriter();
		 
		 LoginSignUpModel L=new LoginSignUpModel();
				 
		 L=LoginController.checkRecord(request.getParameter("username"), request.getParameter("password"));
	 

		 
		 if(L!=null)
			{
			 out.println("<html>");
			 out.println("Successfully Logged In !");
			 out.println("</html>");
			}
			else
			{
				out.println("<html>");
				out.println("Invalid Username/Password !");
				out.println("</html>");
			}
		
	}

}
