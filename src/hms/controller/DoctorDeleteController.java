package hms.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hms.dao.DoctorDao;


/**
 * Servlet implementation class DoctorDeleteController
 */
@WebServlet("/DoctorDeleteController")
public class DoctorDeleteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int dID = Integer.parseInt(request.getParameter("dID"));
		try {
			DoctorDao.deleteUser(dID);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		response.sendRedirect("DoctorListController");
		
		
	}

	

}
