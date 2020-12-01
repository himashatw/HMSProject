package hms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hms.dao.DoctorDao;
import hms.model.Doctor;

/**
 * Servlet implementation class DoctorFormDataController
 */
@WebServlet("/DoctorFormDataController")
public class DoctorFormDataController extends HttpServlet {
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int dID = Integer.parseInt(request.getParameter("dID"));
		Doctor existingDoctor =DoctorDao.selectUser(dID); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("doctorUpdate.jsp");
		request.setAttribute("existingDoctor", existingDoctor);
		dispatcher.forward(request, response);

		
	}

	

}
