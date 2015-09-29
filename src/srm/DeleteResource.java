package srm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import srm.dao.RegisteredResourceDAO;
import srm.model.RegisteredResource;

/**
 * Servlet implementation class DeleteResource
 */
@WebServlet("/DeleteResource")
public class DeleteResource extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{

		HttpSession session = request.getSession();
		
		Object obj = request.getParameter("rr_id");
		if (obj != null) {
			session.setAttribute("rr_id", Integer.parseInt(obj.toString()));
			// Generate resource values for fields in JSP
			RegisteredResourceDAO dao = new RegisteredResourceDAO();
			RegisteredResource rr = dao.viewResource(Integer.parseInt(obj.toString()));
			request.setAttribute("rr_name", rr.getRr_name());
			request.setAttribute("capacity", rr.getCapacity());
			request.setAttribute("special_features", rr.getSpecial_features());
		}
		
		// Add name for displaying in JSP
		RegisteredResourceDAO dao = new RegisteredResourceDAO();
		try {
			
			int l_id = (int) session.getAttribute("l_id");
			ArrayList<RegisteredResource> rr = dao.viewResourceByLocationId(l_id);
			request.setAttribute("resources", rr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/views/delete_resource.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		RequestDispatcher rd=null;
		HttpSession session = request.getSession();
		int rr_id = (int) session.getAttribute("rr_id");
		RegisteredResourceDAO dao = new RegisteredResourceDAO();
		try {
			
			dao.deleteRegisteredResource(rr_id);
			request.setAttribute("message", "Resource deleted.");
		} catch (SQLException e) {
			request.setAttribute("error", "There was a problem deleting resource.");
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/ResourceSummary");
	}
}
