package pracexamMVC.DAL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pracexamMVC.model.Employee;

public class getEmpDal implements EmpDao {
	private ResultSet rs;
	private Connection con;

	public getEmpDal() {
		// TODO Auto-generated constructor stub
		con = new DbConnection().returnCon();
		System.out.println("DAl intialized");
	}

	public ArrayList<Employee> getEmpList() {
		ArrayList<Employee> al = new ArrayList<>();
		try {
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("select * from mahesh_emp");
			while (rs.next()) {
				Employee e = new Employee();
				e.setDeptno(rs.getInt("deptno"));
				e.setEmpno(rs.getInt("empno"));
				e.setEname(rs.getString("ename"));
				e.setJob(rs.getString("job"));
				e.setHdate(rs.getDate("hiredate"));
				e.setSal(rs.getDouble("sal"));
				e.setMgr(rs.getInt("mgr"));
				al.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

	public String addEmp(Employee e) {
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into mahesh_emp values(?,?,?,?,?,?,?)");

			ps.setInt(1, e.getEmpno());
			ps.setInt(4, e.getMgr());
			ps.setDouble(6, e.getSal());
			ps.setInt(7, e.getDeptno());
			ps.setString(2, e.getEname());
			ps.setString(3, e.getJob());

			ps.setDate(5, e.getHdate());
			int i = ps.executeUpdate();
			if (i == 1) {
				return "Success";
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "Fail";
	}

	public String updateEmp(Employee e) {
		try {

			PreparedStatement ps = con.prepareStatement(
					"update mahesh_emp set ename=? ,job=?,mgr=?,hiredate=?,sal=?,deptno=? where empno=?");
			ps.setInt(7, e.getEmpno());
			ps.setInt(3, e.getMgr());
			ps.setDouble(5, e.getSal());
			ps.setInt(6, e.getDeptno());
			ps.setString(1, e.getEname());
			ps.setString(2, e.getJob());

			ps.setDate(4, e.getHdate());
			int i = ps.executeUpdate();
			if (i == 1) {
				return "Success";
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return "Fail";
	}

	public Employee getEmp(int empid) {
		Employee e = new Employee();
		try {
			Statement ps = con.createStatement();
			System.out.println(empid);
			ResultSet rs = ps.executeQuery("select * from mahesh_emp where empno=" + empid);
			if (rs.next()) {

				e.setEmpno(rs.getInt("empno"));
				e.setEname(rs.getString("ename"));
				e.setJob(rs.getString("job"));
				System.out.println(Date.valueOf(rs.getString("hiredate")));
				e.setHdate(Date.valueOf(rs.getString("hiredate")));
				e.setMgr(rs.getInt("mgr"));
				e.setSal(rs.getDouble("sal"));
				e.setDeptno(rs.getInt("deptno"));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return e;
	}

	public String delEmp(int empid) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from mahesh_emp where empno=?");
			ps.setInt(1, empid);
			int i = ps.executeUpdate();
			if (i != 0) {
				return "Success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Fail";
	}
}
