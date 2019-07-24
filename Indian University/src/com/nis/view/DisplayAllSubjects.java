package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.BranchController;
import com.nis.controller.SubjectController;

/**
 * Servlet implementation class DisplayAllSubjects
 */
@WebServlet("/DisplayAllSubjects")
public class DisplayAllSubjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllSubjects() {
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
		    	ResultSet rs=SubjectController.displayAll();  
		    	  if(rs.next())
		    	  {
		    	   out.println("<html><center><table border=1 width=70% height=50%>");
		    	   out.println("<caption><b>Subject List</b></caption>");
		    	   out.println("<tr><th>Sn</th><th>Subject</th><th>Branch</th><th>Semester</th><th>Remark</th><th>Update</th></tr>");
		    	   int sn=1;
		    	   do{
		    		out.println("<tr><td>"+sn+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td>"
		    	   		+ "<td>"+rs.getString(6)+"</td><td><a href=DisplaySubjectById?sid="+rs.getString(1)+">Edit/Delete</a></td></tr>");   
		    		  sn++; 
		    	   }while(rs.next()); 
		    	   
		    	   out.println("</table></center></html>");
		    		  
		    	  }
		    	  else
		    	  {
		    	  System.out.println("Record Not Found..");	  
		    	  }
		    	  
		      }catch(Exception e){
		    	out.println(e);  
		    	  
		      }
	}

}
