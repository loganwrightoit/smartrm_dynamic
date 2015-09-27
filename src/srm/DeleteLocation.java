package srm;

import java.io.IOException;

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
public class DeleteLocation extends HttpServlet {
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
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession s=req.getSession(true);//true creates new session, even if it exists
		//blank: if session exists, open it, and if it doesn't, create new one
		int id=Integer.parseInt(req.getParameter("l_id"));
		LocationDAO d=new LocationDAO();
		boolean works=d.deleteLocation(id);
		
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/views/report.jsp");
		
		rd.include(req, res);
		
		System.out.println("service");
	}

}
