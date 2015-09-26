package srm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("Called doGet for Login");
		
		request.getRequestDispatcher("/WEB-INF/login.jsp").include(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(true);
		
		// Verify username and password
		String u_name = request.getParameter("u_name");
		String u_pass = request.getParameter("u_pass");
		
		// NOTE: Need business logic hook to verify with database
		if ("Logan".equals(u_name) && "123".equals(u_pass)) {
			System.out.println("Admin logged in.");
		} else if ("John".equals(u_name) && "123".equals(u_pass)) {
			System.out.println("User logged in.");
		} else {
			request.setAttribute("message", "Login failed");
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	        return;
		}
		
		session.setAttribute("logged_in", true);
		session.setAttribute("u_name", u_name);

		// Redirect to main page
		response.sendRedirect(request.getContextPath() + "/Main");
		//request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

}
