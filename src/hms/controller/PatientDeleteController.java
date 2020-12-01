package hms.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hms.dao.PatientDao;

/**
 * Servlet implementation class PatientDeleteController
 */
@WebServlet("/PatientDeleteController")
public class PatientDeleteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pID = Integer.parseInt(request.getParameter("pID"));
		try {
			PatientDao.deleteUser(pID);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		response.sendRedirect("listPatients");

		
	}

	
}
