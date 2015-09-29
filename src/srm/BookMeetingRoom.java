package srm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BookMeetingRoom")
public class BookMeetingRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookMeetingRoom() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pickedattribute", request.getSession().getAttribute("pickedattribute"));
		request.getRequestDispatcher("WEB-INF/views/mr_booking_add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
