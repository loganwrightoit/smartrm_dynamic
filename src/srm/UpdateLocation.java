package srm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import srm.dao.LocationDAO;
import srm.model.LocationModel;

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
		LocationDAO dao = new LocationDAO();
		try {

				ArrayList<LocationModel> list = dao.viewLocation();
				req.setAttribute("locations", list);
				if (req.getParameter("l_id")!=null)
				{
					LocationModel thisLoc=dao.viewLocationById(Integer.parseInt(req.getParameter("l_id")));
					System.out.println(thisLoc.getName());
					req.setAttribute("l_id", thisLoc.getId());
					req.setAttribute("l_name", thisLoc.getName());
					req.setAttribute("l_desc", thisLoc.getDescription());
					req.setAttribute("l_phone", thisLoc.getPhone());
					req.setAttribute("l_head", thisLoc.getHead());
					req.setAttribute("l_city", thisLoc.getCity());
					req.setAttribute("l_country", thisLoc.getCountry());
			}
		} catch (SQLException e) {
			req.setAttribute("error", "Unable to connect to database");
			e.printStackTrace();
		}

		req.getRequestDispatcher("/WEB-INF/views/location_update.jsp").forward(req, res);
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
