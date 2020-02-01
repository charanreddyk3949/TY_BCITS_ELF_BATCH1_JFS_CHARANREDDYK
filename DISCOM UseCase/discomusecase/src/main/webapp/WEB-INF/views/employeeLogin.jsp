<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
          <p id="headText">Discom Electric Power Supply Limited  </p> 
          <a href="">English</a>&nbsp;|&nbsp;
           <a href="" style="margin-right:20px">Kannada</a>
      </form>
    </nav>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul  class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" style="color: aqua;padding-left: 100px;font-size: 20px;" href="/homepage/homepage.html">Home </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" style="color: aqua;padding-left: 100px;font-size: 20px;" href="/consumerlogin/consumerlogin1.html">Consumer Portal</a>
      </li>
      <li class="nav-item">
          <a class="nav-link" style="color: aqua;padding-left: 100px;font-size: 20px;" href="/employeelogin/employeelogin.html">Employee Portal</a>
        </li>
      
      <li class="nav-item">
        <a class="nav-link disabled" style="color: aqua;padding-left: 100px;font-size: 20px;" href="#" tabindex="-1" >New Connection</a>
      </li>
    </ul>
  </div>
</nav>

    
     <body background="${images}/img2.jpg"
	  style="background-size: cover; background-position: center; background-repeat: no-repeat; 
	  background-size: cover; height: 724px;">

	<div class="container">
		<!--  <div class="card card-container">
            <div class=" col-10 col-sm-10 col-md-10 col-lg-10 col-xl-10 mt-5">    -->
		<form id="cform" action="./employeeLogin">
			<h1>Employee Login</h1>
			<br>
			<br>
			<br> <input type="image" src="${images}/user.png" alt="">
			<input type="text" name="userId" id="" placeholder="employee Id"><br>
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