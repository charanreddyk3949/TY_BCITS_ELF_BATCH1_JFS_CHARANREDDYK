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
  <title>Consumer SignUp</title>
      <link rel="stylesheet" href="${css}/consumerSignup.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"  />
    <link rel="stylesheet" href="${css}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/all.css">
</head>
<nav id="head" style="background-color: aquamarine; margin-top: -20px;" class="navbar navbar-light bg-light">
  <img id="headImg" src="${images}/discom.png" alt="">
  <form class="form-inline">
      <p id="headText"style="font-size: 45px;margin-right: 570px;">Discom Power Limited  </p> 
      
      <!-- <h4 id="headText1">LightenUp the Lives</h4> -->
      <a href="">English</a>&nbsp;|&nbsp;
       <a href="" style="margin-right:20px">Kannada</a>
  </form>
</nav>

<nav class="navbar navbar-expand-lg navbar-light bg-light">

<div class="collapse navbar-collapse" id="navbarSupportedContent">
<ul  class="navbar-nav mr-auto">
  <li class="nav-item active">
    <a class="nav-link" style="color: aqua;padding-left: 100px;font-size: 20px;" href="../consumer/homePage">Home </a>
  </li>
  
</ul>
<form class="form-inline my-2 my-lg-0">
      <a href="../admin/adminLogout" class="btn btn-outline-success my-2 my-sm-0"style="border:1px solid">Logout</a>
   </form>
</div>
</nav>
    <body background="${images}/bulb1.jpg" style="background-size:cover;background-position: center; 
          background-repeat: no-repeat; 
          background-size: cover; height: 724px;"/>
 
  
  
  
  <div class="col-3" style="margin-top: 200px" >
    <div class="list-group" id="list-tab" role="tablist" >     
      <a class="list-group-item list-group-item-action"style="background-color: aqua ;color: white;font-size: 20px" id="list-profile-list" data-toggle="list" href="../admin/employeeCreateForm" role="tab" aria-controls="profile">Create Employee</a>
      <a class="list-group-item list-group-item-action" style="background-color: navy;color: white;font-size: 20px"id="list-messages-list" data-toggle="list" href="../consumer/getBillHistory" role="tab" aria-controls="messages">Update Employee</a>

 
    </div>
  </div>

	<script src="./jquery-3.4.1.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>

<%if(msg !=null && !msg.isEmpty()) {%>
<h3 style="color: green"><%= msg %></h3>
<% } %>
 <%if(errMsg !=null && !errMsg.isEmpty()) {%>
<h3 style="color: red; margin-left: 700px"><%= errMsg %></h3>
<% } %>