<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.*" %>
 <%@ page import="pracexamMVC.model.Employee" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" >
function formatDate(date) {
	  return (
	    [
	      date.getFullYear(),
	      padTo2Digits(date.getMonth() + 1),
	      padTo2Digits(date.getDate()),
	    ].join('-') 
	  );
	}
	
function padTo2Digits(num) {
	  return num.toString().padStart(2, '0');
	}
	
	
function getEmployee(empno) {
	$("#EditEmployee").css("display","block");
    $.ajax({
        url: "GetEmployeeServlet?empno=" + empno,
        success: function(responseText) {
        	console.log(responseText);
            var data = responseText;
            $("#empno").val(data.empno);
            $("#ename").val(data.ename);
            $("#job").val(data.job);
            $("#hiredate").val(formatDate(new Date(data.hdate)))
            $("#mgr").val(data.mgr);
            $("#sal").val(data.sal);
            $('#deptno').val(data.deptno);
        }
    });
    

}
function deleteEmployee(id) {
    if (confirm("Are you sure you want to delete this employee?")) {
    	var type="deleteEmployee";
        $.ajax({
            url: "DeleteEmpServlet",
            method:"post",
            data:{
            	type:type,
            	empno:id
            },
            success: function(responseText) {
                location.reload();
                $("#EditEmployee").css("display","none");
            }
        });
    }
}
function updateEmployee() {
	var empno=$("#empno").val();
    var ename = $("#ename").val();
    var job = $("#job").val();
    var hiredate = $("#hiredate").val();
    var mgr = $("#mgr").val();
    var sal= $("#sal").val();
    var deptno =$("#deptno").val();
    var type="updateEmployee";
    var emp={
        	type:type,
        	empno:empno,
        	ename:ename,
        	job:job,
        	hiredate:hiredate,
        	mgr:mgr,
        	sal:sal,
        	deptno:deptno	
            
        };
        emp=JSON.stringify(emp);
    $.ajax({
        url: "UpdateServlet",
        method: "post",
        data: {
        	emp:emp,
        	hdate:hiredate
            
        },
        success: function(responseText) {
            location.reload();
        }
    });
}
</script>
<body>


<a href="home"	><button>Home Page</button></a>
    <!-- Employee List -->
    <h2>Employee List</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Employee Name</th>
            <th>Job</th>
            <th>Hire Date</th>
            <th>Department no</th>
            <th>Salary</th>
            <th>Manager Id</th>
            <th>Actions</th>
        </tr>
        <%-- Loop through employees and display table rows --%>
        <%
        ArrayList<Employee> empl= (ArrayList<Employee>) request.getAttribute("emplist1");
        System.out.print("jsp"+empl);
        for(Employee e: empl){

        %>

        <tr>

            <td><%= e.getEmpno() %></td>

            <td><%= e.getEname() %></td>

            <td><%= e.getJob() %></td>

            <td><%= e.getHdate() %></td>
            <td><%=e.getDeptno() %></td>
            <td><%= e.getSal() %></td>
            <td><%= e.getMgr() %></td>

            <td>

                <button onclick="getEmployee(<%= e.getEmpno() %>)">Edit</button>

                <button onclick="deleteEmployee(<%= e.getEmpno() %>)">Delete</button>

            </td>

        </tr>
             <%

                }

        %>

    </table>

    <!-- Edit Employee Form -->
<div id="EditEmployee" style="display:none">
    <h2>Edit Employee</h2>

    <form>

        <input type="hidden" id="empno" name="empno">

        <label for="ename">Employee Name:</label>

        <input type="text" id="ename" name="ename" required>

        <label for="job">Job:</label>

        <input type="text" id="job" name="job" required>

        <label for="hiredate">Hire Date:</label>

        <input type="date" id="hiredate" name="hiredate" required>
        
        <label for="mgrno">Manager NO:</label>

        <input type="text" id="mgr" name="mgr" required>

        <label for="sal">Salary:</label>

        <input type="number" id="sal" name="sal" step="any" required>

        <label for="DEptno">Department No:</label>

        <input type="number" id="deptno" name="deptno" required>

        <input type="button" value="Update" onclick="updateEmployee()">

    </form>
  </div>
</body>
</html>