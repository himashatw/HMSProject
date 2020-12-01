package hms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hms.model.Patient;

public class PatientDao {

	// SELECT ALL USERS

	public static List<Patient> selectAllUsers() {

		List<Patient> Patients = new ArrayList<>();
		String SELECT_ALL_USERS = "select * from patient";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsproject", "root", "");
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_USERS);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int pID = rs.getInt("pID");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int contact = rs.getInt("contact");
				String email = rs.getString("email");
				String password = rs.getString("password");
				

				Patients.add(new Patient(pID, name, age, contact, email,password));
			}
		} catch (Exception E) {
			E.printStackTrace();
		}
		return Patients;
	}

	// SELECT ONE USER

	public static Patient selectUser(int pID) {
		Patient patient = null;
		String SELECT_USER_BY_ID = "select * from patient where pID =?";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsproject", "root", "");
			PreparedStatement ps = con.prepareStatement(SELECT_USER_BY_ID);
			ps.setInt(1, pID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int _pID = rs.getInt("pID");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int contact = rs.getInt("contact");
				String email = rs.getString("email");
				String password = rs.getString("password");
				

				patient = new Patient(_pID, name, age, contact, email, password);
			}

		} catch (Exception E) {
			E.printStackTrace();
		}

		return patient;
	}

	// UPDATE USER

	public static boolean updateUser(Patient patient) throws SQLException {
		boolean rawUpdated = false;
		String UPDATE_USERS_SQL = "update patient set pID =?,name=?,age=?,contact=?,email=?,password=? where pID = ?;";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsproject", "root", "");
			PreparedStatement ps = con.prepareStatement(UPDATE_USERS_SQL);
			ps.setInt(1, patient.getpID());
			ps.setString(2, patient.getName());
			ps.setInt(3, patient.getAge());
			ps.setInt(4, patient.getContact());
			ps.setString(5, patient.getEmail());
			ps.setString(6, patient.getPassword());
			ps.setInt(7, patient.getpID());
			rawUpdated = ps.executeUpdate()>0;
			

		} catch (Exception E) {
			E.printStackTrace();
		}

		return rawUpdated;

	}
	
	//DELETE USER
	
	public static boolean deleteUser(int pID) throws SQLException {
		boolean rawDeleted=false;
		String DELETE_USERS_SQL = "delete from patient where pID = ?;";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsproject", "root", "");
			PreparedStatement ps = con.prepareStatement(DELETE_USERS_SQL);
			ps.setInt(1, pID);
			rawDeleted = ps.executeUpdate() > 0;
			
			
		}catch(Exception E)
		{
			E.printStackTrace();
		}
		
		return rawDeleted;
		
	}

}
