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
 * Servlet implementation class UpdateLocation
 */
@WebServlet("/UpdateLocation")
public class UpdateLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLocation() {
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
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/views/location_update.jsp");
		rd.include(req, res);
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd=null;
		try
		{
			HttpSession s=req.getSession(true);//true creates new session, even if it exists
			//blank: if session exists, open it, and if it doesn't, create new one
			int id=Integer.parseInt(req.getParameter("l_id"));
			String locPhone=req.getParameter("l_phone");
			String locHead=req.getParameter("l_head");
			String locCity=req.getParameter("l_city");
			String locCountry=req.getParameter("l_country");
			double locTimezone=Double.parseDouble(req.getParameter("l_timezone"));
			LocationDAO d=new LocationDAO();
			boolean works=d.updateLocationDetails(id, locPhone, locHead, locCity, locCountry, locTimezone);
		
			res.sendRedirect(req.getContextPath()+"/LocationSummary");
		}
		
	
	catch (SQLException e)
	{
		req.setAttribute("error", "Something went wrong");
		rd=req.getRequestDispatcher("/WEB-INF/views/location_update.jsp");
		rd.include(req, res);
	}
	}

}
