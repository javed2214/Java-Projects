package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.QuestionController;
import com.nis.model.QuestionModel;

/**
 * Servlet implementation class QuestionSubmit
 */
@WebServlet("/QuestionSubmit")
public class QuestionSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		QuestionModel Q=new QuestionModel();
		 
		Q.setSubjectid(Integer.parseInt(request.getParameter("subject")));
		Q.setYear(Integer.parseInt(request.getParameter("year")));
		Q.setQuestionno(Integer.parseInt(request.getParameter("qno")));
		Q.setQ1(request.getParameter("q1"));
		Q.setQ2(request.getParameter("q2"));
		Q.setQ3(request.getParameter("q3"));

       
		boolean st=QuestionController.addNewRecord(Q);
		
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
