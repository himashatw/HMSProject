package hms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hms.dao.PatientDao;
import hms.model.Patient;


/**
 * Servlet implementation class PatientFormDataController
 */
@WebServlet("/PatientFormDataController")
public class PatientFormDataController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int pID = Integer.parseInt(request.getParameter("pID"));
		Patient existingPatient =PatientDao.selectUser(pID); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("patientUpdate.jsp");
		request.setAttribute("existingPatient", existingPatient);
		dispatcher.forward(request, response);

		
	}

	

}
