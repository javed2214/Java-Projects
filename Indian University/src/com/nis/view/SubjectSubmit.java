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

import com.nis.controller.BranchController;
import com.nis.controller.SubjectController;
import com.nis.model.BranchModel;
import com.nis.model.SubjectModel;

/**
 * Servlet implementation class SubjectSubmit
 */
@WebServlet("/SubjectSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)

public class SubjectSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter out= response.getWriter();
		SubjectModel S = new SubjectModel();
		 
		S.setBranchid(request.getParameter("bname"));
		S.setSubjectname(request.getParameter("sname"));
		S.setSemester(request.getParameter("ssem"));
		S.setRemark(request.getParameter("remark"));

		boolean st=SubjectController.addNewRecord(S);
		
		out.println("<html>");
		if(st)
		{
			out.println("Record Submitted........");
		}
		else
		{
			out.println("Fail to Submit Record....");
		}
		out.println("</html>");
	    out.flush();
	}

	
	}


