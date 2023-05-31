package pracexamMVC.DAL;

import java.util.ArrayList;

import pracexamMVC.model.Employee;

public interface EmpDao {
	String updateEmp(Employee e);

	ArrayList<Employee> getEmpList();

	String addEmp(Employee e);

	Employee getEmp(int empid);

	String delEmp(int empid);

}
