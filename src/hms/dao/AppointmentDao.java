package hms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hms.model.Appointment;

public class AppointmentDao {
	
	
	public static List<Appointment> selectAllUsers() {

		List<Appointment> Appointments = new ArrayList<>();
		String SELECT_ALL_USERS = "select * from appointment";
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsproject", "root", "");
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_USERS);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int appID = rs.getInt("appID");
				String details = rs.getString("details");
				String appTime = rs.getString("appTime");
				int pID = rs.getInt("pID");
				int dID = rs.getInt("diD");
				
				

				Appointments.add(new Appointment(appID,details,appTime,pID,dID));
			}
		} catch (Exception E) {
			E.printStackTrace();
		}
		return Appointments;
	}

}
