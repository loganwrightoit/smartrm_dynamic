package srm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import srm.model.LocationResource;
import srm.model.RegisteredResource;

public class RegisteredResourceDAO
{

	public RegisteredResource viewResource(int rr_id)
	{
		try
		{
			String updateSt="SELECT * FROM registeredresource WHERE rr_id = ?";
			PreparedStatement pstat = DB.getDBConnection().prepareStatement(updateSt);
			pstat.setInt(1, rr_id);
			ResultSet rset = pstat.executeQuery();

    		// Test for empty set
    		if (!rset.isBeforeFirst()) {
    			return null;
    		} else {
    			rset.next();
    			return new RegisteredResource(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getInt(4), rset.getString(5), rset.getInt(6));
    		}
			
		}
		catch (Exception e)
		{
			System.out.println("Encountered error while calling for registered resource by id.");
			e.printStackTrace();
		}
		
		return null;
	}
	
	    public ArrayList<RegisteredResource> viewLocation() throws SQLException
	    {
	    	ArrayList<RegisteredResource> rms=new ArrayList<>();
	    	try
	    	{
	    		
	    		String selSt="Select * FROM registeredresource";
	    		Statement stat=DB.getDBConnection().createStatement();
	    		ResultSet data=stat.executeQuery(selSt);
	    		ResultSetMetaData meta=data.getMetaData();
	    		int colCount=meta.getColumnCount();
	    		while(data.next())
	    		{
	    			int id=data.getInt(1);
	    			String name=data.getString(2);
	    			int l_id=data.getInt(3);
	    			int r_id=data.getInt(4);
	    			String specPurpose=data.getString(5);
	    			int cap=data.getInt(6);
	    			rms.add(new RegisteredResource(id, name, l_id, r_id, specPurpose, cap));


	    		}
	    		
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("Error while viewing");
	    		e.printStackTrace();
	    		throw new SQLException();
	    	}
	    	return rms;
	    }
	    
	    public ArrayList<RegisteredResource> viewResourceByLocationId(int l_id) throws SQLException
	    {
	    	ArrayList<RegisteredResource> list = new ArrayList<RegisteredResource>();
	    	
	    	try
	    	{
	    		String selSt="SELECT rr.rr_id, rr.rr_name, rr.l_id, rr.r_id, lr.r_name, rr.special_features, rr.capacity " +
	    				     "FROM registeredresource rr " +
	    				     "JOIN locationresource lr " +
	    				     "ON rr.r_id = lr.r_id " +
	    				     "WHERE l_id = ?";
	    		PreparedStatement stat=DB.getDBConnection().prepareStatement(selSt);
	    		stat.setInt(1, l_id);
	    		ResultSet data=stat.executeQuery();
	    		
	    		while(data.next())
	    		{
	    			
	    			int rrId=data.getInt(1);
	    			String rrName=data.getString(2);
	    			int lId=data.getInt(3);
	    			int rId=data.getInt(4);
	    			String rName=data.getString(5);
	    			String specFeatures=data.getString(6);
	    			int cap=data.getInt(7);
	    			list.add(new RegisteredResource(rrId, rrName, lId, rId, rName, specFeatures, cap));
	    			
	    		}
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("Error while viewing");
	    		e.printStackTrace();
	    		throw new SQLException();
	    	}
	    	
	    	return list;
	    }

		public boolean insertRegisteredResource(String rName, int lId, int rId, String specFeatures, int cap) throws SQLException
		{
			try
			{				
				String insSt="INSERT INTO registeredresource VALUES (rr_id_seq.NEXTVAL, ?, ?, ?, ?, ?)";
				PreparedStatement stat=DB.getDBConnection().prepareStatement(insSt);
				stat.setString(1, rName);
				stat.setInt(2, lId);
				stat.setInt(3, rId);
				stat.setString(4, specFeatures);
				stat.setInt(5, cap);
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
		
		public boolean updateResourceDetails(int rr_id, String special_features, int capacity) throws SQLException
		{
			try
			{
				String updateSt="UPDATE registeredresource SET special_features = ?, capacity = ? WHERE rr_id = ?";
				PreparedStatement pstat = DB.getDBConnection().prepareStatement(updateSt);
				pstat.setString(1, special_features);
				pstat.setInt(2, capacity);
				pstat.setInt(3, rr_id);
				int res = pstat.executeUpdate();
				if (res > 0)
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
		
		
		public boolean deleteRegisteredResource(int rrId) throws SQLException
		{
			try
			{
				String delSt="DELETE FROM registeredresource WHERE rr_id=?";
				PreparedStatement stat=DB.getDBConnection().prepareStatement(delSt);
				stat.setInt(1, rrId);
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

