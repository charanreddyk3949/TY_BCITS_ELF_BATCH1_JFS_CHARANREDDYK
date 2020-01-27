<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% String msg=(String) request.getAttribute("msg");
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
       <legend>Employee Adding</legend>
     <form action="./addEmp" method="post">
          <table>
             <tr>
                 <td> EmpId </td>
                 <td> : </td>
                 <td><input type="number" name="empId"></td>
             </tr> 
             <tr>
                 <td> Name </td>
                 <td> : </td>
                 <td><input type="text" name="name"></td>
             </tr>
             <tr>
                 <td> Official Mail </td>
                 <td> : </td>
                 <td><input type="mail" name="officialMailid"></td>
             </tr>
             <tr>
                 <td> Date of Birth </td>
                 <td> : </td>
                 <td><input type="date" name="dateOfBirth"></td>
             </tr>
             <tr>
                 <td> Date of Joining </td>
                 <td> : </td>
                 <td><input type="date" name="dateOfJoining"></td>
             </tr>
             <tr>
                 <td> Designation </td>
                 <td> : </td>
                 <td><input type="text" name="designation"></td>
             </tr>
             <tr>
                 <td> Bloodgroup </td>
                 <td> : </td>
                 <td><input type="text" name="bloodGroup"></td>
             </tr>
             <tr>
                 <td> Salary </td>
                 <td> : </td>
                 <td><input type="number" name="salary"></td>
             </tr>
             <tr>
                 <td> DeptId </td>
                 <td> : </td>
                 <td><input type="number" name="deptId"></td>
             </tr>
             <tr>
                 <td> Manager Id </td>
                 <td> : </td>
                 <td><input type="number" name="managerId"></td>
             </tr>
              <tr>
              <tr>
                 <td> Password </td>
                 <td> : </td>
                 <td><input type="password" name="password"></td>
             </tr>
                 <td colspan="3" align="center"> 
                   <input type="submit">
                  </td>
             </tr>
          </table>
       </form>
    </fieldset>

</body>
</html>

<% if(msg !=null && !msg.isEmpty()) {%>
<h3 style="color: green"><%= msg %></h3>
<% } %>

<% if(errMsg !=null && !errMsg.isEmpty()) {%>
<h3 style="color: red"><%= errMsg %></h3>
<% } %>


<jsp:include page="footer.jsp"></jsp:include>
