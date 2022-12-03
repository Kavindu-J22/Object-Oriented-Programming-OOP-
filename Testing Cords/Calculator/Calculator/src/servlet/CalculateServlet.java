package servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/CalculateServlet")
public class CalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no1 = request.getParameter("no1");
		
		String no2 = request.getParameter("no2");
		
		String button = request.getParameter("button");
		
		Calculate calculate = new Calculate();
		double output = 0;
		if(button.equals("+")){
			output = calculate.add(no1, no2);
		}else if(button.equals("-")){
			output = calculate.sub(no1, no2);
		}
		else if(button.equals("*")){
			output = calculate.multiply(no1, no2);
		}
		else{
			output = calculate.div(no1, no2);
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Results.jsp");
		request.setAttribute("value", output);
		dispatcher.forward(request, response);
	}

}
