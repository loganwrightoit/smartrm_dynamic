package srm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import srm.model.UserModel;

public class UserDAO
{

	//	CREATE TABLE userdata
	//	(
	//		u_id number primary key,
	//		u_name varchar(10) not null,
	//		u_pass varchar(10) not null,
	//		u_level varchar(10) not null
	//	);
	
	/**
	 * Creates a new user in database.
	 * 
	 * @param u_id the user id
	 * @param u_name the user name
	 * @param u_pass the user password
	 * @param u_level the user access level
	 * @return <code>true</code> if creation successful
	 */
	public boolean createUserData(int u_id, String u_name, String u_pass, String u_level)
	{
        String str = "INSERT INTO userdata VALUES (?, ?, ?, ?)";

        try {
        	Connection cxn = DB.getDBConnection();        	
	        PreparedStatement pstat = cxn.prepareStatement(str);
	        pstat.setInt(1, u_id);
	        pstat.setString(2, u_name);
	        pstat.setString(3, u_pass);
	        pstat.setString(4, u_level);
    		int result = pstat.executeUpdate();
    		if (result > 0) {
    			return true;
    		}
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
		return false;
	}
	
	/**
	 * Reads all user data from database.
	 * 
	 * @return an {@link ArrayList<UserModel>} containing all users
	 */
	public ArrayList<UserModel> readAllUserData()
	{
		ArrayList<UserModel> list = new ArrayList<UserModel>();
		String str = "SELECT * FROM userdata";
		
    	try {
    		Connection cxn = DB.getDBConnection(); 
	        Statement stat = cxn.createStatement();
    		ResultSet rset = stat.executeQuery(str);
    		
    		// Populate user list
    		while (rset.next()) {
    			UserModel user = new UserModel(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4));
    			list.add(user);
    		}
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
		return list;
	}
	
	/**
	 * Reads user data from database.
	 * 
	 * @param u_id the user id
	 * @return a matching {@link UserModel} object, or <code>null</code> if no record found
	 */
	public UserModel readUserData(int u_id)
	{
		String query = "SELECT * FROM userdata WHERE u_id = ?";
		
    	try {
    		Connection cxn = DB.getDBConnection(); 
	        PreparedStatement pstat = cxn.prepareStatement(query);
	        pstat.setInt(1, u_id);
    		ResultSet rset = pstat.executeQuery();

    		// Test for empty set
    		if (!rset.isBeforeFirst()) {
    			return null;
    		} else {
    			return new UserModel(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4));
    		}

        } catch (Exception e) {
        	e.printStackTrace();
        }
		
		return null;
	}
	
	/**
	 * Reads user data from database.
	 * 
	 * @param u_name the user name
	 * @return a matching {@link UserModel} object, or <code>null</code> if no record found
	 */
	public UserModel readUserData(String u_name)
	{
		String query = "SELECT * FROM userdata WHERE u_name = ?";
		
    	try {
    		Connection cxn = DB.getDBConnection(); 
	        PreparedStatement pstat = cxn.prepareStatement(query);
	        pstat.setString(1, u_name);
    		ResultSet rset = pstat.executeQuery();

    		// Test for empty set
    		if (!rset.isBeforeFirst()) {
    			return null;
    		} else {
    			rset.next();
    			return new UserModel(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4));
    		}

        } catch (Exception e) {
        	e.printStackTrace();
        }
		
		return null;
	}
	
	/**
	 * Updates user data in database.
	 * 
	 * @param u_id the user id
	 * @param u_pass the user password
	 * @param u_level the user access level
	 * @return <code>true</code> if update was successful
	 */
	public boolean updateUserData(int u_id, String u_pass, String u_level)
	{
        String str = "UPDATE userdata SET u_pass = ?, u_level = ? WHERE u_id = ?";

        try {
        	Connection cxn = DB.getDBConnection();
	        PreparedStatement pstat = cxn.prepareStatement(str);
	        pstat.setString(1, u_pass);
	        pstat.setString(1, u_level);
	        pstat.setInt(1, u_id);
    		int result = pstat.executeUpdate();
    		if (result > 0) {
    			return true;
    		}
        } catch (Exception e) {
        	e.printStackTrace();
        }
		
		return false;
	}
	
	/**
	 * Deletes user data from database.
	 * 
	 * @param u_id the user id
	 * @return <code>true</code> if deletion was successful
	 */
	public boolean deleteUserData(int u_id)
	{
        String str = "DELETE FROM userdata WHERE u_id = ?";

        try {
        	Connection cxn = DB.getDBConnection();
	        PreparedStatement pstat = cxn.prepareStatement(str);
	        pstat.setInt(1, u_id);
    		int result = pstat.executeUpdate();
    		if (result > 0) {
    			return true;
    		}
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
		return false;
	}
	
}
