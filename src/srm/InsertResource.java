package srm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import srm.dao.LocationDAO;
import srm.dao.LocationResourceDAO;
import srm.dao.RegisteredResourceDAO;
import srm.model.LocationModel;
import srm.model.LocationResource;

/**
 * Servlet implementation class InsertResource
 */
@WebServlet("/InsertResource")
public class InsertResource extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("l_id");
		
		// Add name for displaying in JSP
		LocationDAO dao = new LocationDAO();
		LocationModel lm = null;
		try {
			lm = dao.viewLocationById(id);
			request.setAttribute("l_name", lm.getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		request.getRequestDispatcher("/WEB-INF/views/insert_resource.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		int l_id = (int) session.getAttribute("l_id");
		String r_type = request.getParameter("type");
		
		// Grab resource id
		LocationResourceDAO lr_dao = new LocationResourceDAO();
		LocationResource lr = lr_dao.readLocationResource(r_type);		
		
		// Save resource to database
		RegisteredResourceDAO dao = new RegisteredResourceDAO();
		String name = request.getParameter("name");
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		String special_features = request.getParameter("special_features");
		try {
			dao.insertRegisteredResource(name, l_id, lr.getR_id(), special_features, capacity);
			request.setAttribute("message", "Resource Successfully Added");
			response.sendRedirect(request.getContextPath() + "/ResourceSummary");
		} catch (SQLException e) {
			request.setAttribute("error", "Encountered error while adding resource.");
			doGet(request, response);
			e.printStackTrace();
		}
	}

}
