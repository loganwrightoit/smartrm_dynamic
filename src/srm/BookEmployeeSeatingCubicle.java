package srm;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import srm.dao.BookingDAO;

@WebServlet("/BookEmployeeSeatingCubicle")
public class BookEmployeeSeatingCubicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookEmployeeSeatingCubicle() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/esc_booking_add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd=null;
		try
		{
			HttpSession s=req.getSession(true);//true creates new session, even if it exists
			//blank: if session exists, open it, and if it doesn't, create new one
			int lId=Integer.parseInt(req.getParameter("l_id"));//get  the parameter equal to the name in the input box in the html file
			int rrId=Integer.parseInt(req.getParameter("rr_id"));
			int uId=Integer.parseInt(req.getParameter("u_id"));
			String startTime=req.getParameter("start_time");
			String endTime=req.getParameter("end_time");
			String specReq=req.getParameter("special_requests");
			String purpose=req.getParameter("purpose");
			BookingDAO d=new BookingDAO();
			boolean works=d.bookConferenceHall(lId, rrId, uId, startTime, endTime, specReq, purpose);
			res.sendRedirect(req.getContextPath()+"/LocationSummary");
		}
		catch (SQLException e)
		{
			req.setAttribute("error", "Something went wrong");
			rd=req.getRequestDispatcher("/WEB-INF/views/esc_booking_add.jsp");
			rd.include(req, res);
		}
	}

}
