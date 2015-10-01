package srm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import srm.dao.BookingDAO;


@WebServlet("/UnbookConferenceHall")
public class UnbookConferenceHall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UnbookConferenceHall() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/ch_booking_remove.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession s=req.getSession(true);//true creates new session, even if it exists
		//blank: if session exists, open it, and if it doesn't, create new one
		int bId=Integer.parseInt(req.getParameter("b_id"));//get  the parameter equal to the name in the input box in the html file
		String rName=req.getParameter("rr_name");
		try
		{
			BookingDAO d=new BookingDAO();
			boolean works=d.unbookConferenceHall(bId, rName);
		}
		catch (SQLException e)
		{
			
		}
		res.sendRedirect(req.getContextPath()+"/LocationSummary");		
	}

}
