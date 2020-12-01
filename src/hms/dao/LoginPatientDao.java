package hms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class LoginPatientDao {
	String CHECK_LOGIN="select * from patient where email=? AND password=?";

	public boolean checklogin(String patEmail,String patPass)
	{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsproject", "root","");
			PreparedStatement ps=con.prepareStatement(CHECK_LOGIN);
			ps.setString(1, patEmail);
			ps.setString(2, patPass);
			ResultSet rs=ps.executeQuery();
			
			
			if(rs.next())
			{
				return true;
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
}
