package hms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hms.dao.LoginDao;

/**
 * Servlet implementation class LoginAcontroller
 */
@WebServlet("/loginAdmin")
public class LoginAcontroller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String adminEmail=request.getParameter("adminEmail");
		String adminPass=request.getParameter("adminPass");
		
		LoginDao dao=new LoginDao();
		
		
		if(dao.checklogin(adminEmail,adminPass))
		{
			HttpSession session=request.getSession();
			session.setAttribute("adminEmail", adminEmail);
			response.sendRedirect("dashboard.jsp");
		}
		else
		{
			response.sendRedirect("loginA.jsp");
		}
	}

	
}
