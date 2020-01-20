<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%! private int a=10;
    public void setA(int a){
	     this.a=a;
    }
    public int getA(){
    	return a;
    }
    public String name="charan";
    public String getName(){
    	return name;
    }
    public String getName(String name){
    	return name;
    }
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: navy">Welcome to JSP....</h1>
	
	a=<%= a %><br> 
	a=<%= getA() %><br>
	<% setA(50); %>
	a=<%= getA() %><br>
	<br> Name=<%= name %><br> 
	Name=<%= getName() %><br> 
	Name=<%= getName("reddy") %><br>
	<br>

	<% for(int i=0; i<5; i++ ){ %>
	<%= getName() %><br>

	<%} %>

</body>
</html>


<%--<jsp:forward page="./date.html" />--%> <%--static resource --%>
<%--<jsp:forward page="./currentDate" />--%>  <%--dynamic resource --%>

<%--<jsp:forward page="./searchEmp?empId=1234" />--%>

  <%--  <jsp:forward page="./searchEmp">  
     <jsp:param name="empId" value="12" />
     </jsp:forward>    --%>  
  
 <%--   <jsp:include page="/currentDate" /> --%> 
  <%--   <jsp:include page="/searchEmp">  
     <jsp:param name="empId" value="12" />
     </jsp:include>    --%> 
     
       <%@ include file="date.html" %>
     
  <%--   <%@ include file="/currentDate" %> --%>  <%-- Dynamic resource not allowed --%>
     
    
