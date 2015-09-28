package srm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import srm.dao.LocationDAO;
import srm.model.LocationModel;

/**
 * Servlet implementation class InsertResource
 */
@WebServlet("/InsertResource")
public class InsertResource extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("l_id"));
		request.setAttribute("l_id", id);
		
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("/WEB-INF/views/insert_resource.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

}
