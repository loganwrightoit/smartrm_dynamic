package srm;

import java.io.IOException;
import java.util.ArrayList;

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

@WebServlet("/ResourceSummary")
public class ResourceSummary extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		int l_id = (int) session.getAttribute("l_id");
		
		try {
			request.setAttribute("l_id", l_id); // This is lost during redirect			
			RegisteredResourceDAO rr_dao = new RegisteredResourceDAO();
			ArrayList<RegisteredResource> resources = rr_dao.viewResourceByLocationId(l_id);
			request.setAttribute("resources", resources);
			
		} catch (Exception e1) {
			request.setAttribute("error", "There was a problem accessing the database, please report this to the web administrator.");
		}
				
		request.getRequestDispatcher("/WEB-INF/views/resource_summary.jsp").forward(request, response);
	}

}
