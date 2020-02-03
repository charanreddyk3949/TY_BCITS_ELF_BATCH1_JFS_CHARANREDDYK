<%@page import="com.bcits.discomusecase.beans.PaymentDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
  <%  String errMsg=(String) session.getAttribute("errMsg"); 
       PaymentDetails paymentDetails=(PaymentDetails) session.getAttribute("consumerDetails");
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
      <a class="nav-link" style="color: aqua;padding-left: 100px;font-size: 20px;" href="/employeelogin/employeelogin.html">Employee Portal</a>
    </li>
</ul>
<form class="form-inline my-2 my-lg-0">
         <a href="../consumer/logout" class="btn btn-outline-success my-2 my-sm-0"style="border:1px solid">Logout</a>
        </form>
</div>
</nav>
  <%if (paymentDetails != null) { %>
       <div >
           <table style="margin-left: 600px;font-size: 20px" >
              <tr>
                 <th>Transaction Number</th>
                 <td>:</td>
                <td> <%= paymentDetails.getTxnNumber() %></td>
              </tr>
               <tr>
                 <th>Transaction Date</th>
                 <td>:</td>
                <td> <%= paymentDetails.getTxnDate() %></td>
              </tr>
              <tr>
                 <th>RR Number</th>
                 <td>:</td>
                <td> <%= paymentDetails.getRrNumber() %></td>
              </tr>
              <tr>
                 <th>Transaction Type</th>
                 <td>:</td>
                <td> <%= paymentDetails.getTxnType() %></td>
              </tr>
              <tr>
                 <th>Amount Payable</th>
                 <td>:</td>
                <td> <%= paymentDetails.getAmtPaid() %></td>
              </tr>
              <tr>
                 <th>Transaction Amount</th>
                 <td>:</td>
                <td> <%= paymentDetails.getTxnAmount() %></td>
              </tr>
              <tr>
                 <th>Amount Payable</th>
                 <td>:</td>
                <td> <%= paymentDetails.getTxnStatus() %></td>
              </tr>
              
           </table>
       
       </div>
   <% }%>
 
 

<% if(errMsg !=null && !errMsg.isEmpty()) {%>
<h3 style="color: red ;padding-left:550px"><%= errMsg %></h3>
<% } %>
</body>
</html>