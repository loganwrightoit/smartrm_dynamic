package srm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import srm.dao.LocationDAO;

/**
 * Servlet implementation class DeleteLocation
 */
@WebServlet("/DeleteLocation")
public class DeleteLocation extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteLocation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{

		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/views/location_delete.jsp");
		rd.include(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		RequestDispatcher rd=null;
		try
		{
			HttpSession s=req.getSession(true);//true creates new session, even if it exists
			//blank: if session exists, open it, and if it doesn't, create new one
			int id=Integer.parseInt(req.getParameter("l_id"));
			String name=req.getParameter("l_name");
			LocationDAO d=new LocationDAO();
			boolean works=d.deleteLocation(id);
			res.sendRedirect(req.getContextPath()+"/LocationSummary");
		}
		catch (SQLException e)
		{
			req.setAttribute("error", "This entry can't be deleted, because another table depends on it.");
			rd=req.getRequestDispatcher("/WEB-INF/views/location_delete.jsp");
			rd.include(req, res);
		}
	}

}
