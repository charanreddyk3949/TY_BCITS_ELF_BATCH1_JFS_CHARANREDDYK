<%@page import="com.bcits.springmvcs.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% EmployeeInfoBean employeeInfoBean=(EmployeeInfoBean) session.getAttribute("loggedinEmpInfo"); %>
    
 <jsp:include page="header.jsp"></jsp:include>  
 
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   
   <h1>Employee <%= employeeInfoBean.getName() %>  Found!!!</h1>
</body>
</html>

<jsp:include page="footer.jsp"></jsp:include>