package srm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import srm.model.LocationModel;

public class LocationDAO {
	

    public ArrayList<LocationModel> viewLocation() throws SQLException
    {
    	ArrayList<LocationModel> lms=new ArrayList<>();
    	try
    	{
    		
    		String selSt="Select * FROM Location";
    		Statement stat=DB.getDBConnection().createStatement();
    		ResultSet data=stat.executeQuery(selSt);
    		ResultSetMetaData meta=data.getMetaData();
    		int colCount=meta.getColumnCount();
    		while(data.next())
    		{
    			int id=data.getInt(1);
    			String name=data.getString(2);
    			String desc=data.getString(3);
    			String phone=data.getString(4);
    			String head=data.getString(5);
    			String city=data.getString(6);
    			String country=data.getString(7);
    			int timezone=data.getInt(8);
    			lms.add(new LocationModel(id, name, desc, phone, head, city, country, timezone));


    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error while viewing");
    		e.printStackTrace();
    	}
    	return lms;
    }
    public LocationModel viewLocationById(int id) throws SQLException
    {
    	LocationModel loc=null;
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
    			
    			int uid=data.getInt(1);
    			String name=data.getString(2);
    			String desc=data.getString(3);
    			String phone=data.getString(4);
    			String head=data.getString(5);
    			String city=data.getString(6);
    			String country=data.getString(7);
    			int timezone=data.getInt(8);
    			loc=new LocationModel(uid, name, desc, phone, head, city, country, timezone);
    			
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error while viewing");
    	}
    	return loc;
    }

    public LocationModel viewLocationByName(String name) throws SQLException
    {
    	LocationModel loc=null;
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
    			
    			int uid=data.getInt(1);
    			String lName=data.getString(2);
    			String desc=data.getString(3);
    			String phone=data.getString(4);
    			String head=data.getString(5);
    			String city=data.getString(6);
    			String country=data.getString(7);
    			int timezone=data.getInt(8);
    			loc=new LocationModel(uid, lName, desc, phone, head, city, country, timezone);
    			
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error while viewing");
    	}
    	return loc;
    }    
    
    public ArrayList<LocationModel> viewLocationByCity(String city, String country) throws SQLException
    {
    	ArrayList<LocationModel> lms=new ArrayList<>();
 
    	try
    	{
    		String selSt="Select * FROM Location WHERE l_name=?";
    		PreparedStatement stat=DB.getDBConnection().prepareStatement(selSt);
    		stat.setString(1, city);
    		stat.setString(2, country);
    		ResultSet data=stat.executeQuery(selSt);
    		ResultSetMetaData meta=data.getMetaData();
    		int colCount=meta.getColumnCount();
    		
    		while(data.next())
    		{
    			
    			int uid=data.getInt(1);
    			String lName=data.getString(2);
    			String desc=data.getString(3);
    			String phone=data.getString(4);
    			String head=data.getString(5);
    			String lCity=data.getString(6);
    			String lCountry=data.getString(7);
    			int timezone=data.getInt(8);
    			lms.add(new LocationModel(uid, lName, desc, phone, head, lCity, lCountry, timezone));
    			
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error while viewing");
    	}
    	return lms;
    }    
    
    public LocationModel viewLocationByHead(String head) throws SQLException
    {
    	LocationModel loc=null;
    	try
    	{
    		String selSt="Select * FROM Location WHERE l_name=?";
    		PreparedStatement stat=DB.getDBConnection().prepareStatement(selSt);
    		stat.setString(1, head);
    		ResultSet data=stat.executeQuery(selSt);
    		ResultSetMetaData meta=data.getMetaData();
    		int colCount=meta.getColumnCount();
    		
    		while(data.next())
    		{
    			
    			int uid=data.getInt(1);
    			String lName=data.getString(2);
    			String desc=data.getString(3);
    			String phone=data.getString(4);
    			String lHead=data.getString(5);
    			String city=data.getString(6);
    			String country=data.getString(7);
    			int timezone=data.getInt(8);
    			loc=new LocationModel(uid, lName, desc, phone, lHead, city, country, timezone);
    			
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error while viewing");
    	}
    	return loc;
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