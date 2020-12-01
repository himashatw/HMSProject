package hms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hms.dao.LoginDao;
import hms.dao.LoginDoctorDao;

/**
 * Servlet implementation class LoginDcontroller
 */
@WebServlet("/LoginDcontroller")
public class LoginDcontroller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String docEmail=request.getParameter("docEmail");
		String docPass=request.getParameter("docPass");
		
		LoginDoctorDao daoD=new LoginDoctorDao();
		
		
		if(daoD.checklogin(docEmail,docPass))
		{
			HttpSession session=request.getSession();
			session.setAttribute("docEmail", docEmail);
			response.sendRedirect("google.lk");
		}
		else
		{
			response.sendRedirect("loginD.jsp");
		}
		
	}

	

}
