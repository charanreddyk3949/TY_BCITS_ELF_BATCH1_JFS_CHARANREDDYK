<%@page import="com.bcits.empwebapp.beans.EmployeePrimaryInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <% EmployeePrimaryInfo employeePrimaryInfo=(EmployeePrimaryInfo)request.getAttribute("empInfo"); %>
    <jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <fieldset>
     <legend>Search employee</legend>
    <form action="./getEmp">
     <label>Employee ID:</label>
     <input type="text" name="empId"required>
          &nbsp;&nbsp;&nbsp;
     <input type="submit" value="Search">
     </form>
   </fieldset>
   
 <h2>Search employee</h2>  
<% if(employeePrimaryInfo !=null){ %>
Name=<%= employeePrimaryInfo.getName() %><br>
Salary=<%= employeePrimaryInfo.getSalary() %><br>
Designation=<%= employeePrimaryInfo.getDesignation() %><br>
<%} else{ %>
<h2 style="color:red">Employee Id not found</h2>
<%} %>
</body>
</html>



 