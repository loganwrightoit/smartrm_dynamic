package srm.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import srm.dao.BookingDAO;
import srm.model.BookingModel;
import srm.model.LocationModel;

public class TestBookingDAO {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testShowAll() throws SQLException{
		BookingDAO b=new BookingDAO();
		assertFalse(b.showAll()==null);
		fail("Not yet implemented");
	}

	@Test
	public void testViewBooking() throws SQLException {
		BookingDAO b=new BookingDAO();
		BookingModel l=b.viewBooking();
		assertFalse(l==null);
		fail("Not yet implemented");
	}

	@Test
	public void testBookMeetingRoom() throws SQLException {
		BookingDAO b=new BookingDAO();
		boolean works=b.bookMeetingRoom(1, 1, 1, 1, "8:00 PM", "9:00 PM", "nothing", "no real reason");
		assertEquals(works, true);
		fail("Not yet implemented");
	}

	@Test
	public void testUnbookMeetingRoom() throws SQLException {
		BookingDAO b=new BookingDAO();
		assertEquals(b.unbookMeetingRoom(1), true);
		fail("Not yet implemented");
	}

	@Test
	public void testBookConferenceHall() throws SQLException {
		BookingDAO b=new BookingDAO();
		boolean works=b.bookConferenceHall(2, 1, 1, 1, "8:00 PM", "9:00 PM", "nothing", "no real reason");
		assertEquals(works, true);
	}

	@Test
	public void testUnbookConferenceHall() throws SQLException {
		BookingDAO b=new BookingDAO();
		assertEquals(b.unbookConferenceHall(1), true);
		fail("Not yet implemented");
	}

	@Test
	public void testBookEmployeeSeatingCubicle() throws SQLException {
		BookingDAO b=new BookingDAO();
		boolean works=b.bookEmployeeSeatingCubicle(3, 1, 1, 1, "8:00 PM", "9:00 PM", "nothing", "no real reason");
		assertEquals(works, true);
	}

	@Test
	public void testUnbookEmployeeSeatingCubible() throws SQLException {
		BookingDAO b=new BookingDAO();
		assertEquals(b.unbookEmployeeSeatingCubible(1), true);
		fail("Not yet implemented");
	}

}
