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

import srm.dao.RegisteredResourceDAO;
import srm.model.RegisteredResource;

@WebServlet("/UpdateResource")
public class UpdateResource extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Object obj = request.getParameter("rr_id");
		if (obj != null) {
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
			HttpSession session = request.getSession();
			int l_id = (int) session.getAttribute("l_id");
			ArrayList<RegisteredResource> rr = dao.viewResourceByLocationId(l_id);
			request.setAttribute("resources", rr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/views/update_resource.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

}
