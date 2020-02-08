
<%@page import="com.bcits.discomusecase.beans.MonthlyConsumption"%>
<%@page import="com.bcits.discomusecase.beans.CurrentBill"%>
<%@page import="java.util.List"%>
<%@page import="com.bcits.discomusecase.beans.BillHistory"%>
<%@page import="com.bcits.discomusecase.beans.ConsumersMasterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% String msg=(String) request
    .getAttribute("msg");
       String errMsg=(String) request.getAttribute("errMsg"); 
       ConsumersMasterBean consumersMasterBean=(ConsumersMasterBean) request.getAttribute("consumerDetails");
       List<BillHistory> billData=(List<BillHistory>) request.getAttribute("billHistory");
       CurrentBill currentBill=(CurrentBill) request.getAttribute("currentBillDetails");
      List<MonthlyConsumption> monthlyConsumptions=(List<MonthlyConsumption>)request.getAttribute("monthlyConsumptionList");
    
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
  <li class="nav-item">
    <a class="nav-link" style="color: aqua;padding-left: 100px;font-size: 20px;" href="../consumer/consumerLogin">Consumer Portal</a>
  </li>
  <li class="nav-item">
      <a class="nav-link" style="color: aqua;padding-left: 100px;font-size: 20px;" href="../consumer/updateConsumerForm">Update Consumer</a>
    </li>
</ul>
<form class="form-inline my-2 my-lg-0">
      <a href="../consumer/logout" class="btn btn-outline-success my-2 my-sm-0"style="border:1px solid">Logout</a>
   </form>
</div>
</nav>
    <body background="${images}/bulb1.jpg" style="background-size:cover;background-position: center; 
          background-repeat: no-repeat; 
          background-size: cover; height: 724px;"/>
 
  
  <!-- <div style="margin-top: 50px">
    <a href="../consumer/getMontlyConsumptionList" class="btn btn-primary btn-lg active" role="button" aria-pressed="true" style="width: 100%;background-color: blue;color: white">Monthly Consumption</a>
    <a href="../consumer/getBillHistory" role="button" class="btn btn-info"style="width: 100%;color :white; font-size: 20px ">Bill History</a>
    <a href="./getCurrentBill" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true" style="width: 100%">Current Bill</a>
   <a href="../consumer/consumerQueriesForm" role="button" class="btn btn-info"style="width: 100%;color :white; font-size: 20px ">Add Comments</a>  
  </div> -->
  
  <div class="col-3" style="margin-top: 200px" >
    <div class="list-group" id="list-tab" role="tablist" >     
      <a class="list-group-item list-group-item-action"style="background-color: aqua ;color: white;font-size: 20px" id="list-profile-list" data-toggle="list" href="../consumer/getConsumer" role="tab" aria-controls="profile">Consumer Details</a>
