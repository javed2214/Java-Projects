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
import com.nis.controller.UniversityController;
import com.nis.model.BranchModel;

/**
 * Servlet implementation class BranchEditDelete
 */
@WebServlet("/BranchEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class BranchEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchEditDelete() {
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
				BranchModel B=new BranchModel();
				B.setBranchid(Integer.parseInt(request.getParameter("bid")));
				if(request.getParameter("buniversityname").equals("-University-"))
				{
					B.setUniversity(request.getParameter("buniversityname"));
				}
				else{
					B.setUniversity(request.getParameter("puniversity"));
				}
				
				B.setBranchname(request.getParameter("bname"));
				B.setSemester(request.getParameter("bsem"));
				 boolean st=BranchController.editRecord(B);
				response.sendRedirect("DisplayAllBranches");
			}
			else if(btn.equals("Delete"))
			{
				 boolean st=BranchController.deleteRecord(Integer.parseInt(request.getParameter("bid")));
			        response.sendRedirect("DisplayAllBranches");
			}
			else if(btn.equals("Update Icon"))
			{Part P=request.getPart("bicon");
			FileUpload F=new FileUpload(P,"F:/Eclipse Mars/eclipse/IndUni/WebContent/images/bicon");
		     
			 boolean st=BranchController.updatePicture(Integer.parseInt(request.getParameter("bid")),F.filename);	
			 response.sendRedirect("DisplayAllBranches");	
			}
			
		}
		catch(Exception e){
			out.println("Error BranchEditDelete "+e);
		}
			}
	}


