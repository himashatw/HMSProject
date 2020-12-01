package hms.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class LoginDao {

	String CHECK_LOGIN="select * from admin where email=? AND password=?";
	
	public boolean checklogin(String adminEmail,String adminPass)
	{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsproject", "root","");
			PreparedStatement ps=con.prepareStatement(CHECK_LOGIN);
			ps.setString(1, adminEmail);
			ps.setString(2, adminPass);
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
