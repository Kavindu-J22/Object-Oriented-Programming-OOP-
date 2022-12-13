package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import user.StaffUser;

/**
 * Servlet implementation class LoginServlet
 * This servlet is utilised for validating login and for setting session attributes
 * @author blazing squad
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * This function is utilised for logout.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("logout").equalsIgnoreCase("1") ) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		StaffUser user = new StaffUser();
		int id=0;
		try {
			id = user.login(username, password);
		} catch (SQLException e1) {
			e1.printStackTrace();
			response.sendRedirect("error.jsp");
		}
		
		if(id!=0) {
			try {
				user = user.viewUser(id);
			} catch (SQLException e) {
				e.printStackTrace();
				response.sendRedirect("error.jsp");
			}
			HttpSession session = request.getSession();
			session.setAttribute("session_isloggedin", "true");
			session.setAttribute("session_userid", user.getUserid());
			session.setAttribute("session_username", user.getUserName());
			session.setAttribute("session_userrole", user.getUserRole());
			
			if(user.getUserRole().equals("Admin")) {
				response.sendRedirect("adminhome.jsp");
			} else if(user.getUserRole().equals("Client")){
				response.sendRedirect("presetevents.jsp");
			} else {
				response.sendRedirect("index.jsp");
			}
			
		} else {
			request.setAttribute("loginerror", "Invalid username or password.");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
