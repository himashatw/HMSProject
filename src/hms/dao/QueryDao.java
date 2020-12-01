package hms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hms.model.Doctor;
import hms.model.Query;

public class QueryDao {
	
	public static List<Query> selectAllUsers() {

		List<Query> Queries = new ArrayList<>();
		String SELECT_ALL_USERS = "select * from query";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsproject", "root", "");
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_USERS);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int qID = rs.getInt("qID");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String subject = rs.getString("subject");
				String message = rs.getString("message");
				String time = rs.getString("time");
				

				Queries.add(new Query(qID, name, email, subject, message, time));
			}
		} catch (Exception E) {
			E.printStackTrace();
		}
		return Queries;
	}
	
	
	public static boolean deleteUser(int qID) throws SQLException {
		boolean rawDeleted=false;
		String DELETE_USERS_SQL = "delete from query where qID = ?;";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsproject", "root", "");
			PreparedStatement ps = con.prepareStatement(DELETE_USERS_SQL);
			ps.setInt(1, qID);
			rawDeleted = ps.executeUpdate() > 0;
			
			
		}catch(Exception E)
		{
			E.printStackTrace();
		}
		
		return rawDeleted;
		
	}
	
	public static void insertUser(Query query) throws SQLException {
		String INSERT_USERS_SQL = "INSERT INTO query" + "  (name, email, subject, message) VALUES "
				+ " (?, ?, ?, ?);";
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsproject", "root", "");
				PreparedStatement ps = con.prepareStatement(INSERT_USERS_SQL);
				
				
					ps.setString(1, query.getName());
					ps.setString(2, query.getEmail());
					ps.setString(3, query.getSubject());
					ps.setString(4, query.getMessage());
					
					ps.executeUpdate();
					
			} catch (Exception E)
			{
				E.printStackTrace();
			}
	}
		
}
