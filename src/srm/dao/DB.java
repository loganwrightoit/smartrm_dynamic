package srm.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	static Connection con;
	public static Connection getDBConnection()
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "syntel123$");
		}
		catch(Exception ex)
		{
			System.out.println("Error . . "+ex.getMessage());
		}
		return con;
	}
}
