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

@WebServlet("/Resource")
public class Resource extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Populate locations dropdown
		LocationDAO dao = new LocationDAO();
		try {
			ArrayList<LocationModel> list = dao.viewLocation();
			request.setAttribute("locations", list);
		} catch (SQLException e) {
			request.setAttribute("error", "Unable to connect to database");
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/views/resource.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String task = request.getParameter("task").toString();
		int l_id = Integer.parseInt(request.getParameter("l_id"));
		
		// Save location ID in session for later use
		HttpSession session = request.getSession();
		session.setAttribute("l_id", l_id);

		if ("add_resource".equals(task)) {
			response.sendRedirect(request.getContextPath() + "/InsertResource");
			return;
		} else if ("update_resource".equals(task)) {
			response.sendRedirect(request.getContextPath() + "/UpdateResource");
			return;
		} else if ("delete_resource".equals(task)) {
			response.sendRedirect(request.getContextPath() + "/DeleteResource");
			return;
		} else {
			request.setAttribute("error", "A task must be selected");
			doGet(request, response);
		}
	}

}
