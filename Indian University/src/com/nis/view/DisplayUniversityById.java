package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.UniversityController;
import com.nis.model.UniversityModel;

/**
 * Servlet implementation class DisplayUniversityById
 */
@WebServlet("/DisplayUniversityById")
public class DisplayUniversityById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayUniversityById() {
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
	UniversityModel U=UniversityController.displayById(Integer.parseInt(request.getParameter("uid")));
	if(U==null)
	{
	out.println("<html><b>University ID not Exist</b></html>");	
	}
	else
	{
	out.println("<script src=asset/jquery-2.2.1.min.js></script>");
	out.println("<script src=asset/statecity.js></script>");
			
	out.println("<html>");
	out.println("<form action='UniversityEditDelete' method='post' enctype='multipart/form-data'>");
	out.println("<table>");
	out.println("<tr><td align='top'>");
	out.println("<table>");
	out.println("<caption><b><i>University Register - Updation</i><b></caption>");
  out.println("<input type=hidden value="+U.getUniversityid()+" name=uid>");
  
	out.println("<tr>");
	out.println("<td><b><i>University Name:</i><b></td>");
	out.println("<td><input type='text' name='uname' value='"+U.getUniversityname()+"'></td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td><b><i>Established Year:</i><b></td>");
	out.println("<td><input type='text' name='uyear' value='"+U.getEstyear()+"'></td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td><b><i>Address:</i><b></td>");
	out.println("<td><textarea rows='3' cols='30' name=uadd>"+U.getAddress()+"</textarea></td>");
	out.println("</tr>");
	
	out.println("<tr>");
	String arrayState[]=U.getState().split(",");
	
	out.println("<td><b><i>State:</i><b></td>");
	out.println("<td><select name='ustate' id='ustate'><option>-State-</option></select> <b>"+arrayState[1]+"<input type=hidden name=pstate value="+arrayState[0]+"></td>");
	out.println("</tr>");

	String arrayCity[]=U.getCity().split(",");	
	out.println("<tr>");
	out.println("<td><b><i>City:</i><b></td>");
	out.println("<td><select name='city' id='city'><option>-City-</option></select> <b>"+arrayCity[1]+"<input type=hidden value="+arrayCity[0]+" name=pcity></td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td><b><i>Contact Person:</i><b></td>");
	out.println("<td><input type='text' name='ucp' value='"+U.getContactperson()+"'></td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td><b><i>Mobile No:</i><b></td>");
	out.println("<td><input type='text' name='umobile' value='"+U.getMobileno()+"'></td>");
	out.println("</tr>");
	
	
	out.println("<tr>");
	out.println("<td><b><i>Email:</i><b></td>");
	out.println("<td><input type='email' name='uemail' value='"+U.getEmailid()+"'></td>");
	out.println("</tr>");

	out.println("<tr>");
	out.println("<td><b><i>Description:</i><b></td>");
	out.println("<td><textarea rows='3' cols='30' name='udes'>"+U.getDescription()+"</textarea></td>");
	out.println("</tr>");
 
	out.println("</table></td>");
    out.println("<td valign='top'>");
    out.println("<img src=images/uni/"+U.getLogo()+" width=200 height=200><br>");
	out.println("Select File:<br>");
	out.println("<input type='file' name='ulogo'><br><br><input type='submit' name='btn' value='Update Logo'>");
	out.println("</td></table>");
  
    
    
    
    out.println("<input type='submit' value='Edit' name='btn'> <input type='submit' value='Delete' name='btn'>");
    out.println("</form></html>");	
	}	
	}catch(Exception e){
		out.println(e);
	}
	
	}
	
	 

}
