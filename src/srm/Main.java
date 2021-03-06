package srm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Main")
public class Main extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Check if user logged in
		HttpSession session = request.getSession(true);
		Object obj = session.getAttribute("logged_in");
		if (obj != null && !Boolean.parseBoolean(obj.toString()) || obj == null)
		{
			response.sendRedirect(request.getContextPath() + "/Login");
		} else {
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		}
	}

}
