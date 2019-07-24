package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.BranchController;
import com.nis.model.BranchModel;


/**
 * Servlet implementation class DisplayBranchById
 */
@WebServlet("/DisplayBranchById")
public class DisplayBranchById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayBranchById() {
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
		BranchModel B=BranchController.displayById(Integer.parseInt(request.getParameter("bid")));
		out.println("<script src=asset/jquery-2.2.1.min.js></script>");
		out.println("<script src=asset/branchuniversity.js></script>");
		
		out.println("<html>");
		out.println("<form action='BranchEditDelete' method='POST' enctype='multipart/form-data'>");
		out.println("<table>");
		out.println("<tr><td align='top'>");
		
		out.println("<table>");
		out.println("<caption><b><i>Branch Register-Addition</i></b></caption>");
		out.println("<input type=hidden name='bid' value='"+B.getBranchid()+"'>");
		
		
		out.println("<tr>");
		String arrayUniversity[]=B.getUniversity().split(",");
		
		out.println("<td><b><i>University :</i></b></td>");
		out.println("<td><select name='buniversityname' id='buniversityname'><option>-University-</option></select>  <b>"+arrayUniversity[1]+"<input type=hidden name='puniversity' value='"+arrayUniversity[0]+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Branch name :</i></b></td>");
		out.println("<td><input type='text' name='bname' id='bname' value='"+B.getBranchname()+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td><b><i>Semesters:</i></b></td>");
		out.println("<td><input type='number' name='bsem' value='"+B.getSemester()+"'></td>");
		out.println("</tr>");
		
		out.println("</table></td>");
		out.println("<td valign='top'>");
		out.println("<img src=images/bicon/"+B.getIcon()+" width=200 height=200><br>");
		out.println("Select File:<br>");
		out.println("<input type='file' name='bicon' ><br><br><input type='submit' name='btn' value='Update Icon'>");
		out.println("</td></table>");
		
		out.println("</table>");
		out.println("<br><br><input type='submit' name='btn' value='Edit'>&nbsp;&nbsp;&nbsp;<input type='submit' name='btn' value='Delete'>");
		out.println("</form></html>");
		
		}
		catch(Exception e){
			out.println(""+e);
		}

	}

}
