<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String msg=(String) request.getAttribute("msg");
       String errMsg=(String) request.getAttribute("errMsg");
    %>
    
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
  <title>Employee Signup</title>
      <link rel="stylesheet" href="${css}/consumerSignup.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"  />
    <link rel="stylesheet" href="${css}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/all.css">
</head>
<body>

          
<nav id="head" style="background-color: aquamarine; margin-top: -20px;" class="navbar navbar-light bg-light">
  <img id="headImg" src="${images}/discom.png" alt="">
  <form class="form-inline">
      <p id="headText"style="font-size: 45px;margin-right: 570px;">Discom Power Limited  </p> 
      
      <a href="">English</a>&nbsp;|&nbsp;
       <a href="" style="margin-right:20px">Kannada</a>
  </form>
</nav>

<nav class="navbar navbar-expand-lg navbar-light bg-light">

<div class="collapse navbar-collapse" id="navbarSupportedContent">
<ul  class="navbar-nav mr-auto">
  <li class="nav-item active">
    <a class="nav-link" style="color: aqua;padding-left: 100px;font-size: 20px;" href="../admin/adminHomePage">Home </a>
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


  <div class="container">
    <div class=" col-10 col-sm-10 col-md-10 col-lg-10 col-xl-10 mt-5">
  
             <h1 id="heading" style="color: white;">DISCOM employee Registration</h1>
              <form action="../admin/createEmployee"  method="post"name= "signin" style="color: white" onsubmit= "validateForm(); return  false">
                <div class="form-row" >
                  <div class="col col-md-12">
                    <label for="inputEmail4">Employee Id</label>
                    <input type="number" class="form-control"id="empId" name="empId" placeholder="enter empId...">
                  </div>  
                </div>
              <div class="form-row">
              <div class="col">
                    <label for="inputEmail4">Employee Name</label>
                    <input type="text" class="form-control" id="empName"name="empName"placeholder="enter name...">
                  </div>
                <div class="form-group col-md-12">
                  <label for="inputEmail4">Designation</label>
                  <input type="text" class="form-control" id="designation"name="designation" placeholder="enter designation...">
                </div>
                 <div class="col col-md-12">
                    <label for="inputEmail4">Region</label>
                    <select id="inputState" class="form-control"id="region" name="region"style="height: 25px;font-size:15px;padding-top:0px">
                      <option selected disabled>select region</option>
                      <option>Banglore-North</option>
                      <option>Banglore-South</option>
                    </select>
                  </div>
                  <div class="form-row col-12">
                  <div class="form-group col-12">
                    <label for="inputpassword">Password</label>
                    <input type="password" class="form-control" id="password"name="password"placeholder="Enter password...">
                  </div>                 
                </div>
                <div class="form-group col-md-12">
                <label for="inputAddress">Department Id</label>
                <input type="number" class="form-control" id="deptId" name="deptId" placeholder="enter dept Id...">
              </div>
               <div class="form-group col-md-12" style="margin-top: -20px;">
                <label for="inputAddress">Department Name</label>
                <input type="text" class="form-control" id="deptName"name="deptName" placeholder="enter dept name...">
              </div>   
               
             <button id="button" type="submit" class="btn btn-primary" class="form-group col-md-5"style="margin-left: 350px;margin-top: -20px;">Submit</button>
           </form>
 
    </div>
  </div>
  
  <%if(msg !=null && !msg.isEmpty()) {%>
<h3 style="color: green; margin-left: 400px;"><%= msg %></h3>
<% } %>
 <%if(errMsg !=null && !errMsg.isEmpty()) {%>
<h3 style="color: red; margin-left: 400px"><%= errMsg %></h3>
<% } %>
 
  
  <script src="./jquery-3.4.1.js"></script> 
  <script src="./js/bootstrap.min.js"></script>  
</body>
</html>