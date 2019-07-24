package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.SignUpController;
import com.nis.model.LoginSignUpModel;

/**
 * Servlet implementation class SignUpSubmit
 */
@WebServlet("/SignUpSubmit")
public class SignUpSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		
		LoginSignUpModel L=new LoginSignUpModel();
		
		L.setName(request.getParameter("name"));
		L.setUsername(request.getParameter("username"));
		L.setDob(request.getParameter("dob"));
		L.setEmailid(request.getParameter("emailid"));
		L.setPassword(request.getParameter("password"));
		L.setConpassword(request.getParameter("conpassword"));
		
		boolean st=SignUpController.addRecord(L);
		
		if(st)
		{
			out.println("<html>");
			out.println("Record Submitted Successfully !");
			out.println("<br><br>");
			out.println("Click <a href=LoginView>here</a> to Login !");
			out.println("</html>");
		}
		
		else
		{
			out.println("<html>");
			out.println("Record Not Submitted !");
			out.println("</html>");
		}
		
	}

}
