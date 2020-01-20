<%@page import="com.bcits.empwebapp.beans.EmployeePrimaryInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <% List<EmployeePrimaryInfo> employeesList=(List<EmployeePrimaryInfo>)request.getAttribute("employeesList"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body >
   <%if(employeesList != null){ %>
   <table border="1" style="width: 80%">
     <thead style="background: navy;color: white">
        <tr style="height: 35px">
           <th>EmployeeID</th>
           <th>Name </th>
           <th>Salary</th>
           <th>Designation</th>
           <th>DOB</th>
           <th>Mobile No.</th>
        </tr>
     </thead>
     <tbody>
        <% for(EmployeePrimaryInfo primaryInfo:employeesList) {%>
           <tr>
              <td><%= primaryInfo.getEmpId() %></td>
              <td><%= primaryInfo.getName() %></td>
              <td><%= primaryInfo.getSalary() %></td>
              <td><%= primaryInfo.getDesignation() %></td>
              <td><%= primaryInfo.getDateOfJoining() %></td>
              <td><%= primaryInfo.getMobileNo() %></td>
           </tr>
        <%} %>
     </tbody>
   </table>
   
   <% }else { %>
   <h1 style="color: red">No records to display</h1>
   
   <%} %>
</body>
</html>