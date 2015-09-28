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

@WebServlet("/ResourceSummary")
public class ResourceSummary extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		LocationDAO dao = new LocationDAO();
		int l_id = Integer.parseInt(request.getAttribute("l_id").toString());
		String name = request.getParameter("name");
		int capacity = Integer.parseInt(request.getParameter("capacity").toString());
		String special_features = request.getParameter("special_features");
		
		try {
			LocationModel lm = dao.viewLocationById(l_id);
			request.setAttribute("l_id", l_id);
			
			// Add resources for location using DAO object
			
		} catch (Exception e1) {
			request.setAttribute("error", "There was a problem accessing the database, please report this to the web administrator.");
		}
				
		request.getRequestDispatcher("/WEB-INF/views/resource_summary.jsp").forward(request, response);
	}

}
