package hms.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hms.dao.DoctorDao;
import hms.model.Doctor;

/**
 * Servlet implementation class DoctorInsertController
 */
@WebServlet("/DoctorInsertController")
public class DoctorInsertController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		int contact=Integer.parseInt(request.getParameter("contact"));
		String specialization=request.getParameter("specialization");
		String time=request.getParameter("time");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		Doctor newDoctor = new Doctor(name, contact, specialization, time, email, password);
		try {
			DoctorDao.insertUser(newDoctor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("DoctorListController");
		
	}

}