<!--       <a class="list-group-item list-group-item-action"style="background-color: green ;color: white;font-size: 20px" id="list-profile-list" data-toggle="list" href="../consumer/getMontlyConsumptionList" role="tab" aria-controls="profile">Monthly Consumption</a>
 -->      <a class="list-group-item list-group-item-action" style="background-color: navy;color: white;font-size: 20px"id="list-messages-list" data-toggle="list" href="../consumer/getBillHistory" role="tab" aria-controls="messages">Bill History</a>
      <a class="list-group-item list-group-item-action" style="background-color: aqua;color: white;font-size: 20px"id="list-settings-list" data-toggle="list" href="./getCurrentBill" role="tab" aria-controls="settings">Current Bill</a>
      <a class="list-group-item list-group-item-action"style="background-color: navy;color: white;font-size: 20px" id="list-settings-list" data-toggle="list" href="../consumer/consumerQueriesForm" role="tab" aria-controls="settings">Add Comments</a>
    </div>
  </div>
  
  <%if (consumersMasterBean != null) { %>
       <div align="center" style="margin-top: -300px;color: white;">
       <h3 style="color: blue;">Consumer Details</h3>
           <table style="font-size: 20px ;border:2px solid white;" >
              <tr>
                 <th>RR Number</th>
                 <td>:</td>
                <td> <%= consumersMasterBean.getRrNumber() %></td>
              </tr>
               <tr>
                 <th>Name</th>
                 <td>:</td>
                <td> <%= consumersMasterBean.getFirstName() %></td>
              </tr>
               <tr>
                 <th>Email</th>
                 <td>:</td>
                <td> <%= consumersMasterBean.getEmail() %></td>
              </tr>
              <tr>
                 <th>Mobile Number</th>
                 <td>:</td>
                <td> <%= consumersMasterBean.getMobileNumber() %></td>
              </tr>
              <tr>
                 <th>Address</th>
                 <td>:</td>
                <td> <%= consumersMasterBean.getAddress2() %></td>
              </tr>
              <tr>
                 <th>Region</th>
                 <td>:</td>
                <td> <%= consumersMasterBean.getRegion() %></td>
              </tr>
              <tr>
                 <th>State</th>
                 <td>:</td>
                <td> <%= consumersMasterBean.getState() %></td>
              </tr>
              
           </table>
       
       </div>
   <% }%>
  
  <% if(billData != null) { %>
       <div align="center" style="margin-left: 300px;margin-top: -300px;">
       <h3 style="color: blue">Bill History Details</h3>
           <table border="1" style="width: 70%;background-color: black;color: white">
              <tr style="background: navy; color: white">
                 <th>RR Number</th>
                 <th>Date</th>
                 <th>Bill Amount</th>
                 <th>Units</th>
                 <th>Status</th>
                 
              </tr>
              <%for(BillHistory billDetails :billData) { %>
              <tr>
                   <td><%= billDetails.getBillHistoryPK().getRrNumber() %></td>
                   <td><%= billDetails.getBillHistoryPK().getDate() %></td>
                   <td><%= billDetails.getBillAmount() %></td>
                   <td><%= billDetails.getUnitsConsumed() %></td>
                   <td><%= billDetails.getStatus() %></td>
              </tr>
              <% } %>
           </table>
       </div>
    <% } %>  
    
    
    
  
  
   <%if (currentBill != null) { %>
       <div align="center" style="margin-top: -200px;color: white;">
       <h3 style="color: blue">Current Bill Details</h3>
           <table style="font-size: 20px;" >
              <tr>
                 <th>RR Number</th>
                 <td>:</td>
                <td> <%= currentBill.getRrNumber() %></td>
              </tr>
              
               <tr>
                 <th>Initial Reading</th>
                 <td>:</td>
                <td> <%= currentBill.getInitialReading() %></td>
              </tr>
              <tr>
                 <th>Present reading</th>
                 <td>:</td>
                <td> <%= currentBill.getPresentReading() %></td>
              </tr>
              <tr>
                 <th>Units Consumed</th>
                 <td>:</td>
                <td> <%= currentBill.getConsumption() %></td>
              </tr>
              
              <tr>
                 <th>Bill Amount</th>
                 <td>:</td>
                <td> <%= currentBill.getBillAmount() %></td>
              </tr>
              <tr>
                 <th>Due date</th>
                 <td>:</td>
                <td> <%= currentBill.getDueDate() %></td>
              </tr>
             
           </table>
               <a href="../consumer/paymentPage" role="button" class="btn btn-info"style="width: 200px;color :white; font-size: 20px;margin-left: 00px ">Online Payment</a>
       
       </div>
   <% }%>
 
 
 
 <% if(monthlyConsumptions != null) { %>
       <div align="center" style="margin-left: 400px; margin-top: -300px">
        <h3 style="color: blue">Monthly Consumption Details</h3>
           <table border="1" style="width: 70%">
              <tr style="background: navy; color: white">
                 <th>RR Number</th>
                 <th>Initial Date</th>
                 <th>Final Date</th>
                 <th>Initial Reading</th>
                 <th>Final Reading</th>
                 <th>Consumption Units</th>
                 
                 
              </tr>
              <%for(MonthlyConsumption consumption :monthlyConsumptions) { %>
              <tr>
                   <td><%= consumption.getMonthlyConsumption().getRrNumber() %></td>
                   <td><%= consumption.getMonthlyConsumption().getInitialDate() %></td>
                   <td><%= consumption.getFinalDate() %></td>
                   <td><%= consumption.getInitialReading() %></td>
                   <td><%= consumption.getFinalReading() %></td>
                   <td><%= consumption.getConsumptionUnits() %></td>
              </tr>
              <% } %>
           </table>
       </div>
    <% } %> 
  
  
  <%if(msg !=null && !msg.isEmpty()) {%>
<h3 style="color: green"><%= msg %></h3>
<% } %>

<% if(errMsg !=null && !errMsg.isEmpty()) {%>
<h3 style="color: red ;padding-left:550px"><%= errMsg %></h3>
<% } %>
</body>
</html>