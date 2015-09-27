package srm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
			response.sendRedirect("/Logout");
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
				request.getRequestDispatcher("/views/booking.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
