package srm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class LocationDAO {
	

    public boolean viewLocation() throws SQLException
    {
    	try
    	{
    		String selSt="Select * FROM Location";
    		Statement stat=DB.getDBConnection().createStatement();
    		ResultSet data=stat.executeQuery(selSt);
    		ResultSetMetaData meta=data.getMetaData();
    		int colCount=meta.getColumnCount();
    		while(data.next())
    		{

    			System.out.println(data.getInt(1));
    			System.out.println(data.getString(2));
    			System.out.println(data.getString(3));
    			System.out.println(data.getString(4));
    			System.out.println(data.getString(5));
    			System.out.println(data.getString(6));
    			System.out.println(data.getString(7));
    			System.out.println(data.getInt(8));


    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error while viewing");
    		e.printStackTrace();
    	}
    	return true;
    }
    public boolean viewLocationById(int id) throws SQLException
    {
    	try
    	{
    		String selSt="Select * FROM Location WHERE l_id=?";
    		PreparedStatement stat=DB.getDBConnection().prepareStatement(selSt);
    		stat.setInt(1, id);
    		ResultSet data=stat.executeQuery(selSt);
    		ResultSetMetaData meta=data.getMetaData();
    		int colCount=meta.getColumnCount();
    		
    		while(data.next())
    		{
    			
    			System.out.println(data.getInt(1));
    			System.out.println(data.getString(2));
    			System.out.println(data.getString(3));
    			System.out.println(data.getString(4));
    			System.out.println(data.getString(5));
    			System.out.println(data.getString(6));
    			System.out.println(data.getString(7));
    			System.out.println(data.getInt(8));


    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error while viewing");
    	}
    	return true;
    }

    public boolean viewLocationByName(String name) throws SQLException
    {
    	try
    	{
    		String selSt="Select * FROM Location WHERE l_name=?";
    		PreparedStatement stat=DB.getDBConnection().prepareStatement(selSt);
    		stat.setString(1, name);
    		ResultSet data=stat.executeQuery(selSt);
    		ResultSetMetaData meta=data.getMetaData();
    		int colCount=meta.getColumnCount();
    		while(data.next())
    		{

    			System.out.println(data.getInt(1));
    			System.out.println(data.getString(2));
    			System.out.println(data.getString(3));
    			System.out.println(data.getString(4));
    			System.out.println(data.getString(5));
    			System.out.println(data.getString(6));
    			System.out.println(data.getString(7));
    			System.out.println(data.getInt(8));

    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error while viewing");
    	}
    	return true;
    }    
    
    public boolean viewLocationByCity(String city, String country) throws SQLException
    {
    	try
    	{
    		String selSt="Select * FROM Location WHERE l_city=? AND l_country=?";
    		PreparedStatement stat=DB.getDBConnection().prepareStatement(selSt);
    		stat.setString(1, city);
    		stat.setString(2, country);
    		ResultSet data=stat.executeQuery(selSt);
    		ResultSetMetaData meta=data.getMetaData();
    		int colCount=meta.getColumnCount();
    		while(data.next())
    		{

    			System.out.println(data.getInt(1));
    			System.out.println(data.getString(2));
    			System.out.println(data.getString(3));
    			System.out.println(data.getString(4));
    			System.out.println(data.getString(5));
    			System.out.println(data.getString(6));
    			System.out.println(data.getString(7));
    			System.out.println(data.getInt(8));


    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error while viewing");
    	}
    	return true;
    }    
    
    public boolean viewLocationByHead(String head) throws SQLException
    {
    	try
    	{
    		String selSt="Select * FROM Location WHERE l_head=?";
    		PreparedStatement stat=DB.getDBConnection().prepareStatement(selSt);
    		stat.setString(1, head);
    		ResultSet data=stat.executeQuery(selSt);
    		ResultSetMetaData meta=data.getMetaData();
    		int colCount=meta.getColumnCount();
    		while(data.next())
    		{
    			System.out.println(data.getInt(1));
    			System.out.println(data.getString(2));
    			System.out.println(data.getString(3));
    			System.out.println(data.getString(4));
    			System.out.println(data.getString(5));
    			System.out.println(data.getString(6));
    			System.out.println(data.getString(7));
    			System.out.println(data.getInt(8));
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error while viewing");
    	}
    	return true;
    }    
    
	public boolean insertLocation(int lId, String lName, String lDesc, String lPhone, String lHead, String lCity, String lCountry, int lTimeZone)
	{
		try
		{
			String insSt="INSERT INTO Location VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stat=DB.getDBConnection().prepareStatement(insSt);
			stat.setInt(1, lId);
			stat.setString(2, lName);
			stat.setString(3, lDesc);
			stat.setString(4, lPhone);
			stat.setString(5, lHead);
			stat.setString(6, lCity);
			stat.setString(7, lCountry);
			stat.setInt(8, lTimeZone);
			int res=stat.executeUpdate();
			if (res>0)
				System.out.println("Data inserted");
		}
		catch (Exception e)
		{
			System.out.println("Error inserting");
		}
		return true;
	}
	public boolean updateLocationHead(int lId, String lHead)
	{
		try
		{
			String updateSt="UPDATE Location SET l_head=? WHERE l_id=?";
			PreparedStatement stat=DB.getDBConnection().prepareStatement(updateSt);
			stat.setString(1, lHead);
			stat.setInt(2, lId);
			int res=stat.executeUpdate();
			if (res>0)
				System.out.println("Data updated");
		}
		catch (Exception e)
		{
			System.out.println("Error while updating");
			return false;
		}
		return true;
	}
	public boolean updateLocationPlace(int lId, String city, String country, int timeZone)
	{
		try
		{
			String updateSt="UPDATE Location SET l_city=?, l_country=?, l_timezone=? WHERE l_id=?";
			PreparedStatement stat=DB.getDBConnection().prepareStatement(updateSt);
			stat.setString(1, city);
			stat.setString(2, country);
			stat.setInt(3, timeZone);
			int res=stat.executeUpdate();
			if (res>0)
			{
				System.out.println("Data updated");
			}
		}
		catch (Exception e)
		{
			System.out.println("Error while updating");
			return false;
		}
		return true;
	}
	public boolean updateLocationPhone(int lId, String lPhone)
	{
		try
		{
			String updateSt="UPDATE Location SET l_phone=? WHERE l_id=?";
			PreparedStatement stat=DB.getDBConnection().prepareStatement(updateSt);
			stat.setString(1, lPhone);
			stat.setInt(2, lId);
			int res=stat.executeUpdate();
			if (res>0)
			{
				System.out.println("Data updated");
			}
		}
		catch (Exception e)
		{
			System.out.println("Error while updating");
			return false;
		}
		return true;
	}
	public boolean deleteLocation(int lId)
	{
		try
		{
			String delSt="DELETE FROM Location WHERE l_id=?";
			PreparedStatement stat=DB.getDBConnection().prepareStatement(delSt);
			stat.setInt(1, lId);
			int res=stat.executeUpdate();
			if (res>0)
				System.out.println("Data deleted");
		}
		catch (Exception e)
		{
			System.out.println("Error while deleting");
			return false;
		}
		return true;
	}

}