
<%@page import="com.bcits.discomusecase.beans.MonthlyConsumption"%>
<%@page import="com.bcits.discomusecase.beans.CurrentBill"%>
<%@page import="java.util.List"%>
<%@page import="com.bcits.discomusecase.beans.BillHistory"%>
<%@page import="com.bcits.discomusecase.beans.ConsumersMasterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% String msg=(String) session.getAttribute("msg");
       String errMsg=(String) session.getAttribute("errMsg"); 
       ConsumersMasterBean consumersMasterBean=(ConsumersMasterBean) session.getAttribute("consumerDetails");
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
      <a class="nav-link" style="color: aqua;padding-left: 100px;font-size: 20px;" href="../consumer/updateConsumerForm">Update Consumer</a>
    </li>
</ul>
<form class="form-inline my-2 my-lg-0">
      <a href="../consumer/logout" class="btn btn-outline-success my-2 my-sm-0"style="border:1px solid">Logout</a>
   </form>
</div>
</nav>
  <%if (consumersMasterBean != null) { %>
       <div >
           <table style="margin-left: 600px;font-size: 20px" >
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
 
  
  <div style="margin-top: 50px">
    <a href="../consumer/getMontlyConsumptionList" class="btn btn-primary btn-lg active" role="button" aria-pressed="true" style="width: 100%;background-color: blue;color: white">Monthly Consumption</a>
    <a href="../consumer/getBillHistory" role="button" class="btn btn-info"style="width: 100%;color :white; font-size: 20px ">Bill History</a>
    <a href="./getCurrentBill" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true" style="width: 100%">Current Bill</a>
    <a href="../consumer/paymentPage" role="button" class="btn btn-info"style="width: 100%;color :white; font-size: 20px ">Online Payment</a>
  </div>
  
  <% if(billData != null) { %>
       <div align="center">
           <table border="1" style="width: 70%">
              <tr style="background: navy; color: white">
                 <th>RR Number</th>
                 <th>Date</th>
                 <th>Bill Amount</th>
                 <th>Units</th>
                 
              </tr>
              <%for(BillHistory billDetails :billData) { %>
              <tr>
                   <td><%= billDetails.getBillHistoryPK().getRrNumber() %></td>
                   <td><%= billDetails.getBillHistoryPK().getDate() %></td>
                   <td><%= billDetails.getBillAmount() %></td>
                   <td><%= billDetails.getUnitsConsumed() %></td>
              </tr>
              <% } %>
           </table>
       </div>
    <% } %>  
    
    
    
  
  
   <%if (currentBill != null) { %>
       <div >
           <table style="margin-left: 600px;font-size: 20px" >
              <tr>
                 <th>RR Number</th>
                 <td>:</td>
                <td> <%= currentBill.getRrNumber() %></td>
              </tr>
              <%-- <tr>
                 <th>Consumer Name</th>
                 <td>:</td>
                <td> <%= consumersMasterBean.getFirstName() %></td>
              </tr>
              <tr>
                 <th>Region</th>
                 <td>:</td>
                <td> <%= consumersMasterBean.getRegion() %></td>
              </tr> --%>
               
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
                 <th>Due date</th>
                 <td>:</td>
                <td> <%= currentBill.getDueDate() %></td>
              </tr>
             
           </table>
       
       </div>
   <% }%>
 
 
 
 <% if(monthlyConsumptions != null) { %>
       <div align="center">
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
                   <td><%= consumption.getInitialReading()%></td>
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