<%@page import="com.bcits.springsecuritymvc.beans.EmpInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% List<EmpInfoBean> employeesList=(List<EmpInfoBean>)request.getAttribute("employeesList"); %>
    
    <jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
   <% if(employeesList != null && !employeesList.isEmpty()) { %>
      <table>
              <thead>
                    <tr style="background: navy;color: white;height: 40px">
                        <th>Employee Id</th>
                        <th>Employee Name</th>
                        <th>Password</th>
                        <th>Role</th>
                    </tr>
              </thead>
              <tbody>
                 <%for(EmpInfoBean empInfoBean:employeesList ){%>
                  <tr style="height: 40px">
                     <td><%= empInfoBean.getEmpId() %></td>
                     <td><%= empInfoBean.getName() %></td>
                     <td><%= empInfoBean.getPassword() %></td>
                     <td><%= empInfoBean.getRole() %></td>
                  </tr>
                 <%} %>
              </tbody>
          </table>
   <% } else { %>
   <h3 style="color: red">No Records Found!</h3>
    <%} %>
    
    </div>
</body>
</html>