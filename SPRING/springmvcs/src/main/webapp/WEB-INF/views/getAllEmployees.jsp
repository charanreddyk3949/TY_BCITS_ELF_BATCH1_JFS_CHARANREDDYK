<%@page import="java.util.List"%>
<%@page import="com.bcits.springmvcs.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
     <%  List<EmployeeInfoBean> empList=(List<EmployeeInfoBean>)request.getAttribute("employeeDetails");
          String errMsg= (String) request.getAttribute("errMsg");   
    %>
    
    <jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <form action="./getAllEmp"method="get">
          <input type="submit" value="ClickHereToGetAllEmployees">
        </form>
    <%if (errMsg != null && !errMsg.isEmpty())  {%>
      <h3 style="color:red"><%=errMsg %></h3>
      <% } %>
     
     <% if(empList != null) { %>
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
              <%for(EmployeeInfoBean emplists :empList) { %>
              <tr>
                   <td><%= emplists.getEmpId() %></td>
                   <td><%= emplists.getName()%></td>
                   <td><%= emplists.getDesignation() %></td>
                   <td><%= emplists.getSalary() %></td>
                   <td><%= emplists.getOfficialMailid() %></td>
              </tr>
              <% } %>
           </table>
       </div>
    <% } %>  
    
</body>
</html>

<jsp:include page="footer.jsp"></jsp:include>

