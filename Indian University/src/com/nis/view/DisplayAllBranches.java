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
import com.nis.controller.UniversityController;

/**
 * Servlet implementation class DisplayAllBranches
 */
@WebServlet("/DisplayAllBranches")
public class DisplayAllBranches extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllBranches() {
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
		    	ResultSet rs=BranchController.displayAll();  
		    	  if(rs.next())
		    	  {
		    	   out.println("<html><center><table border=1 width=70% height=50%>");
		    	   out.println("<caption><b>Branch List</b></caption>");
		    	   out.println("<tr><th>Sn</th><th>Icon</th><th>University<br>Name</th><th>Branch</th><th>Semester</th><th>Update</th></tr>");
		    	   int sn=1;
		    	   do{
		    		out.println("<tr><td>"+sn+","+rs.getString(1)+" </td><td><img src=images/bicon/"+rs.getString(6)+" width=100 height=100></td><td>"
		    	   +rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td>"
		    	   		+ "<td><a href=DisplayBranchById?bid="+rs.getString(1)+">Edit/Delete</a></td></tr>");   
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
