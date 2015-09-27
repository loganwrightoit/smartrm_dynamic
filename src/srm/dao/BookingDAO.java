package srm.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import srm.model.BookingModel;


public class BookingDAO {
	
	public ArrayList<BookingModel> showAll() throws SQLException
	{
		try
		{
			String selSt = "select * from Booking";
			Statement stat = DB.getDBConnection().createStatement();
			ResultSet data = stat.executeQuery(selSt);
			ResultSetMetaData meta = data.getMetaData();
			
			int count = meta.getColumnCount();
			String temp = null;
			ArrayList<BookingModel> al = new ArrayList<BookingModel>();
						
			
			while(data.next())
			{
				BookingModel tmp = new BookingModel();
				tmp.setB_id(data.getInt(1));
				tmp.setL_id(data.getInt(2));
				tmp.setRr_id(data.getInt(3));
				tmp.setU_id(data.getInt(4));
				tmp.setStart_time(Timestamp.valueOf(data.getString(5)));
				tmp.setEnd_time(Timestamp.valueOf(data.getString(6)));
				tmp.setSpecialrequests(data.getString(7));
				tmp.setPurpose(data.getString(8));
				al.add(tmp);
			}
			return al;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public BookingModel viewBooking() throws SQLException
	{
		try
		{
			String selSt = "Select * from Booking";
			Statement stat = DB.getDBConnection().createStatement();
			ResultSet data = stat.executeQuery(selSt);
			ResultSetMetaData meta = data.getMetaData();
			
			int count = meta.getColumnCount();
			BookingModel temp = new BookingModel();
			while(data.next())
			{
				temp.setB_id(Integer.parseInt(data.getString(1)));
				temp.setL_id(Integer.parseInt(data.getString(2)));
				temp.setRr_id(Integer.parseInt(data.getString(3)));
				temp.setU_id(Integer.parseInt(data.getString(4)));
				temp.setStart_time(Timestamp.valueOf(data.getString(5)));
				temp.setEnd_time(Timestamp.valueOf(data.getString(6)));
				temp.setSpecialrequests(data.getString(7));
				temp.setPurpose(data.getString(8));	
			}
			return temp;
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured");
			e.printStackTrace();
			BookingModel temp = null;
			return temp;
		}
	}
	
	public boolean bookMeetingRoom(int bid,int lid,int rrid,int uid, String starttime,String endtime, String specialrequests, String purpose) throws SQLException
	{
		try
		{
			String insSt = "Insert into Booking values(?,?,?,?,?,?,?,?)";
			PreparedStatement stat = DB.getDBConnection().prepareStatement(insSt);
			stat.setInt(1, bid);
			stat.setInt(2, lid);
			stat.setInt(3, rrid);
			stat.setInt(4, uid);
			stat.setString(5, starttime);
			stat.setString(6, endtime);
			stat.setString(7, specialrequests);
			stat.setString(8, purpose);
			
			int res = stat.executeUpdate();
			if(res>0)
			{
				System.out.println("Booking inserted");
				return true;
			}
			else
			{
				System.out.println("Error inserting");
				return false;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception - Error inserting");
    		e.printStackTrace();
    		return false;
		}
	} 
	
	public boolean unbookMeetingRoom(int bid) throws SQLException
	{
		try
		{
			String delSt = "Delete from Booking where b_id = ?";
			PreparedStatement stat = DB.getDBConnection().prepareStatement(delSt);
			
			stat.setInt(1, bid);
			
			int res = stat.executeUpdate();
			if(res>0)
			{
				System.out.println("Delete success");
				return true;
			}
			else
			{
				System.out.println("Error deleting");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception - Error deleting");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean bookConferenceHall(int bid,int lid,int rrid,int uid, String starttime,String endtime, String specialrequests, String purpose) throws SQLException
	{
		try
		{
			String insSt = "Insert into booking values(?,?,?,?,?,?,?,?)";
			PreparedStatement stat = DB.getDBConnection().prepareStatement(insSt);
			
			stat.setInt(1, bid);
			stat.setInt(2, lid);
			stat.setInt(3, rrid);
			stat.setInt(4, uid);
			stat.setString(5, starttime);
			stat.setString(6, endtime);
			stat.setString(7, specialrequests);
			stat.setString(8, purpose);
			
			int ret = stat.executeUpdate();
			if(ret>0)
			{
				System.out.println("Insert successfully");
				return true;
			}
			else
			{
				System.out.println("Insert failed");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception - Error inserting");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean unbookConferenceHall(int bid) throws SQLException
	{
		try
		{
			String delSt = "Delete from Booking where b_id = ?";
			PreparedStatement stat = DB.getDBConnection().prepareStatement(delSt);
			
			stat.setInt(1, bid);
			
			int res = stat.executeUpdate();
			if(res>0)
			{
				System.out.println("Delete success");
				return true;
			}
			else
			{
				System.out.println("Error deleting");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception - Error deleting");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean bookEmployeeSeatingCubicle(int bid,int lid,int rrid,int uid, String starttime,String endtime, String specialrequests, String purpose) throws SQLException
	{
		try
		{
			String insSt = "Insert into Booking values(?,?,?,?,?,?,?,?)";
			PreparedStatement stat = DB.getDBConnection().prepareStatement(insSt);
			stat.setInt(1, bid);
			stat.setInt(2, lid);
			stat.setInt(3, rrid);
			stat.setInt(4, uid);
			stat.setString(5, starttime);
			stat.setString(6, endtime);
			stat.setString(7, specialrequests);
			stat.setString(8, purpose);
			
			int res = stat.executeUpdate();
			if(res>0)
			{
				System.out.println("Booking inserted");
				return true;
			}
			else
			{
				System.out.println("Error inserting");
				return false;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception - Error inserting");
    		e.printStackTrace();
    		return false;
		}
	}
	
	public boolean unbookEmployeeSeatingCubible(int bid) throws SQLException
	{
		try
		{
			String delSt = "Delete from Booking where b_id = ?";
			PreparedStatement stat = DB.getDBConnection().prepareStatement(delSt);
			
			stat.setInt(1, bid);
			
			int res = stat.executeUpdate();
			if(res>0)
			{
				System.out.println("Delete success");
				return true;
			}
			else
			{
				System.out.println("Error deleting");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception - Error deleting");
			e.printStackTrace();
			return false;
		}
	}
}
