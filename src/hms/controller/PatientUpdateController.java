package hms.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hms.dao.PatientDao;
import hms.model.Patient;


/**
 * Servlet implementation class PatientUpdateController
 */
@WebServlet("/PatientUpdateController")
public class PatientUpdateController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pID = Integer.parseInt(request.getParameter("pID"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int contact = Integer.parseInt(request.getParameter("contact"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Patient patient = new Patient(pID,name,age,contact,email,password);
		
		try {
			PatientDao.updateUser(patient);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("listPatients");
		
	}

}
