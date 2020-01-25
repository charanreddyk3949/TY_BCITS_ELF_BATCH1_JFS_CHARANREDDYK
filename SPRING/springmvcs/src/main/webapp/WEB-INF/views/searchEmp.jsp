<%@page import="com.bcits.springmvcs.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%EmployeeInfoBean employeeInfoBean=(EmployeeInfoBean) request.getAttribute("employeeInfoBean");
     String errMsg=(String) request.getAttribute("errMsg");
   %>
    
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
    <form action="./search">
     <label>Employee ID:</label>
     <input type="text" name="empId"required>
          &nbsp;&nbsp;&nbsp;
     <input type="submit" value="Search">
     </form>
   </fieldset>
   
   <%if (errMsg != null && !errMsg.isEmpty())  {%>
   
      <h3 style="color:red"><%=errMsg %></h3>
      <% } %>
     <%if (employeeInfoBean != null) { %>
       <div align="center">
           <table border="1" style="width: 70%">
              <tr style="background: navy; color: white">
                 <th>Employee Id</th>
                 <th>Name</th>
                 <th>Designation</th>
                 <th>Salary</th>
                 <th>DOB</th>
                 <th>Mobile</th>
              </tr>
              <tr>
                   <td><%= employeeInfoBean.getEmpId() %></td>
                   <td><%= employeeInfoBean.getName()%></td>
                   <td><%= employeeInfoBean.getDesignation() %></td>
                   <td><%= employeeInfoBean.getSalary() %></td>
              </tr>
           </table>
       
       </div>
   <% }else { %>
        <h3 style="color:red"><%=errMsg %></h3>
   <% } %>
   
   
   

</body>
</html>

<jsp:include page="footer.jsp"></jsp:include>