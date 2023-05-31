package pracexamMVC.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pracexamMVC.DAL.EmpDao;
import pracexamMVC.DAL.getEmpDal;
import pracexamMVC.model.Employee;

/**
 * Servlet implementation class AddEmpServlet
 */
@WebServlet("/AddEmpServlet")
public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEmpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest rq, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Employee e = new Gson().fromJson(rq.getParameter("emp"), Employee.class);
		e.setHdate(Date.valueOf(rq.getParameter("hdate")));
		System.out.println(e.getHdate());
		EmpDao edao = new getEmpDal();
		response.getWriter().println(edao.addEmp(e));

	}

}
