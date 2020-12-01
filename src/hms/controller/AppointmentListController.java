package hms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hms.dao.AppointmentDao;
import hms.model.Appointment;

/**
 * Servlet implementation class AppointmentListController
 */
@WebServlet("/AppointmentListController")
public class AppointmentListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Appointment> listAppointments = AppointmentDao.selectAllUsers();
		request.setAttribute("listAppointments", listAppointments);
		RequestDispatcher dispatcher = request.getRequestDispatcher("appointments.jsp");
		dispatcher.forward(request, response);
		
	}

}
