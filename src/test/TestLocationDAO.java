package test;


import org.junit.*;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import srm.dao.LocationDAO;
import srm.model.LocationModel;

public class TestLocationDAO {

	@Before
	public void setUp() throws Exception 
	{
		
	}

	@After
	public void tearDown() throws Exception 
	{
		
	}

	@Test
	public void testViewAll() throws SQLException {
		LocationDAO d=new LocationDAO();
		ArrayList<LocationModel> locations=d.viewLocation();
		assertFalse(locations==null);
	}
	@Test
	public void testViewById() throws SQLException {
		LocationDAO d=new LocationDAO();
		LocationModel locations=d.viewLocationById(1);
		assertFalse(locations==null);
	}
	@Test
	public void testDelete() throws SQLException {
		LocationDAO d=new LocationDAO();
		boolean isWorking=d.deleteLocation(5);
		assertEquals(isWorking, true);
	}
	@Test
	public void testUpdateLocationHead() throws SQLException 
	{
		LocationDAO d=new LocationDAO();
		boolean isWorking=d.updateLocationHead(3, "Adam");
		assertEquals(isWorking, true);
	}
	
	@Test
	public void testUpdateLocationPhone() throws SQLException 
	{
		LocationDAO d=new LocationDAO();
		boolean isWorking=d.updateLocationPhone(2, "4523334454");
		assertEquals(isWorking, true);
	}	
	
	@Test
	public void testUpdateLocationPlace() throws SQLException 
	{
		LocationDAO d=new LocationDAO();
		boolean isWorking=d.updateLocationPlace(1, "Bells", "TN", 6);
		assertEquals(isWorking, true);
	}	
	


	

	
	
	public void testInsert()
	{
		LocationDAO d=new LocationDAO();
		boolean isWorking=d.insertLocation("Testloc", "Test", "7777777", "Thomas", "Memphis", "US", 10);
		assertEquals(isWorking, true);
	}
	
	

}
