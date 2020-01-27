<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String errMsg= (String) request.getAttribute("errMsg");
       String msg=(String) request.getAttribute("msg");
    %>
    <jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management</title>
</head>
<body>
	<fieldset>
		<legend>Update employee</legend>
		<form action="./updateEmp" method="post">
			<label>Employee ID:</label><br>
			<input type="text" name="empId" required><br>
			<label>Name:</label><br>
			<input type="text" name="name"><br>
			<label>Mobile No:</label><br>
			<input type="long" name="mobileNo"><br>
			<label>OfficialMailid:</label><br>
			<input type="email" name="officialMailid"><br>
			<label>Date of Birth:</label><br>
			<input type="date" name="dateOfBirth"><br>
			<label>Date of Joining:</label><br>
			<input type="date" name="dateOfJoining"><br>
			<label>Designation:</label><br>
			<input type="text" name="designation"><br>
			<label>Blood group:</label><br>
			<input type="text" name="bloodGroup"><br>
			<label>Salary:</label><br>
			<input type="text" name="salary"><br>
			<label>Dept Id:</label><br>
			<input type="text" name="deptId"><br>
			<label>Manager Id:</label><br>
			<input type="text" name="managerId"><br>
			<label>Password:</label><br>
			<input type="text" name="password"><br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    <input type="submit" value="Update">
		</form>
	</fieldset>
</body>
</html>
<% if (errMsg != null && !errMsg.isEmpty()) { %>
<h1 style="color: red"><%= errMsg %></h1>
<% } %>

<% if(msg != null && !msg.isEmpty()) {%>
<h1 style="color: green"><%=msg %></h1>
<% } %>

<jsp:include page="footer.jsp"></jsp:include>