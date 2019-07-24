package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.BranchController;
import com.nis.controller.SubjectController;
import com.nis.model.BranchModel;
import com.nis.model.SubjectModel;

/**
 * Servlet implementation class DisplaySubjectById
 */
@WebServlet("/DisplaySubjectById")
public class DisplaySubjectById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplaySubjectById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		try{
			SubjectModel S=SubjectController.displayById(Integer.parseInt(request.getParameter("sid")));
		out.println("<script src=asset/jquery-2.2.1.min.js></script>");
		out.println("<script src=asset/branchuniversity.js></script>");
		
		out.println("<html>");
		out.println("<form action='SubjectEditDelete' method='POST' enctype='multipart/form-data'>");
		out.println("<table>");
		out.println("<caption><b><i>Subject Update</i></b></caption>");
		out.println("<input type=hidden name='sid' value='"+S.getSubjectid()+"'>");
	
		out.println("<tr>");
		out.println("<td><b><i>University :</i></b></td>");
		out.println("<td><select name='buniversityname' id='buniversityname'><option>-University-</option></select></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		String arrayBranch[]=S.getBranchid().split(",");
		out.println("<td><b><i>Branch name :</i></b></td>");
		out.println("<td><select name='bname' id='bname'><option>-Branch-</option></select><b>"+arrayBranch[1]+"<input type=hidden name='pbranch' value='"+arrayBranch[0]+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Subjectname:</i></b></td>");
		out.println("<td><input type='text' name='sname' value='"+S.getSubjectname()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Semester:</i></b></td>");
		out.println("<td><input type='number' name='ssem' value='"+S.getSemester()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Remark:</i></b></td>");
		out.println("<td><input type='text' name='remark' value='"+S.getRemark()+"'></td>");
		out.println("</tr>");
		
		out.println("</table>");
		out.println("<br><br><input type='submit' name='btn' value='Edit'>&nbsp;&nbsp;&nbsp;<input type='submit' name='btn' value='Delete'>");
		out.println("</form></html>");
		}
		catch(Exception e){
			out.println("Error DisplaySubjectById"+e);
		}
	}

}
