package srm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import srm.dao.UserDAO;
import srm.model.UserModel;

@WebServlet("/Login")
public class Login extends HttpServlet {

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
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
		
		// Grab credentials from database
		UserDAO dao = new UserDAO();
		UserModel user = dao.readUserData(u_name);
		if (user != null && user.getU_pass().equals(u_pass)) {
			// Continue to main
			session.setAttribute("logged_in", true);
			session.setAttribute("u_name", u_name);
			session.setAttribute("u_level", user.getU_level());
			session.setAttribute("u_id",user.getU_id());
			response.sendRedirect(request.getContextPath() + "/Main");
			return;
		}
	
		request.setAttribute("message", "Login failed, please try again.");
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

}
