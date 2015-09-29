package srm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import srm.model.LocationResource;

public class LocationResourceDAO {
	
	/**
	 * Reads location resource given a resource type.
	 * 
	 * @param r_type the resource type id
	 * @return a matching {@link LocationResource} object, or <code>null</code> if no record found
	 */
	public LocationResource readLocationResource(String r_type)
	{
		String query = "SELECT * FROM locationresource WHERE r_type = ?";
		
    	try {
    		Connection cxn = DB.getDBConnection(); 
	        PreparedStatement pstat = cxn.prepareStatement(query);
	        pstat.setString(1, r_type);
    		ResultSet rset = pstat.executeQuery();

    		// Test for empty set
    		if (!rset.isBeforeFirst()) {
    			return null;
    		} else {
    			rset.next();
    			return new LocationResource(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4));
    		}

        } catch (Exception e) {
        	e.printStackTrace();
        }
		
		return null;
	}
	
}
