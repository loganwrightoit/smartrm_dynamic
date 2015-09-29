package srm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import srm.dao.BookingDAO;
import srm.dao.LocationDAO;
import srm.dao.RegisteredResourceDAO;
import srm.model.RegisteredResource;


@WebServlet("/BookMeetingRoom")
public class BookMeetingRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookMeetingRoom() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pickedattribute", request.getSession().getAttribute("pickedattribute"));
		request.getRequestDispatcher("WEB-INF/views/mr_booking_add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* to book meeting room, we require to insert the following record into the booking table
		 * 
		 *  // fetch from db the l_id from location table
		 *  // fetch from db the r_id from locationresource table
		 *  // create entry into registeredresource  table 
		 *  	we get rr_name from the form n 
		 *  	we get special_features from the form
		 *  	we get capacity from the form
		 *  
		 *  // now, get the id of newly entered registeredresource table and use that to enter in booking table
		 *  	whose values are below
		 * 
		 * b_id number primary key,
	l_id number not null,
	rr_id number not null,
	u_id number not null,
	start_time timestamp not null,
	end_time timestamp not null,
	special_requests varchar(1000),
	purpose varchar(1000),
	constraint fklocationid foreign key (l_id) references location(l_id),
	constraint fkrrid foreign key (rr_id) references registeredresource(rr_id),
	constraint fkuid foreign key (u_id) references userdata(u_id));
	
		 */
		
		HttpSession s = request.getSession();
		String locationname;
		String resourcename;
		LocationDAO ldao = new LocationDAO();	
		RegisteredResourceDAO rdao = new RegisteredResourceDAO();
		BookingDAO bdao = new BookingDAO();
		int l_id;
		int r_id;
		int u_id;
		
		locationname = s.getAttribute("pickedlocation").toString(); // location name
		//resourcename = s.getAttribute("pickedresource").toString(); // registeredresource name
		r_id = Integer.parseInt(s.getAttribute("r_id").toString()); // locationresource id
		u_id = Integer.parseInt(s.getAttribute("u_id").toString());
		
		String rName = request.getParameter("roomname");
		int cap = Integer.parseInt(request.getParameter("capacity").toString());
		String specFeatures = request.getParameter("specialfeatures").toString();
		String specialrequests = request.getParameter("specialrequests").toString();
		String purpose = request.getParameter("purpose").toString();
		String starttime = request.getParameter("starttime").toString();
		String endtime = request.getParameter("endtime").toString();
		boolean status = false;
		
		try {
			l_id = ldao.viewLocationByName(locationname).getId();
			// create entry into registeredresource table
			rdao.insertRegisteredResource(rName, l_id, r_id, specFeatures, cap);
			int rr_id = rdao.getSequenceNumber();
			// create entry into booking table
			status = bdao.bookMeetingRoom(l_id, rr_id, u_id, starttime, endtime, specialrequests, purpose);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(status)
		{
			PrintWriter pw = response.getWriter();
			pw.print("Book Inserted!");
			
		}
	}

}
