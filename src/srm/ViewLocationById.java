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
import srm.model.LocationModel;

/**
 * Servlet implementation class ViewLocationById
 */
@WebServlet("/ViewLocationById")
public class ViewLocationById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewLocationById() {
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
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/views/location_viewbyid.jsp");
		rd.include(req, res);
	}
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession s=req.getSession(true);//true creates new session, even if it exists
		//blank: if session exists, open it, and if it doesn't, create new one
		int id=Integer.parseInt(req.getParameter("l_id"));
		
		try
		{
			LocationDAO d=new LocationDAO();
			LocationModel lm=d.viewLocationById(id);
		}
		catch (SQLException sq)
		{
			req.setAttribute("error", "something went wrong");
			RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/views/location.jsp");
			System.out.println("Error viewing");
		}
		res.sendRedirect(req.getContextPath()+"/LocationSummary");
		
		
		System.out.println("service");
	}

}
