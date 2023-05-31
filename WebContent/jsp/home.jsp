<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.*" %>
 <%@ page import="pracexamMVC.model.Employee" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Management</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" src="function.js"></script>
    <script type="text/javascript">
    function logout()
    {
    	$.ajax({
    		url:"LogoutServlet",
    		method:"GET",
    		success:function()
    		{
    			alert("SuccessFully Logged Out");
    			location.reload();
    		}
    	});
    }
    </script>
</head>
<body>
    <h1 align="center">Employee Management</h1>
    <!-- Employee List -->
    <div id="admincontrols" align="center">
    <a href="AddEmp"><button align="center" >ADD Employee</button></a>
    <a href="GetEditPage"><button>Update / Delete Employee</button></a>
    <button onclick="logout()">LogOut</button>
    </div>
  <div align="center">
    <h2>Employee List</h2>
    <table border=1>
        <tr>
            <th>ID</th>
            <th>Employee Name</th>
            <th>Job</th>
            <th>Hire Date</th>
            <th>Department no</th>
            <th>Salary</th>
            <th>Manager Id</th>
           
        </tr>
        <%-- Loop through employees and display table rows --%>
        <%
           ArrayList<Employee> empl= (ArrayList<Employee>) request.getAttribute("emplist");
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

           

        </tr>
        <%} %>

    </table>

    <!-- Edit Employee Form -->

  </div>

</body>

</html>