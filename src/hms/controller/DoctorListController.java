package hms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hms.dao.DoctorDao;
import hms.model.Doctor;

/**
 * Servlet implementation class DoctorListController
 */
@WebServlet("/DoctorListController")
public class DoctorListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Doctor> listDoctors = DoctorDao.selectAllUsers();
		request.setAttribute("listDoctors", listDoctors);
		RequestDispatcher dispatcher = request.getRequestDispatcher("doctors.jsp");
		dispatcher.forward(request, response);
		
	}


}
