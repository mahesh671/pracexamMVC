$(document).ready(function(){
        // Function to retrieve employee data via AJAX
        function getEmployee(empno) {
        	$("#EditEmployee").css("display","block");
            $.ajax({
                url: "EmployeeServlet?type=getEmployee&empno=" + empno,
                success: function(responseText) {
                	console.log(responseText);
                    var data = responseText;
                    $("#empno").val(data.empno);
                    $("#ename").val(data.ename);
                    $("#job").val(data.job);
                    $("#hiredate").val(data.hiredate);
                    $("#mgr").val(data.mgr);
                    $("#sal").val(data.sal);
                    $('#deptno').val(data.deptno);
                }
            });
        }

        // Function to add a new employee via AJAX
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
                	emp:emp
                    
                },
                success: function(responseText) {
                    location.reload();
                }
            });
        }

        // Function to update an existing employee via AJAX
        function updateEmployee() {
        	var empno=$("#empno").val();
            var ename = $("#ename").val();
            var job = $("#job").val();
            var hiredate = $("#hiredate").val();
            var mgr = $("#mgr").val();
            var sal= $("#sal").val();
            var deptno =$("#deptno").val();
            var type="updateEmployee";
            $.ajax({
                url: "EmployeeServlet",
                method: "post",
                data: {
                	type:type,
                	empno:empno,
                	ename:ename,
                	job:job,
                	hiredate:hiredate,
                	mgr:mgr,
                	sal:sal,
                	deptno:deptno
                },
                success: function(responseText) {
                    location.reload();
                }
            });
        }

        // Function to delete an employee via AJAX
        function deleteEmployee(id) {
            if (confirm("Are you sure you want to delete this employee?")) {
            	var type="deleteEmployee";
                $.ajax({
                    url: "EmployeeServlet",
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
});