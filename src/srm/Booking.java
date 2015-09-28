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
import srm.model.LocationModel;


@WebServlet("/Booking")
public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Booking() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POSTING....3");
		String loc = request.getParameter("location");
		String res = request.getParameter("resource");
		PrintWriter pw = response.getWriter();			
		
		if(loc.equals("Memphis Technology") && res.equals("mr"))
		{

			request.setAttribute("location", loc);
			request.getRequestDispatcher("views/mr_booking_add.jsp").include(request, response);
			
			
			// call the next page
			//response.sendRedirect("http://msn.com");
		}
		else
		{
			pw.print("false");
		}
		//System.out.println(temp);	
		//response.sendRedirect("http://yahoo.com");
	}

}
