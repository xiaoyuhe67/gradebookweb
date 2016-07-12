package gradebook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.Dataget;

/**
 * Servlet implementation class gradebookServlet
 */
@WebServlet("/gradebookServlet")
public class gradebookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gradebookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
		String method = request.getParameter("method");
		
		
		if(method!=null){ 
					    
		if (method.equals("Delete")) { 
	  
		String gradeid = request.getParameter("gradeid"); 
		long longgradeid=Dataget.getgradeid(gradeid);
		model.Student stu=customTools.Dataget.studentofstudentid(longgradeid);
		
		customTools.Dataget.delete(stu); 
		
		List<model.Student> Students=customTools.Dataget.Student();
		session.setAttribute("Students", Students);
		request.getServletContext().getRequestDispatcher("/gradebook.jsp").forward(request, response);;
					        
		}else if(method.equals("Edit"))
		{
			request.getServletContext().getRequestDispatcher("/gradebook.jsp").forward(request, response);;
		}
		else if (method.equals("Save")) { 
			String gradeid = request.getParameter("gradeid"); 
			long longgradeid=Dataget.getgradeid(gradeid);
			model.Student stu=customTools.Dataget.studentofstudentid(longgradeid);
			
			String studentid=request.getParameter("studentid");
			String assignmentname= request.getParameter("assignmentname");
	        String type= request.getParameter("type");
	        String gradedate=request.getParameter("gradedate");
	        String grade=request.getParameter("grade");
	        stu.setStudentid(studentid);
	        stu.setGradedate(Dataget.todate(gradedate));
	        stu.setAssignmentname(assignmentname);
	        stu.setType(type);
	        stu.setGrade(Double.parseDouble(grade));
	        
	        customTools.Dataget.update(stu);
	        
	        List<model.Student> Students=customTools.Dataget.Student();
			session.setAttribute("Students", Students);
			request.getServletContext().getRequestDispatcher("/gradebook.jsp").forward(request, response);;
						        
		 }
		else if(method.equals("Insert"))
		{
			Date date=new Date();
			session.setAttribute("Date", date);
			request.getServletContext().getRequestDispatcher("/gradebook.jsp").forward(request, response);;
		}
		
		 else if (method.equals("Add")) { 
			 
			 String studentid=request.getParameter("insertstudentid");
			 String assignmentname= request.getParameter("insertassignmentname");
		     String type= request.getParameter("inserttype");
		     String gradedate=request.getParameter("insertgradedate");
		     String grade=request.getParameter("insertgrade");  
		     
			model.Student stu=new model.Student(); 
			stu.setStudentid(studentid);
			stu.setGradedate(Dataget.todate(gradedate));
	        stu.setAssignmentname(assignmentname);
	        stu.setType(type);
	        stu.setGrade(Double.parseDouble(grade));
	        
	        customTools.Dataget.insert(stu);
	        
	        List<model.Student> Students=customTools.Dataget.Student();
			session.setAttribute("Students", Students);
			request.getServletContext().getRequestDispatcher("/gradebook.jsp").forward(request, response);;
			

		 }else if (method.equals("Show"))
		{
			List<model.Student> Students=customTools.Dataget.Student();
		
			session.setAttribute("Students", Students);
			request.getServletContext().getRequestDispatcher("/gradebook.jsp").forward(request, response);;
		}
		 else if(method.equals("Searchbystudent"))
		 {
			 String studentid=request.getParameter("limitedtextarea");
			 List<model.Student> Students=customTools.Dataget.searchbystudent(studentid);
			 session.setAttribute("Students", Students);
			 request.getServletContext().getRequestDispatcher("/gradebook.jsp").forward(request, response);;
		 }
		 else if(method.equals("Searchbyhomework"))
		 {
			 String studentid=request.getParameter("limitedtextarea");
			 if(studentid.equals(""))
			 {
			 List<model.Student> Students=customTools.Dataget.searchbyhomework();
			 session.setAttribute("Students", Students);
			 request.getServletContext().getRequestDispatcher("/gradebook.jsp").forward(request, response);;
			 }
			 else
			 {
				 List<model.Student> Students=customTools.Dataget.searchbyhomework(studentid);
				 session.setAttribute("Students", Students);
				 request.getServletContext().getRequestDispatcher("/gradebook.jsp").forward(request, response);;
			 }
		 }
		 else if(method.equals("Searchbyquiz"))
		 {
			 String studentid=request.getParameter("limitedtextarea");
			 
			 if(studentid.equals(""))
			 {
				 List<model.Student> Students=customTools.Dataget.searchbyquiz();
				 session.setAttribute("Students", Students);
				 request.getServletContext().getRequestDispatcher("/gradebook.jsp").forward(request, response);; 
			 }
			 else
			 {
				 List<model.Student> Students=customTools.Dataget.searchbyquiz(studentid);
				 session.setAttribute("Students", Students);
				 request.getServletContext().getRequestDispatcher("/gradebook.jsp").forward(request, response);;
			 }
			 
		 }
		 else if(method.equals("Searchbytest"))
		 {
			 String studentid=request.getParameter("limitedtextarea");
			 if(studentid.equals(""))
			 {
				 List<model.Student> Students=customTools.Dataget.searchbytest();
				 session.setAttribute("Students", Students);
				 request.getServletContext().getRequestDispatcher("/gradebook.jsp").forward(request, response);;
			 }
			 else
			 {
				 List<model.Student> Students=customTools.Dataget.searchbytest(studentid);
				 session.setAttribute("Students", Students);
				 request.getServletContext().getRequestDispatcher("/gradebook.jsp").forward(request, response);;
			 }
			 
		 }
		 else if(method.equals("Searchbyproject"))
		 {
			 String studentid=request.getParameter("limitedtextarea");
			 if(studentid.equals(""))
			 {
				 List<model.Student> Students=customTools.Dataget.searchbyproject();
				 session.setAttribute("Students", Students);
				 request.getServletContext().getRequestDispatcher("/gradebook.jsp").forward(request, response);;
			 }
			 else
			 {
				 List<model.Student> Students=customTools.Dataget.searchbyproject(studentid);
				 session.setAttribute("Students", Students);
				 request.getServletContext().getRequestDispatcher("/gradebook.jsp").forward(request, response);;
			 }
			 
		 }
		 else if(method.equals("Averagebystudent"))
		 {
			 HashMap<String, String> averagebystudent=customTools.Dataget.averagebystudent();
			 List<model.Student> Students=customTools.Dataget.Student();
				
				session.setAttribute("Students", Students);
			 session.setAttribute("Averagebystudent", averagebystudent);
			 request.getServletContext().getRequestDispatcher("/gradebook.jsp").forward(request, response);; 
			 
		 }
		 else if(method.equals("Averagebystudenttype"))
		 {
			 String studentid=request.getParameter("limitedtextarea");
			 HashMap<String, String> averagebystudenttype=customTools.Dataget.averagebystudenttype(studentid);
			 List<model.Student> Students=customTools.Dataget.Student();
				
				session.setAttribute("Students", Students);
			 session.setAttribute("Averagebystudenttype", averagebystudenttype);
			 request.getServletContext().getRequestDispatcher("/gradebook.jsp").forward(request, response);; 	 
		 }
		 else if(method.equals("highlowbytype"))
		 {
			 
			 List<model.Student> Students=customTools.Dataget.Student();
			 HashMap<String, String> smallmap=customTools.Dataget.highlowbytype();
		      HashMap<String, String> smallmap1=customTools.Dataget.highlowbytype1();
		        
			 session.setAttribute("Students", Students);
			 session.setAttribute("highlowbytype", smallmap);
			 session.setAttribute("highlowbytype1", smallmap1);
			 request.getServletContext().getRequestDispatcher("/gradebook.jsp").forward(request, response);; 
		 }
		
		
		
	}
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
