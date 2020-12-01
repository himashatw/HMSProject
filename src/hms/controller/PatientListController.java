package hms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hms.dao.PatientDao;
import hms.model.Patient;

/**
 * Servlet implementation class PatientListController
 */
@WebServlet("/listPatients")
public class PatientListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Patient> listPatients = PatientDao.selectAllUsers();
		request.setAttribute("listPatients", listPatients);
		RequestDispatcher dispatcher = request.getRequestDispatcher("patients.jsp");
		dispatcher.forward(request, response);

	}

}
