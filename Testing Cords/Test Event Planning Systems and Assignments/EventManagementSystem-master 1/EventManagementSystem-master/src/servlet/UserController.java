package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.StaffUser;
import util.BCrypt;

/**
 * Servlet implementation class UserController
 * This servlet is utilised for updating data (add, edit, delete) in user
 * @author blazing squad
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * This function is utilised for the delete user function.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StaffUser user = new StaffUser();
		user.setUserid(Integer.parseInt(request.getParameter("id")));
		
		try {
			user.deleteUser(user.getUserid());
			response.sendRedirect("adminhome.jsp");
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] actions = {"add", "edit", "reset"};
		int flag = 0;
		String action = request.getParameter("action"); //To identify which actions to implement.
		
		//Check if the action parameter is from the valid set of actions
		for(int i=0; i<actions.length && flag == 0 ; i++) {
			if(action.equalsIgnoreCase(actions[i])) {
				flag = 1;
			}
		}
		if(flag == 0) {
			response.sendRedirect("error.jsp");
		}
		
		StaffUser user = new StaffUser();
		user.setUserName(request.getParameter("username")); 
		//Turn password to BCrypt hashcode
		String temppassword = BCrypt.hashpw(request.getParameter("password"), BCrypt.gensalt());
		user.setPassword(temppassword);
		user.setEmailAddress(request.getParameter("emailaddress"));
		user.setFirstName(request.getParameter("firstname"));
		user.setLastName(request.getParameter("lastname"));
		user.setUserRole(request.getParameter("userrole"));
		
		if(!action.equalsIgnoreCase("reset")) {
			if(user.getUserRole().equalsIgnoreCase("client")) {
				user.setContactNum(request.getParameter("contactnumber"));
			} 
		}
		
		try {
			if(action.equalsIgnoreCase("add")) { //Call method to add user.
				user.addUser(user);
				response.sendRedirect("adminhome.jsp");
			} else {
				user.setUserid(Integer.parseInt(request.getParameter("userid")));
				if(action.equalsIgnoreCase("edit")) { //Call method to edit user.
					user.editUserDetails(user);
				} else { //Call method to reset user credentials.
					user.resetUserCredentials(user);
				}
				response.sendRedirect("user.jsp?id=" + user.getUserid());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

}
