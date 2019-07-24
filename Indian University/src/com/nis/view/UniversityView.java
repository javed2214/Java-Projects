package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.model.AdminModel;

/**
 * Servlet implementation class UniversityView
 */
@WebServlet("/UniversityView")
public class UniversityView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UniversityView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		HttpSession ses=request.getSession();
		try{
		AdminModel A=(AdminModel)ses.getValue("SADMIN");	
		String ltime=ses.getValue("LTIME").toString();
		String sn="<b>Id:"+A.getAdminid()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+A.getAdminname()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ltime+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AdminLogout target=_blank>Logout</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=images/uni/"+A.getPicture()+" width=25 height=25></b><br><hr color=green>";	
	 	
		}catch(Exception e)
		{
		response.sendRedirect("AdminLogin");
		}
		
		out.println("<script src=asset/jquery-2.2.1.min.js></script>");
		out.println("<script src=asset/statecity.js></script>");
				
		out.println("<html>");
		out.println("<form action='UniversitySubmit' method='post' enctype='multipart/form-data'>");
		out.println("<table>");
		out.println("<caption><b><i>University Register - Addition</i><b></caption>");

		out.println("<tr>");
		out.println("<td><b><i>University Name:</i><b></td>");
		out.println("<td><input type='text' name='uname'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Established Year:</i><b></td>");
		out.println("<td><input type='text' name='uyear'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Address:</i><b></td>");
		out.println("<td><textarea rows='3' cols='30' name=uadd></textarea></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>State:</i><b></td>");
		out.println("<td><select name='ustate' id='ustate'><option>-State-</option></select></td>");
		out.println("</tr>");
	
		
		out.println("<tr>");
		out.println("<td><b><i>City:</i><b></td>");
		out.println("<td><select name='city' id='city'><option>-City-</option></select></td>");
		out.println("</tr>");
	
		out.println("<tr>");
		out.println("<td><b><i>Contact Person:</i><b></td>");
		out.println("<td><input type='text' name='ucp'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Mobile No:</i><b></td>");
		out.println("<td><input type='text' name='umobile'></td>");
		out.println("</tr>");
		
		
		out.println("<tr>");
		out.println("<td><b><i>Email:</i><b></td>");
		out.println("<td><input type='email' name='uemail'></td>");
		out.println("</tr>");
	
		out.println("<tr>");
		out.println("<td><b><i>Description:</i><b></td>");
		out.println("<td><textarea rows='3' cols='30' name='udes'></textarea></td>");
		out.println("</tr>");
	 
		out.println("<tr>");
		out.println("<td><b><i>File:</i><b></td>");
		out.println("<td><input type='file' name='ulogo'></td>");
		out.println("</tr>");
	
	    out.println("</table><br>");
	    
	    out.println("<input type='submit'> <input type='reset'>");
	    out.println("</form></html>");
	    
		
	}

}






