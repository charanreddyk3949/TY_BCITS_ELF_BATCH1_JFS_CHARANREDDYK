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
  <title>Consumer SignUp</title>
      <link rel="stylesheet" href="${css}/consumerSignup.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"  />
    <link rel="stylesheet" href="${css}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/all.css">
</head>
<body>
<nav id="head" style="background-color: aquamarine; margin-top: -20px;" class="navbar navbar-light bg-light">
  <img id="headImg" src="${images}/discom.png" alt="">
  <form class="form-inline">
      <p id="headText">Discom Power Limited  </p> 
      
      <!-- <h4 id="headText1">LightenUp the Lives</h4> -->
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
</ul>
<form class="form-inline my-2 my-lg-0">
         <a href="../consumer/logout" class="btn btn-outline-success my-2 my-sm-0"style="border:1px solid">Logout</a>
        </form>
</div>
</nav>
<a href="../consumer/paymentDetails" role="button" class="btn btn-info"style="width: 100%;color :white; font-size: 20px ">Payment Details</a>
   
    <div class="container">
        <div class=" col-10 col-sm-10 col-md-10 col-lg-10 col-xl-10 mt-5">

    <form action="" style="border: 1px solid black;width: 600px;height: 540px; margin-left: 300px; background-color: whitesmoke; ">
        <div style="border: 1px solid black;text-align: center;background-color: #00ff00;height: 70px; color: white;">
        <h1>Success</h1>
        </div>
        <div style="margin-top: 30px;">
          <img src="${images}/paymentsuccess.jpg " alt="" style="height: 200px;width: 200px;margin-left: 200px;">
        </div>

        <h2 style="text-align: center; font-size: 30px;color:forestgreen;">Bill Payment is successfull (: </h2>
        
        
        <div style="padding-top: 20px;text-align: center;">
            <h2 style="color: dodgerblue;">DISCOM bill payment 500 is successfull !!!</h2>  
        </div>
        
    </form>
 </div>
 </div>
    
    
</body>
</html>>