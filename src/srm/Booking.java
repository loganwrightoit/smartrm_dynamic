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
		// load first the location drop down
		HttpSession s = request.getSession(true);
		
		
		//scenario-based
		// there is no parameters sent, then just send the whole page first with location combobox loaded
		if(request.getParameter("blocation") == null && request.getParameter("bresource") == null && request.getParameter("book") == null)
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
				request.getRequestDispatcher("/WEB-INF/views/booking.jsp").forward(request, response);
				return;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// user selected a location
		else if(request.getParameter("blocation") != null && request.getParameter("bresource").equals("noresource") && request.getParameter("book") == null)
		{
			// load again the location dd with the selected loc, and load the resource dd with that loc's resources
			LocationDAO d = new LocationDAO();
			ArrayList<LocationModel> lm;
			
			RegisteredResourceDAO d2 = new RegisteredResourceDAO();
			ArrayList<RegisteredResource> rrmodellist;
			
			try {
				lm = d.viewLocation();
				ArrayList<String> lmname = new ArrayList<String>();
		
				for(LocationModel tmp : lm)
			    {
			    	lmname.add(tmp.getName());
			    }
				request.setAttribute("locations", lmname);
				
				
				System.out.println(request.getParameter("blocation"));
				s.setAttribute("pickedlocation", request.getParameter("blocation"));
				
				
				// get locationid using location name
				LocationDAO ldao = new LocationDAO();
				int selectedlocationname =  ldao.viewLocationByName(request.getParameter("blocation")).getId();
				

				rrmodellist = d2.viewResourceByLocationId(selectedlocationname);
				ArrayList<String> rrname = new ArrayList<String>();
				
				for(RegisteredResource tmp : rrmodellist)
				{
					rrname.add(tmp.getRr_name());
				}
				request.setAttribute("resources", rrname);
				
				///
				request.getRequestDispatcher("/WEB-INF/views/booking.jsp").forward(request, response);
				int x = 0;
				x++;
				int y =x;
				
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
		}
		// user selects a resource
		else if(request.getParameter("blocation") != null && !request.getParameter("bresource").equals("noresource") && request.getParameter("book") == null)
		{
			System.out.println("3rd case entered");
			LocationDAO d = new LocationDAO();
			ArrayList<LocationModel> lm;
			
			RegisteredResourceDAO d2 = new RegisteredResourceDAO();
			ArrayList<RegisteredResource> rrmodellist;
			
			try {
				lm = d.viewLocation();
				ArrayList<String> lmname = new ArrayList<String>();
		
				for(LocationModel tmp : lm)
			    {
			    	lmname.add(tmp.getName());
			    }
				request.setAttribute("locations", lmname);
				
				
				System.out.println(request.getParameter("blocation"));
				//s.setAttribute("pickedlocation", request.getParameter("blocation"));
				
				
				// get locationid using location name
				LocationDAO ldao = new LocationDAO();
				int selectedlocationname =  ldao.viewLocationByName(request.getParameter("blocation")).getId();
				

				rrmodellist = d2.viewResourceByLocationId(selectedlocationname);
				ArrayList<String> rrname = new ArrayList<String>();
				
				for(RegisteredResource tmp : rrmodellist)
				{
					rrname.add(tmp.getRr_name());
				}
				request.setAttribute("resources", rrname);
				s.setAttribute("pickedresource", request.getParameter("bresource"));
				///
				request.getRequestDispatcher("/WEB-INF/views/booking.jsp").forward(request, response);
				int x = 0;
				x++;
				int y =x;
				
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
		}
		// now for submitting the booking button
		else if(request.getParameter("blocation") != null && request.getParameter("bresource") != null && request.getParameter("book") != null)
		{
			System.out.println("case 4 entered");
			String loc = request.getParameter("blocation");
			String res = request.getParameter("bresource");
			
			String mode = request.getParameter("book");
			
			System.out.println(loc);
			System.out.println(res);
			System.out.println(mode);
			
			
			PrintWriter pw = response.getWriter();			
			
			// now determine the resource type using the resource name selected
			
			RegisteredResourceDAO rrd = new RegisteredResourceDAO();
			RegisteredResource rr = null;
			try {
				rr = rrd.viewRegisteredResourceByName(res);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String resID = Integer.toString(rr.getR_id());
			
			// 1 - mr
			// 2 - ch
			// 3 - esc
			
			if(!loc.equals("nolocation") && resID.equals("1"))
			{

				if(mode.equals("New Booking"))
				{	// store pickedlocation in session
					//request.setAttribute("pickedlocation", loc);
					response.sendRedirect("BookMeetingRoom");
					//request.getRequestDispatcher("WEB-INF/views/mr_booking_add.jsp").include(request, response);
				}
				else if(mode.equals("Delete Booking"))
				{
					response.sendRedirect("UnbookMeetingRoom");
				}
			}
			else if(!loc.equals("nolocation") && res.equals("2"))
			{

				request.setAttribute("location", loc);
				if(mode.equals("New Booking"))
				{
					response.sendRedirect("BookConferenceHall");
				}
				else if(mode.equals("Delete Booking"))
				{
					response.sendRedirect("UnbookConferenceHall");
					
				}
			}
			
			else if(!loc.equals("nolocation") && res.equals("3"))
			{

				request.setAttribute("location", loc);
				if(mode.equals("New Booking"))
				{
					response.sendRedirect("BookEmployeeSeatingCubicle");
				}
				else if(mode.equals("Delete Booking"))
				{
					response.sendRedirect("UnbookEmployeeSeatingCubicle");
				}
			}
			return;
		}
		
		
		
		/*
		
		// check if the user has not selected a location in dropdown / first time
		//if(s.getAttribute("location") == null)
		if(request.getParameter("blocation") == null)
		{	
			// then just load the location dropdown
					
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
				return;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// check if the get is activated by location dropdown
		if(request.getParameter("blocation") != null)
		{
			// this means the user has selected a location dropdown, save that in session
			
			LocationDAO d = new LocationDAO();
			ArrayList<LocationModel> lm;
			
			RegisteredResourceDAO d2 = new RegisteredResourceDAO();
			ArrayList<RegisteredResource> rrmodellist;
			
			try {
				lm = d.viewLocation();
				ArrayList<String> lmname = new ArrayList<String>();
		
				for(LocationModel tmp : lm)
			    {
			    	lmname.add(tmp.getName());
			    }
				request.setAttribute("locations", lmname);
				
				
				System.out.println(request.getParameter("blocation"));
				s.setAttribute("pickedlocation", request.getParameter("blocation"));
				
				
				// get locationid using location name
				LocationDAO ldao = new LocationDAO();
				int selectedlocationname =  ldao.viewLocationByName(request.getParameter("blocation")).getId();
				

				rrmodellist = d2.viewResourceByLocationId(selectedlocationname);
				ArrayList<String> rrname = new ArrayList<String>();
				
				for(RegisteredResource tmp : rrmodellist)
				{
					rrname.add(tmp.getRr_name());
				}
				request.setAttribute("resources", rrname);
				
				///
				request.getRequestDispatcher("/WEB-INF/views/booking.jsp").forward(request, response);
				int x = 0;
				x++;
				int y =x;
				
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			
		}
		// this means the form is submitted with resource selected, get the location info session saved in the database to load the location dropdown
		if(request.getParameter("bresource") != null)
		{
			LocationDAO d = new LocationDAO();
			ArrayList<LocationModel> lm;
			
			RegisteredResourceDAO d2 = new RegisteredResourceDAO();
			ArrayList<RegisteredResource> rrmodellist;
			
			try {
				lm = d.viewLocation();
				ArrayList<String> lmname = new ArrayList<String>();
		
				for(LocationModel tmp : lm)
			    {
			    	lmname.add(tmp.getName());
			    }
				request.setAttribute("locations", lmname);
				
				
				System.out.println(request.getParameter("blocation"));
				s.setAttribute("pickedresource", request.getParameter("bresource"));
				
				
				// get locationid using location name
				LocationDAO ldao = new LocationDAO();
				int selectedlocationname =  ldao.viewLocationByName(request.getParameter("blocation")).getId();
				

				rrmodellist = d2.viewResourceByLocationId(selectedlocationname);
				ArrayList<String> rrname = new ArrayList<String>();
				
				for(RegisteredResource tmp : rrmodellist)
				{
					rrname.add(tmp.getRr_name());
				}
				request.setAttribute("resources", rrname);
				
				///
				request.getRequestDispatcher("/WEB-INF/views/booking.jsp").forward(request, response);
				int x = 0;
				x++;
				int y =x;
				
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		*/
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
			

			RegisteredResourceDAO d2 = new RegisteredResourceDAO();
			ArrayList<RegisteredResource> rrmodellist;
			
			try {
				lm = d.viewLocation();
				ArrayList<String> lmname = new ArrayList<String>();
				
				for(LocationModel tmp : lm)
			    {
			    	lmname.add(tmp.getName());
			    }
				request.setAttribute("locations", lmname);
				request.setAttribute("error", "Please select a location/resource");
				
				rrmodellist = d2.viewLocation();
				ArrayList<String> rrname = new ArrayList<String>();
				
				for(RegisteredResource tmp : rrmodellist)
				{
					rrname.add(tmp.getRr_name());
				}
				request.setAttribute("resources", rrname);
				
				
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
