package srm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import srm.dao.LocationDAO;
import srm.model.LocationModel;

@WebServlet("/LocationSummary")
public class LocationSummary extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LocationDAO dao = new LocationDAO();
		
		try {
			ArrayList<LocationModel> locations = dao.viewLocation();
			
			if (locations.isEmpty()) {
				request.setAttribute("message", "There are no locations in the database");
			} else {
				request.setAttribute("locations", locations);
			}
			
			request.getRequestDispatcher("/WEB-INF/views/location_summary.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("error", "There was a problem accessing the database, please report this to the web administrator.");
		}
	}

}
