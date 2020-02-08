<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    
     <% String msg=(String) request.getAttribute("msg");
       String errMsg=(String) request.getAttribute("errMsg");
       String errSignupMsg=(String) request.getAttribute("errSignupMsg");
    %>
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>ConsumerLogin</title>
    <link rel="stylesheet" href="${css}/consumerLogin.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"  />
    <link rel="stylesheet" href="${css}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/all.css">
    <link rel="stylesheet" href="${js}/all.js">
    
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
       <spring:url var="css" value="/resources/css"/>
       <spring:url var="js" value="/resources/js"/>
       <spring:url var="images" value="/resources/images"/>
  
</head>
<body>
          <body background="${images}/bulb1.jpg" style="background-size:cover;background-position: center; 
          background-repeat: no-repeat; 
          background-size: cover; height: 724px;">

          <nav id="head" style="background-color: aquamarine; margin-top: -20px;" class="navbar navbar-light bg-light">
            <img id="headImg" src="${images}/discom.png" alt="">
            <form class="form-inline">
                <p id="headText"style="font-size: 45px;margin-right: 570px;">Discom Power Limited </p> 
                <a href="">English</a>&nbsp;|&nbsp;
                 <a href="" style="margin-right:20px">Kannada</a>
            </form>
          </nav>

      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul  class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" style="color: aqua;padding-left: 100px;font-size: 20px;" href="../consumer/homePage">Home </a>
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
      <% if(errSignupMsg !=null && !errSignupMsg.isEmpty()) {%>
       <h3 style="color: green; padding-left:370px"><%= errSignupMsg %></h3>
       <% } %>
      
     <% if(msg !=null && !msg.isEmpty()) {%>
       <h3 style="color: green; padding-left:270px"><%= msg %></h3>
       <% } %>
      
      <div class="container">
        <div class=" col-10 col-sm-10 col-md-10 col-lg-10 col-xl-10 mt-5">
      <div id="consumerform">
        <form class="formc" action="../consumer/login" method="post"onsubmit="validateForm();return  false">
          <input type="image" src="${images}/user3.png" alt="">
         <h2 style="padding-left: 70px;color: skyblue;">Consumer Login</h2>
          <div class="form-group" >
            <input type="text" class="form-control" id="rrNumber"name="rrNumber" style="width: 350px;" placeholder="Meter / rr number" required>
            <span id="rrNumErr" class="text-danger font-weight-bold"></span>
          </div>
          <div class="form-group">
            <input type="password" class="form-control" id="password"name="password"style="width: 350px;"placeholder="password" required>
            <span id="pwdErr" class="text-danger font-weight-bold"></span>
          </div>
          <div  id="nemp">
            New User?
            <a href="../consumer/consumerSignup"> SIGNUP</a> &nbsp; | &nbsp;
            <a href="/forgot-user-id" target="_self" title="Forgot User ID?" >Forgot Password</a>
          </div><br>
          <div id="postsubmit">
          <button type="submit"class="btn btn-primary" style="margin-left: 150px;">Submit</button>
          </div>
        </form>
      </div>
    </body>
    
 

<% if(errMsg !=null && !errMsg.isEmpty()) {%>
<h3 style="color: red;padding-left:270px"><%= errMsg %></h3>
<% } %>
    
  <script src="${js}/consumerLogin.js"></script>   
  <script src="./jquery-3.4.1.js"></script> 
  <script src="./js/bootstrap.min.js"></script>    
</body>
</html>