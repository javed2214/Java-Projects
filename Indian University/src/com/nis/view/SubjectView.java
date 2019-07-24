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
 * Servlet implementation class SubjectView
 */
@WebServlet("/SubjectView")
public class SubjectView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectView() {
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
		out.println("<form action='SubjectSubmit' method='POST' enctype='multipart/form-data'>");
		out.println("<table>");
		out.println("<caption><b><i>Subject Register-Addition</i></b></caption>");
		
		
		
		out.println("<tr>");
		out.println("<td><b><i>University :</i></b></td>");
		out.println("<td><select name='buniversityname' id='buniversityname'><option>-University-</option></select></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Branch Name :</i></b></td>");
		out.println("<td><select name='bname' id='bname'><option>-Branch-</option></select></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Subject Name:</i></b></td>");
		out.println("<td><input type='text' name='sname'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Semester:</i></b></td>");
		out.println("<td><select name='ssem' id='ssem'><option>-Sem-</option></select></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Remark:</i></b></td>");
		out.println("<td><input type='text' name='remark'></td>");
		out.println("</tr>");
		
		out.println("</table>");
		out.println("<br><br><input type='submit'>&nbsp;&nbsp;&nbsp;<input type='reset'>");
		out.println("</form></html>");
		
		
	}

}
