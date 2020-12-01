package hms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hms.dao.QueryDao;
import hms.model.Query;

/**
 * Servlet implementation class QueryListController
 */
@WebServlet("/QueryListController")
public class QueryListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Query> listQueries = QueryDao.selectAllUsers();
		request.setAttribute("listQueries", listQueries);
		RequestDispatcher dispatcher = request.getRequestDispatcher("queries.jsp");
		dispatcher.forward(request, response);
		
	}


}
