<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
<style>
form{
padding:10px;
margin:10px;

}
input
{
padding:10px;
margin:3px;
}
.feild
{
	display: flex;
  justify-content: space-between;
}
.field label
{
	align-element:left;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="function.js"></script>
<script type="text/javascript">
function addEmployee() {
	var empno=$("#addempno").val();
    var ename = $("#addename").val();
    var job = $("#addjob").val();
    var hiredate = $("#addhiredate").val();
    var mgr = $("#addmgr").val();
    var sal= $("#addsal").val();
    var deptno =$("#adddeptno").val();
    var type="addEmployee";
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
        url: "AddEmpServlet",
        method: "post",
        data: {
        	emp:emp,
        	hdate:hiredate
            
        },
        success: function(data) {
            
            	
            	alert("employee added successfully");
            	location.reload();
        }
    });
}</script>
</head>

<body>

<a href="home"	><button align="center">Home Page</button></a>
<div id="AddEmployee" align="center" style="display:block">
    <!-- Add Employee Form -->
    <h2>Add Employee</h2>
    <form>
    <div class="field">
    	<label for="empno">Employee Number:</label>
         <input type=number id="addempno" name="empno"><br>
	</div>
	<div class="field">
        <label for="ename">Employee Name:</label>

        <input type="text" id="addename" name="ename" required><br>
	</div>
	<div class="field">
        <label for="job">Job:</label>

        <input type="text" id="addjob" name="job" required><br>
	</div>
	<div class="field">
        <label for="hiredate">Hire Date:</label>

        <input type="date" id="addhiredate" name="hiredate" required><br>
    </div>
    <div class="field">    
        <label for="mgrno">Manager NO:</label>

        <input type="text" id="addmgr" name="mgr" required><br>
     </div>
	<div class="field">
        <label for="sal">Salary:</label>

        <input type="number" id="addsal" name="sal" step="any" required><br>
</div>
<div class="field">
        <label for="DEptno">Department No:</label>
    
	
        <input type="number" id="adddeptno" name="deptno" required><br>
 </div>
        <input type="button" value="Add" onclick="addEmployee()"><br>
    
    </form>
</div>
</body>
</html>