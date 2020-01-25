<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String msg = (String) request.getAttribute("msg");
    String errMsg=(String) request.getAttribute("errMsg");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <fieldset>
     <legend>Delete employee</legend>
    <form action="./delete">
     <label>Employee ID:</label>
     <input type="text" name="empId"required>
          &nbsp;&nbsp;&nbsp;
     <input type="submit" value="Search">
     </form>
   </fieldset>

</body>
</html>
<% if(msg != null && !msg.isEmpty()) { %>
   <h3 style="color:green"><%=msg %></h3>
<%} %>
<% if(errMsg != null && !errMsg.isEmpty()) { %>
   <h3 style="color:red"><%=errMsg %></h3>
<%} %>
