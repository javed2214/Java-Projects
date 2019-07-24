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
 * Servlet implementation class SubjectBranchView
 */
@WebServlet("/QuestionView")
public class QuestionView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionView() {
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
		out.println("<script src=asset/branchuniversity.js></script>");
		out.println("<script src=asset/getsemester.js></script>");
		
		out.println("<html>");
		out.println("<form action='QuestionSubmit' method='post'>");
		out.println("<table>");
		out.println("<caption><b><i>University Register - Updation</i><b></caption>");

		out.println("<tr>");
		out.println("<td><b><i>Universities:</i><b></td>");
		out.println("<td><select name='universityname' id='buniversityname'><option>-Universities-</option></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Branches:</i><b></td>");
		out.println("<td><select name='bname' id='bname'><option>-Branches-</option></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Semester:</i><b></td>");
		out.println("<td><select name='ssem' id='ssem'><option>-semester-</option></td>");
		out.println("</tr>");
		
		
		out.println("<tr>");
		out.println("<td><b><i>Subject Name:</i><b></td>");
		out.println("<td><select name='subject' id='subs' ><option>-Subject-</option></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Year:</i><b></td>");
		out.println("<td><input type='text' name='year' ></td>");
		out.println("</tr>");
				
		out.println("<tr>");
		out.println("<td><b><i>Question No:</i><b></td>");
		out.println("<td><input type='text' name='qno' ></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Question 1:</i><b></td>");
		out.println("<td><textarea rows='3' cols='30' name='q1'></textarea></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Question 2:</i><b></td>");
		out.println("<td><textarea rows='3' cols='30' name='q2'></textarea></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Question 3:</i><b></td>");
		out.println("<td><textarea rows='3' cols='30' name='q3'></textarea></td>");
		out.println("</tr>");
		
		out.println("</table><br><br>");
		out.println("<input type='submit' value='Submit'><input type='reset' value='Reset'");
		
		out.println("</form></html>");
		out.flush();
	
	
	}


	}


