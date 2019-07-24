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
 * Servlet implementation class UniversitySubmit
 */
@WebServlet("/UniversitySubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class UniversitySubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UniversitySubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
        UniversityModel U=new UniversityModel();  
		U.setUniversityname(request.getParameter("uname")); 
        U.setEstyear(request.getParameter("uyear"));
	    U.setAddress(request.getParameter("uadd"));
	    U.setState(request.getParameter("ustate"));
	    U.setCity(request.getParameter("city"));
	    U.setContactperson(request.getParameter("ucp"));
	    U.setMobileno(request.getParameter("umobile"));
	    U.setEmailid(request.getParameter("uemail"));
	    U.setDescription(request.getParameter("udes"));
	   // U.setLogo(request.getParameter("ulogo"));
	    Part P=request.getPart("ulogo");
		FileUpload F=new FileUpload(P,"F:/Eclipse Mars/eclipse/IndianUniversity/WebContent/images/uni");
	    U.setLogo(F.filename);
	    boolean st=UniversityController.addNewRecord(U);
        out.println("<html>");
        if(st)
        {
         out.println("Record Submitted..."); 	
         
;        }
        else
        {
        	out.println("Fail to Submit Record...");
        }
        out.println("</html>");
        out.flush();
	}

}




