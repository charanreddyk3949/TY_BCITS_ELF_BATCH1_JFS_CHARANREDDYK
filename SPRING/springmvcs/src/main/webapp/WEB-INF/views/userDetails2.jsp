<%@page import="com.bcits.springmvcs.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% UserBean userBean= (UserBean) request.getAttribute("userBean");
       String name =(String) request.getAttribute("name");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h3 style="color: navy"> User Id = <%=userBean.getEmpId() %></h1>
 <h3 style="color: navy"> Password = <%=userBean.getPassword()%></h1>
 <h3 style="color: navy"> Name = <%= name%></h1>
</body>
</html>