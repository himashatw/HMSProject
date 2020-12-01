package hms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hms.dao.LoginDoctorDao;
import hms.dao.LoginPatientDao;

/**
 * Servlet implementation class LoginPcontroller
 */
@WebServlet("/LoginPcontroller")
public class LoginPcontroller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String patEmail=request.getParameter("patEmail");
		String patPass=request.getParameter("patPass");
		
		LoginPatientDao daoP=new LoginPatientDao();
		
		
		if(daoP.checklogin(patEmail,patPass))
		{
			HttpSession session=request.getSession();
			session.setAttribute("patEmail", patEmail);
			response.sendRedirect("facebook.com");
		}
		else
		{
			response.sendRedirect("loginP.jsp");
		}
		
	}

	

}
