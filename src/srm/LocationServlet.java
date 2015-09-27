package srm;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/LocationServlet")
public class LocationServlet extends HttpServlet {
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
		
		HttpSession s=req.getSession(true);//true creates new session, even if it exists
		//blank: if session exists, open it, and if it doesn't, create new one
		int id=Integer.parseInt(req.getParameter("id"));
		String locName=req.getParameter("name");//get  the parameter equal to the name in the input box in the html file
		String locDesc=req.getParameter("description");
		String locPhone=req.getParameter("phone");
		String locHead=req.getParameter("head");
		String locCity=req.getParameter("city");
		String locCountry=req.getParameter("country");
		int locTimezone=Integer.parseInt(req.getParameter("timezone"));
		LocationDAO d=new LocationDAO();
		boolean works=d.insertLocation(id, locName, locDesc, locPhone, locHead, locCity, locCountry, locTimezone);
		PrintWriter p=res.getWriter();
		
		p.println(works +"\n");
		p.println(locName+"\n");
		p.println(locDesc+"\n");
		p.println(locPhone+"\n");
		p.println(locHead+"\n");
		p.println(locCity+"\n");
		p.println(locCountry+"\n");
		p.println(locTimezone+"\n");
		
		
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/ReportServlet");
		
		rd.include(req, res);
		
		System.out.println("service");
	}
	

}
