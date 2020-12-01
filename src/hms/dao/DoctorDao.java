package hms.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hms.model.Doctor;
import hms.model.Patient;



public class DoctorDao {
	
	public static List<Doctor> selectAllUsers() {

		List<Doctor> Doctors = new ArrayList<>();
		String SELECT_ALL_USERS = "select * from doctor";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			 String connectionUrl =
		                "jdbc:sqlserver://52.237.113.122:3306;"
		                        + "database=student_ms;"
		                        + "user=itpuser;"
		                        + "password=itp@123AdminPassword;"
		                        + "encrypt=true;"
		                        + "trustServerCertificate=false;"
		                        + "loginTimeout=30;";
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsproject", "root", "");
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_USERS);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int dID = rs.getInt("dID");
				String name = rs.getString("name");
				int contact = rs.getInt("contact");
				String specialization = rs.getString("specialization");
				String time = rs.getString("time");
				String email = rs.getString("email");
				String password = rs.getString("password");
				

				Doctors.add(new Doctor(dID, name, contact, specialization, time, email, password));
			}
		} catch (Exception E) {
			E.printStackTrace();
		}
		return Doctors;
	}
	
	
	public static Doctor selectUser(int dID) {
		Doctor doctor = null;
		String SELECT_USER_BY_ID = "select * from doctor where dID =?";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsproject", "root", "");
			PreparedStatement ps = con.prepareStatement(SELECT_USER_BY_ID);
			ps.setInt(1, dID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int _dID = rs.getInt("dID");
				String name = rs.getString("name");
				int contact = rs.getInt("contact");
				String specialization = rs.getString("specialization");
				String time = rs.getString("time");
				String email = rs.getString("email");
				String password = rs.getString("password");
				

				doctor = new Doctor(_dID, name, contact, specialization, time, email, password);
			}

		} catch (Exception E) {
			E.printStackTrace();
		}

		return doctor;
	}
	
	
	public static boolean updateUser(Doctor doctor) throws SQLException {
		boolean rawUpdated = false;
		String UPDATE_USERS_SQL = "update doctor set dID =?,name=?,contact=?,specialization=?,time=?,email=?,password=? where dID = ?;";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsproject", "root", "");
			PreparedStatement ps = con.prepareStatement(UPDATE_USERS_SQL);
			ps.setInt(1, doctor.getdID());
			ps.setString(2, doctor.getName());
			ps.setInt(3, doctor.getContact());
			ps.setString(4, doctor.getSpecialization());
			ps.setString(5, doctor.getTime());
			ps.setString(6, doctor.getEmail());
			ps.setString(7, doctor.getPassword());
			ps.setInt(8, doctor.getdID());
			rawUpdated = ps.executeUpdate()>0;
			

		} catch (Exception E) {
			E.printStackTrace();
		}

		return rawUpdated;

	}
	
	public static boolean deleteUser(int dID) throws SQLException {
		boolean rawDeleted=false;
		String DELETE_USERS_SQL = "delete from doctor where dID = ?;";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsproject", "root", "");
			PreparedStatement ps = con.prepareStatement(DELETE_USERS_SQL);
			ps.setInt(1, dID);
			rawDeleted = ps.executeUpdate() > 0;
			
			
		}catch(Exception E)
		{
			E.printStackTrace();
		}
		
		return rawDeleted;
		
	}
	
	
	public static void insertUser(Doctor doctor) throws SQLException {
		String INSERT_USERS_SQL = "INSERT INTO doctor" + "  (name, contact, specialization, time, email, password) VALUES "
				+ " (?, ?, ?, ?, ?, ?);";
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsproject", "root", "");
				PreparedStatement ps = con.prepareStatement(INSERT_USERS_SQL);
				
				
					ps.setString(1, doctor.getName());
					ps.setInt(2, doctor.getContact());
					ps.setString(3, doctor.getSpecialization());
					ps.setString(4, doctor.getTime());
					ps.setString(5, doctor.getEmail());
					ps.setString(6, doctor.getPassword());
					ps.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
	}
	
	
}
