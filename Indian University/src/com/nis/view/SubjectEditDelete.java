package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.BranchController;
import com.nis.controller.SubjectController;
import com.nis.model.BranchModel;
import com.nis.model.SubjectModel;

/**
 * Servlet implementation class SubjectEditDelete
 */
@WebServlet("/SubjectEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class SubjectEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
PrintWriter out= response.getWriter();
		
		try{
			String btn=request.getParameter("btn");
			if(btn.equals("Edit")){
				SubjectModel S=new SubjectModel();
				S.setSubjectid(Integer.parseInt(request.getParameter("sid")));
				if(request.getParameter("bname").equals("-Branch-"))
				{
					S.setBranchid(request.getParameter("pbranch"));
				}
				else{
					S.setBranchid(request.getParameter("bname"));
				}
				S.setSubjectname(request.getParameter("sname"));
				S.setSemester(request.getParameter("ssem"));
				S.setRemark(request.getParameter("remark"));
			
				 boolean st=SubjectController.editRecord(S);
				response.sendRedirect("DisplayAllSubjects");
			
			}
			else if(btn.equals("Delete"))
			{
				 boolean st=SubjectController.deleteRecord(Integer.parseInt(request.getParameter("sid")));
			        response.sendRedirect("DisplayAllSubjects");
			}}
			catch(Exception e){
				out.println("Error SubjectEditDelete "+e);
			}
			}
	}


