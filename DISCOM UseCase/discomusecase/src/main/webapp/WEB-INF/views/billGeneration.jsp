<%@page import="com.bcits.discomusecase.beans.CurrentBill"%>
<%@page import="com.bcits.discomusecase.beans.ConsumersMasterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <% String msg=(String) request.getAttribute("msg");
       String errMsg=(String) request.getAttribute("errMsg"); 
       ConsumersMasterBean consumersMasterBean=(ConsumersMasterBean) request.getAttribute("consumerDetails");
       CurrentBill currentBill=(CurrentBill) request.getAttribute("finalreadingValue");
       
       
      /*  Double amount=(Double) request.getAttribute("billDetails"); */
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
  <title>Consumer SignUp</title>
      <link rel="stylesheet" href="${css}/consumerSignup.css">
       <link rel="stylesheet" href="${css}/paymentPage.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"  />
    <link rel="stylesheet" href="${css}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/all.css">
</head>
<body>
<nav id="head" style="background-color: aquamarine; margin-top: -20px;" class="navbar navbar-light bg-light">
  <img id="headImg" src="${images}/discom.png" alt="">
  <form class="form-inline">
      <p id="headText" style="font-size: 45px;margin-right: 570px;">Discom Power Limited  </p> 
      
      <!-- <h4 id="headText1">LightenUp the Lives</h4> -->
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
  
</ul>
<form class="form-inline my-2 my-lg-0">
         <a href="../consumer/logout" class="btn btn-outline-success my-2 my-sm-0"style="border:1px solid">Logout</a>
        </form>
</div>
</nav>

  <body background="${images}/bulb1.jpg" style="background-size:cover;background-position: center; 
          background-repeat: no-repeat; 
          background-size: cover; height: 724px;">

<%if(consumersMasterBean != null && currentBill != null) {%>

   <div style="border: 1px solid black; margin-left: 500px;margin-top: 100px;width: 500px;height: 550px;border-radius: 15px;background-color:white">
            <form class="formsignin" action="./billGeneration" method="post" >
                <h2 style="text-align: center;color:blue;">Bill Generation</h2>
                <div style="margin-left: 150px;margin-top: 30px;">
                   <label> RR Number</label><br>
                   <input type="text" id="rrNumber" name="rrNumber"  value="<%= currentBill.getRrNumber() %>" style="width: 250px;height: 35px;" readonly="readonly">
                </div> 
               <div style="margin-left: 150px;margin-top: 20px;">
                <label> Initial Reading</label><br>
                <input type="number" id="initialReading" name="initialReading" value="<%=currentBill.getPresentReading()%>" style="width: 250px;height: 35px;"readonly="readonly">
               </div>
               <div style="margin-left: 150px;margin-top: 20px;">
                <label> Final Reading</label><br>
                <input type="number" id="presentReading" name="presentReading" style="width: 250px;height: 35px;" placeholder="enter final reading..">
               </div> 
               <div style="margin-left: 150px;margin-top: 20px;">
                <label> Consumer Type</label><br>
                <input type="text" id="consumerType" name="consumerType" value="<%= consumersMasterBean.getConsumerType() %>" style="width: 250px;height: 35px;"readonly="readonly">
               </div><br>
               <div style="margin-left: 150px;margin-top: 0px;">
                <label> Due date</label><br>
                <input type="date" id="dueDate" name="dueDate" style="width: 250px;height: 35px;" placeholder="yyyy/MM/dd">
               </div><br>
               <button style="margin-left: 190px; background-color: cyan;color: black;font-size: 20px;borde-radious:5px">Generate</button>
            
            
            </form>

        </div>
        
        
 <% }%>


   <%if(msg !=null && !msg.isEmpty()) {%>
<h3 style="color: green" align="center"><%= msg %></h3>
<% } %>
 <%if(errMsg !=null && !errMsg.isEmpty()) {%>
<h3 style="color: red"><%= errMsg %></h3>
<% } %>
<script src="./jquery-3.4.1.js"></script>
<script src="./js/bootstrap.min.js"></script>
</body>
</html>

