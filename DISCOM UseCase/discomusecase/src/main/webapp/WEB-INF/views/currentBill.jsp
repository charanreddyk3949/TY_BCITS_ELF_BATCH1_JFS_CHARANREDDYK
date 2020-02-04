<%@page import="com.bcits.discomusecase.beans.ConsumersMasterBean"%>
<%@page import="com.bcits.discomusecase.beans.CurrentBill"%>
<%@page import="com.bcits.discomusecase.beans.BillHistory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String msg=(String) session.getAttribute("msg");
       String errMsg=(String) session.getAttribute("errMsg"); 
       CurrentBill currentBill=(CurrentBill)request.getAttribute("currentBill");
       ConsumersMasterBean consumersMasterBean=(ConsumersMasterBean)request.getAttribute("consumerMasterBean");
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
  <%if (currentBill != null) { %>
       <div >
           <table style="margin-left: 600px;font-size: 20px" >
              <tr>
                 <th>RR Number</th>
                 <td>:</td>
                <td> <%= currentBill.getRrNumber() %></td>
              </tr>
              <tr>
                 <th>Consumer Name</th>
                 <td>:</td>
                <td> <%= consumersMasterBean.getFirstName() %></td>
              </tr>
              <tr>
                 <th>Region</th>
                 <td>:</td>
                <td> <%= consumersMasterBean.getRegion() %></td>
              </tr>
               
               <tr>
                 <th>Initial Reading</th>
                 <td>:</td>
                <td> <%= currentBill.getInitialReading() %></td>
              </tr>
              <tr>
                 <th>Present reading</th>
                 <td>:</td>
                <td> <%= currentBill.getInitialReading() %></td>
              </tr>
              <tr>
                 <th>Units Consumed</th>
                 <td>:</td>
                <td> <%= currentBill.getConsumption() %></td>
              </tr>
              <tr>
                 <th>Due date</th>
                 <td>:</td>
                <td> <%= currentBill.getDueDate() %></td>
              </tr>
             
           </table>
       
       </div>
   <% }%>
 
  
  <div style="margin-top: 50px">
    <a href="#" class="btn btn-primary btn-lg active" role="button" aria-pressed="true" style="width: 100%;background-color: blue;color: white">Consumption History</a>
    <a href="#" role="button" class="btn btn-info"style="width: 100%;color :white; font-size: 20px ">Bill History</a>
    <a href="../consumer/getCurrentBill" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true" style="width: 100%">Current Bill</a>
  </div>
  <%if(msg !=null && !msg.isEmpty()) {%>
 <h3 style="color: green"><%= msg %></h3>
 <% } %>

<% if(errMsg !=null && !errMsg.isEmpty()) {%>
<h3 style="color: red ;padding-left:550px"><%= errMsg %></h3>
<% } %>
</body>
</html>