<%@page import="com.bcits.springsecuritymvc.beans.EmpInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%EmpInfoBean empInfoBean=(EmpInfoBean) request.getAttribute("empInfo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <div align="center">
        <fieldset style="width: 60%">
           <legend>Search Employee</legend>
           <form action="./getEmployee">
               Emplyee Id : <input type="text" name="empId" required="required">
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="submit" value="search">
               
           </form>
        </fieldset>
        
        
        <% if(empInfoBean != null) {%>
          <table>
              <thead>
                    <tr style="background: navy;color: white;">
                        <th>Employee Id</th>
                        <th>Employee Name</th>
                        <th>Password</th>
                        <th>Role</th>
                    </tr>
              </thead>
              <tbody>
                  <tr>
                     <td><%= empInfoBean.getEmpId() %></td>
                     <td><%= empInfoBean.getName() %></td>
                     <td><%= empInfoBean.getPassword() %></td>
                     <td><%= empInfoBean.getRole() %></td>
                  </tr>
              
              </tbody>
          </table>
        <%} else {%>
        <h3 style="color: red; ">Employee Id Not Found !!!</h3>
        <% } %>
   </div>
   
   
</body>
</html>