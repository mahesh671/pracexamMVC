package pracexamMVC.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginStatus
 */
@WebServlet("/LoginStatus")
public class LoginStatus extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2744609291969496329L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("LoginStatus");
		String uname = request.getParameter("uname");
		String psw = request.getParameter("psw");
		HttpSession hs = request.getSession();
		if (uname.equals("Mahesh") && psw.equals("1234")) {
			hs.setAttribute("loginstatus", "yes");
			response.sendRedirect(request.getContextPath() + "/home");

		} else if (uname.equals("Admin") && psw.equals("root")) {
			hs.setAttribute("loginstatus", "yes");
			hs.setAttribute("authstatus", "yes");
			response.sendRedirect(request.getContextPath() + "/home");
		}

		else {
			System.out.println("redirected");
			hs.setAttribute("loginstatus", "No");
			response.sendRedirect(request.getContextPath() + "/jsp/error.jsp");
		}

	}

}
