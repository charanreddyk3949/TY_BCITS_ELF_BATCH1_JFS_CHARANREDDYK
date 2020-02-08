<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <% String msg=(String) request.getAttribute("msg");
       String errMsg=(String) request.getAttribute("errMsg"); %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Employee Login</title>
    <link rel="stylesheet" href="${css}/employeeLogin.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"  />
    <link rel="stylesheet" href="${css}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/all.css">
</head>
<body>
    <nav id="head" style="background-color: aquamarine; margin-top: -20px;" class="navbar navbar-light bg-light">
      <img id="headImg" src="${images}/discom.png" alt="">
      <form class="form-inline">
          <p id="headText" style="font-size: 45px;margin-right: 570px;">Discom Power Limited  </p> 
          <a href="">English</a>&nbsp;|&nbsp;
           <a href="" style="margin-right:20px">Kannada</a>
      </form>
    </nav>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul  class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" style="color: aqua;padding-left: 100px;font-size: 20px;" href="../home/homePage">Home </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" style="color: aqua;padding-left: 100px;font-size: 20px;" href="../consumer/consumerLogin">Consumer Portal</a>
      </li>
      <li class="nav-item">
          <a class="nav-link" style="color: aqua;padding-left: 100px;font-size: 20px;" href="../employee/employeeLogin">Employee Portal</a>
        </li>
      
    </ul>
  </div>
</nav>

<%if(msg !=null && !msg.isEmpty()) {%>
<h3 style="color: green"><%= msg %></h3>
<% } %>
 <%if(errMsg !=null && !errMsg.isEmpty()) {%>
<h3 style="color: red; margin-left: 700px"><%= errMsg %></h3>
<% } %>
    
     <body background="${images}/bulb1.jpg"
	  style="background-size: cover; background-position: center; background-repeat: no-repeat; 
	  background-size: cover; height: 724px;"/>

	<div class="container">
		
		<form id="cform" action="../employee/empLogin" method="post">
			<h1>Employee Login</h1>
			<br>
			<br>
			<br> <input type="image" src="${images}/user.png" alt="">
			<input type="text" name="empId" id="empId" placeholder="employee Id"><br>
			<br> <input type="password" name="password"
				placeholder="password"><br>
			<br>
			<div id="nemp" style="color: white;">
				New Employee? <a href=" "> SIGNUP</a> &nbsp; | &nbsp; <a
					href="/forgot-user-id" target="_self" title="Forgot User ID?">Forgot
					Password</a>
			</div>
			<br>
			<button type="submit">Signin</button>
		</form>
	</div>


	<script src="./jquery-3.4.1.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>