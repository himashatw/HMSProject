package hms.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hms.dao.QueryDao;

/**
 * Servlet implementation class QueryDeleteController
 */
@WebServlet("/QueryDeleteController")
public class QueryDeleteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int qID = Integer.parseInt(request.getParameter("qID"));
		try {
			QueryDao.deleteUser(qID);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		response.sendRedirect("QueryListController");
		
		
	}


}
