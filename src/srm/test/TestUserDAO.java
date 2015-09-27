package srm.test;

import static org.junit.Assert.*;

import java.sql.Statement;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import srm.dao.DB;
import srm.dao.UserDAO;
import srm.model.UserModel;

public class TestUserDAO {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	UserDAO d=new UserDAO();
	
	@Test
	public void testAddUser() {
		boolean isWorking=d.createUserData(7, "name", "java", "admin");
		assertEquals(isWorking, true);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testViewUser() {
		ArrayList<UserModel> users=d.readAllUserData();
		assertFalse(users==null);
		
	}
	
	@Test
	public void testViewUserById()
	{
		UserModel u=d.readUserData(1);
		assertFalse(u==null);
	}
	
	@Test
	public void testUpdateUser() {
		boolean isWorking=d.updateUserData(3, "pass2", "admin");
		assertEquals(isWorking, true);
		
	}
	@Test
	public void testDeleteUser() {
		boolean isWorking=d.deleteUserData(7);
		assertEquals(isWorking, true);
	}
	
}
