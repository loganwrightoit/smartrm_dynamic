package srm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import srm.dao.LocationDAO;
import srm.dao.RegisteredResourceDAO;
import srm.model.LocationModel;
import srm.model.RegisteredResource;


@WebServlet("/Booking")
public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Booking() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//added
		HttpSession session = request.getSession(true);
		Object obj = session.getAttribute("logged_in");
		if(obj != null && !Boolean.parseBoolean(obj.toString()) || obj == null)
		{
			response.sendRedirect("Logout");
		}
		else
		{
			//response.sendRedirect(request.getContextPath() +"/Login");
			// get the locations
			LocationDAO d = new LocationDAO();
			ArrayList<LocationModel> lm;
			try {
				lm = d.viewLocation();
				ArrayList<String> lmname = new ArrayList<String>();
		
				for(LocationModel tmp : lm)
			    {
			    	lmname.add(tmp.getName());
			    }
				request.setAttribute("locations", lmname);
				request.getRequestDispatcher("/WEB-INF/views/booking.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			RegisteredResourceDAO d2 = new RegisteredResourceDAO();
			ArrayList<RegisteredResource> rrmodellist;
			try
			{
				rrmodellist = d2.viewLocation();
				
			}
			catch(SQLException e)
			{
				
			}
			
			
			
			
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POSTING....3");
		String loc = request.getParameter("blocation");
		String res = request.getParameter("bresource");
		
		String mode1 = request.getParameter("nb");
		String mode2 = request.getParameter("db");
		
		PrintWriter pw = response.getWriter();			
		
		if(!loc.equals("nolocation") && res.equals("mr"))
		{

			if(mode1!=null)
			{	// store pickedlocation in session
				//request.setAttribute("pickedlocation", loc);
				request.getSession().setAttribute("pickedlocation", loc);
				response.sendRedirect("BookMeetingRoom");
				//request.getRequestDispatcher("WEB-INF/views/mr_booking_add.jsp").include(request, response);
			}
			else if(mode2!=null)
			{
				response.sendRedirect("UnbookMeetingRoom");
			}
			
			
			// call the next page
			//response.sendRedirect("http://msn.com");
		}
		else if(!loc.equals("nolocation") && res.equals("ch"))
		{

			request.setAttribute("location", loc);
			if(mode1!=null)
			{
				response.sendRedirect("BookConferenceHall");
			}
			else if(mode2!=null)
			{
				response.sendRedirect("UnbookConferenceHall");
			}
			
			
			// call the next page
			//response.sendRedirect("http://msn.com");
		}
		
		else if(!loc.equals("nolocation") && res.equals("esc"))
		{

			request.setAttribute("location", loc);
			if(mode1!=null)
			{
				response.sendRedirect("BookEmployeeSeatingCubicle");
			}
			else if(mode2!=null)
			{
				response.sendRedirect("UnbookEmployeeSeatingCubicle");
			}
			
			
			// call the next page
			//response.sendRedirect("http://msn.com");
		}
		
		
		
		else
		{
			
			LocationDAO d = new LocationDAO();
			ArrayList<LocationModel> lm;
			try {
				lm = d.viewLocation();
				ArrayList<String> lmname = new ArrayList<String>();
		
				for(LocationModel tmp : lm)
			    {
			    	lmname.add(tmp.getName());
			    }
				request.setAttribute("locations", lmname);
				request.setAttribute("error", "Please select a location/resource");
				request.getRequestDispatcher("/WEB-INF/views/booking.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//System.out.println(temp);	
		//response.sendRedirect("http://yahoo.com");
	}

}
