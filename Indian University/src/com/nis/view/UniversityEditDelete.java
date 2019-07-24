package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.nis.controller.UniversityController;
import com.nis.model.UniversityModel;

/**
 * Servlet implementation class UniversityEditDelete
 */
@WebServlet("/UniversityEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class UniversityEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UniversityEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out=response.getWriter();
	try{
	String btn=request.getParameter("btn");	
	if(btn.equals("Edit"))
	{ UniversityModel U=new UniversityModel();
	U.setUniversityid(Integer.parseInt(request.getParameter("uid")));
	U.setUniversityname(request.getParameter("uname")); 
    U.setEstyear(request.getParameter("uyear"));
    U.setAddress(request.getParameter("uadd"));
    if(request.getParameter("ustate").equals("-State-"))
    {
    U.setState(request.getParameter("pstate"));
    U.setCity(request.getParameter("pcity"));
    }
    else
    {  U.setState(request.getParameter("ustate"));
    U.setCity(request.getParameter("city"));
    	
    	
    }
    U.setContactperson(request.getParameter("ucp"));
    U.setMobileno(request.getParameter("umobile"));
    U.setEmailid(request.getParameter("uemail"));
    U.setDescription(request.getParameter("udes"));
	boolean st=UniversityController.editRecord(U);	
	response.sendRedirect("DisplayAllUniversities");	
		
	}
	else if(btn.equals("Delete"))
	{
	 boolean st=UniversityController.deleteRecord(Integer.parseInt(request.getParameter("uid")));	
	 response.sendRedirect("DisplayAllUniversities");	
	}
	else if(btn.equals("Update Logo"))
	{Part P=request.getPart("ulogo");
	FileUpload F=new FileUpload(P,"F:/Eclipse Mars/eclipse/IndianUniversity/WebContent/images/uni");
     
	 boolean st=UniversityController.updatePicture(Integer.parseInt(request.getParameter("uid")),F.filename);	
	 response.sendRedirect("DisplayAllUniversities");	
	}
		
		
		
	}catch(Exception e){
	 out.println(e);	
	}
	
	}

}
