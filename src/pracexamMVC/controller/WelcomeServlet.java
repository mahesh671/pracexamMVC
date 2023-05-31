package pracexamMVC.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pracexamMVC.DAL.EmpDao;
import pracexamMVC.DAL.getEmpDal;
import pracexamMVC.model.Employee;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmpDao edao = new getEmpDal();
		ArrayList<Employee> empl = edao.getEmpList();
		request.setAttribute("emplist", empl);
		System.out.println(empl);
		request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);

	}

}
