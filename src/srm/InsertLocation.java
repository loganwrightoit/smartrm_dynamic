package srm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import srm.dao.LocationDAO;

/**
 * Servlet implementation class LocationServlet
 */
@WebServlet("/InsertLocation")
public class InsertLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	public void init()
	{
		System.out.println("-----------init");
	}
	
	public void destroy()
	{	
		System.out.println("destroy");
	}
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		RequestDispatcher rd=null;
		try
		{
			HttpSession s=req.getSession(true);//true creates new session, even if it exists
			//blank: if session exists, open it, and if it doesn't, create new one
			String locName=req.getParameter("l_name");//get  the parameter equal to the name in the input box in the html file
			String locDesc=req.getParameter("l_desc");
			String locPhone=req.getParameter("l_phone");
			String locHead=req.getParameter("l_head");
			String locCity=req.getParameter("l_city");
			String locCountry=req.getParameter("l_country");
			int locTimezone=Integer.parseInt(req.getParameter("l_timezone"));
			LocationDAO d=new LocationDAO();
			boolean works=d.insertLocation(locName, locDesc, locPhone, locHead, locCity, locCountry, locTimezone);
			rd=req.getRequestDispatcher("/views/testinsert.jsp");
		}
		catch (SQLException e)
		{
			rd=req.getRequestDispatcher("/views/error.jsp");
		}
		finally
		{
		
			rd.include(req, res);
		
			System.out.println("service");
		}
		
	}
	

}
