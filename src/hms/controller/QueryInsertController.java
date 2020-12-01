package hms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hms.dao.DoctorDao;
import hms.dao.QueryDao;
import hms.model.Doctor;
import hms.model.Query;

/**
 * Servlet implementation class QueryInsertController
 */
@WebServlet("/QueryInsertController")
public class QueryInsertController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email=request.getParameter("email");
		String subject=request.getParameter("subject");
		String message=request.getParameter("message");
		
		
		Query newQuery = new Query(name, email, subject, message);
		try {
			QueryDao.insertUser(newQuery);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("index.jsp");
		
	
		
		
	}


}
