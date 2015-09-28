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
    			double timezone=data.getDouble(8);
    			lms.add(new LocationModel(id, name, desc, phone, head, city, country, timezone));


    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error while viewing");
    		e.printStackTrace();
    		throw new SQLException();
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
    		ResultSet data=stat.executeQuery();
    		
    		while(data.next())
    		{
    			
    			int uid=data.getInt(1);
    			String name=data.getString(2);
    			String desc=data.getString(3);
    			String phone=data.getString(4);
    			String head=data.getString(5);
    			String city=data.getString(6);
    			String country=data.getString(7);
    			double timezone=data.getDouble(8);
    			loc=new LocationModel(uid, name, desc, phone, head, city, country, timezone);
    			
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error while viewing");
    		e.printStackTrace();
    		throw new SQLException();
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
    		ResultSet data=stat.executeQuery();
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
    			double timezone=data.getDouble(8);
    			loc=new LocationModel(uid, lName, desc, phone, head, city, country, timezone);
    			
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error while viewing");
    		throw new SQLException();
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
    		ResultSet data=stat.executeQuery();
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
    			double timezone=data.getDouble(8);
    			lms.add(new LocationModel(uid, lName, desc, phone, head, lCity, lCountry, timezone));
    			
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error while viewing");
    		throw new SQLException();
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
    		ResultSet data=stat.executeQuery();
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
    			double timezone=data.getDouble(8);
    			loc=new LocationModel(uid, lName, desc, phone, lHead, city, country, timezone);
    			
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error while viewing");
    		throw new SQLException();
    	}
    	return loc;
    }    
    
	public boolean insertLocation(String lName, String lDesc, String lPhone, String lHead, String lCity, String lCountry, double lTimeZone) throws SQLException
	{
		try
		{
			String seqSt="SELECT l_id_seq.NEXTVAL FROM dual";
			Connection con=DB.getDBConnection();
			Statement st=con.createStatement();
			ResultSet r=st.executeQuery(seqSt);
			r.next();
			int seqNum=r.getInt(1);
			st.close();
			
			String insSt="INSERT INTO Location VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stat=DB.getDBConnection().prepareStatement(insSt);
			stat.setInt(1, seqNum);
			stat.setString(2, lName);
			stat.setString(3, lDesc);
			stat.setString(4, lPhone);
			stat.setString(5, lHead);
			stat.setString(6, lCity);
			stat.setString(7, lCountry);
			stat.setDouble(8, lTimeZone);
			int res=stat.executeUpdate();
			if (res>0)
				System.out.println("Data inserted");
		}
		catch (Exception e)
		{
			System.out.println("Error inserting");
			throw new SQLException();
		}
		return true;
	}
	public boolean updateLocationHead(int lId, String lHead) throws SQLException
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

			throw new SQLException();
			
		}
		return true;
	}
	public boolean updateLocationPlace(int lId, String city, String country, double timeZone) throws SQLException
	{
		try
		{
			String updateSt="UPDATE Location SET l_city=?, l_country=?, l_timezone=? WHERE l_id=?";
			PreparedStatement stat=DB.getDBConnection().prepareStatement(updateSt);
			stat.setString(1, city);
			stat.setString(2, country);
			stat.setDouble(3, timeZone);
			stat.setInt(4, lId);
			int res=stat.executeUpdate();
			if (res>0)
			{
				System.out.println("Data updated");
			}
		}
		catch (Exception e)
		{
			System.out.println("Error while updating");
			e.printStackTrace();

			throw new SQLException();
		}
		return true;
	}
	public boolean updateLocationPhone(int lId, String lPhone) throws SQLException
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

			throw new SQLException();
		}
		return true;
	}
	
	public boolean updateLocationDetails(int lId, String lPhone, String lHead, String city, String country, double timeZone) throws SQLException
	{
		try
		{
			String updateSt="UPDATE Location SET l_phone=?, l_head=?, l_city=?, l_country=?, l_timezone=? WHERE l_id=?";
			PreparedStatement stat=DB.getDBConnection().prepareStatement(updateSt);
			stat.setString(1, lPhone);
			stat.setString(2, lHead);
			stat.setString(3, city);
			stat.setString(4, country);
			stat.setDouble(5, timeZone);
			stat.setInt(6, lId);
			int res=stat.executeUpdate();
			if (res>0)
			{
				System.out.println("Data updated");
			}
		}
		catch (Exception e)
		{
			System.out.println("Error while updating");

			throw new SQLException();
		}
		return true;
	}
	
	
	public boolean deleteLocation(int lId) throws SQLException
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
			e.printStackTrace();

			throw new SQLException();
		}
		return true;
	}
	

}