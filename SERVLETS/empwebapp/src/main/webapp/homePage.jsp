<%@page import="com.bcits.empwebapp.beans.EmployeePrimaryInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% EmployeePrimaryInfo empInfo=(EmployeePrimaryInfo)session.getAttribute("loggedInEmpInfo"); %>
    
    <jsp:include page="header.jsp"></jsp:include>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <h1>Welcome <%= empInfo.getName() %>...</h1>
</body>
</html>