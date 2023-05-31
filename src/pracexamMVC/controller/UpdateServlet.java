package pracexamMVC.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pracexamMVC.DAL.getEmpDal;
import pracexamMVC.model.Employee;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Employee e = new Gson().fromJson(request.getParameter("emp"), Employee.class);
		e.setHdate(Date.valueOf(request.getParameter("hdate")));
		response.getWriter().write(new getEmpDal().updateEmp(e));

	}

}
