package srm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import srm.model.RegisteredResource;
public class RegisteredResourceDAO {

		public RegisteredResource viewRegisteredResourceByName(String qname) throws SQLException
		{
			RegisteredResource rms = null;
			try
			{
				String selSt="Select * FROM registeredresource where rr_name = ?";
	    		PreparedStatement stat=DB.getDBConnection().prepareStatement("selSt");
	    		stat.setString(1, qname);
	    		ResultSet data=stat.executeQuery();
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
	    			
	    			rms = new RegisteredResource(id,name,l_id,r_id,specPurpose,cap);
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
				String seqSt="SELECT rr_id_seq.NEXTVAL FROM dual";
				Connection con=DB.getDBConnection();
				Statement st=con.createStatement();
				ResultSet r=st.executeQuery(seqSt);
				r.next();
				int seqNum=r.getInt(1);
				st.close();
				
				String insSt="INSERT INTO registeredresource VALUES (?, ?, ?, ?, ?, ?)";
				PreparedStatement stat=DB.getDBConnection().prepareStatement(insSt);
				stat.setInt(1, seqNum);
				stat.setString(2, rName);
				stat.setInt(3, lId);
				stat.setInt(4, rId);
				stat.setString(5, specFeatures);
				stat.setInt(6, cap);
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
		
		public boolean updateResourceDetails(int rrId, String specFeatures, int cap) throws SQLException
		{
			try
			{
				String updateSt="UPDATE registeredresource SET specFeatures=?, cap=? WHERE l_id=?";
				PreparedStatement stat=DB.getDBConnection().prepareStatement(updateSt);
				stat.setString(1, specFeatures);
				stat.setInt(2, cap);
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

