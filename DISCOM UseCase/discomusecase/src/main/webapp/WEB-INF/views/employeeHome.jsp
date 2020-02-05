<%@page import="com.bcits.discomusecase.beans.BillHistory"%>
<%@page import="java.util.List"%>
<%@page import="com.bcits.discomusecase.beans.ConsumersMasterBean"%>
<%@page import="com.bcits.discomusecase.beans.EmployeeMaster"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <% String msg=(String) request.getAttribute("msg");
     String errMsg=(String) request.getAttribute("errMsg"); 
     List<ConsumersMasterBean> consumersMasterBeanList=(List<ConsumersMasterBean>) request.getAttribute("consumerDetails");
     EmployeeMaster employeeMaster=(EmployeeMaster) request.getAttribute("employeeDetails");
     List<ConsumersMasterBean> consumersBillGenerationList=(List<ConsumersMasterBean>) request.getAttribute("consumerBillDetails"); 
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
  <title>Employee Home</title>
      <link rel="stylesheet" href="${css}/consumerSignup.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"  />
    <link rel="stylesheet" href="${css}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/all.css">
</head>

<%-- <body background="${images}/Pylons_Main.jpg" style="background-size:cover;background-position: center; 
background-repeat: no-repeat; 
background-size: cover; height: 724px;"> --%>

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
         <a href="" class="btn btn-outline-success my-2 my-sm-0"style="border:1px solid">Logout</a>
        </form>
</div>
</nav>

<!-- <div style="margin-top: 50px">
    <a href="../employee/employeeConsumerDetails" class="btn btn-primary btn-lg active" role="button" aria-pressed="true" style="width: 100%;background-color: blue;color: white">Consumer Details</a>
    <a href="../consumer/getBillHistory" role="button" class="btn btn-info"style="width: 100%;color :white; font-size: 20px ">Bill History</a>
    <a href="./getCurrentBill" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true" style="width: 100%">Current Bill</a>
  </div> -->
  
  <div class="row" style="margin-top: 200px;">
  <div class="col-3" >
    <div class="list-group" id="list-tab" role="tablist" >
     
      <a class="list-group-item list-group-item-action"style="background-color: aqua;color: black;font-size: 20px" id="list-profile-list" data-toggle="list" href="../employee/employeeConsumerDetails" role="tab" aria-controls="profile">Consumer Details</a>
      <a class="list-group-item list-group-item-action" style="background-color: aqua;color: black;font-size: 20px"id="list-messages-list" data-toggle="list" href="../consumer/getBillHistory" role="tab" aria-controls="messages">Bill History</a>
      <a class="list-group-item list-group-item-action" style="background-color: aqua;color: black;font-size: 20px"id="list-settings-list" data-toggle="list" href="" role="tab" aria-controls="settings">Month Bill Collection</a>
      <a class="list-group-item list-group-item-action"style="background-color: aqua;color: black;font-size: 20px" id="list-settings-list" data-toggle="list" href="../employee/consumerBillGeneration" role="tab" aria-controls="settings">Month Bill Generation</a>
    </div>
  </div>
 <%if (employeeMaster != null) { %>
       <div >
           <table style="margin-left: 400px;font-size: 20px;border: 1px" >
           <h1 style="margin-left: 400px;color:  navy">Employee Details</h1>
              <tr style="margin-top:  70px">
                 <th>Emoployee Name</th>
               
                <td> <%= employeeMaster.getEmpName() %></td>
              </tr>
               <tr>
                 <th>Employee Id</th>
                 
                <td> <%= employeeMaster.getEmpId() %></td>
              </tr>
               <tr>
                 <th>Designation</th>
                 
                <td> <%= employeeMaster.getDesignation() %></td>
              </tr>
              <tr>
                 <th>Region</th>
                 
                <td> <%= employeeMaster.getRegion() %></td>
              </tr>
              
           </table>
       
       </div>
   <% }%>



  <%if(consumersMasterBeanList != null){ %>
  
   <table style="margin-left: 450px;font-size: 20px;margin-top : -150px;border: 1px;width: 70%" >
    <h1 style="margin-left: 300px;color: navy">Consumer Details</h1>
     <thead style="background: navy;color: white">
        <tr style="height: 35px">
           <th>SN No.</th>
           <th>RrNumber</th>
           <th>Name </th>
           <th>Region</th>  
           <th>Consumer Type</th>     
           <th>Address</th>   
           <th>Mobile Number</th> 
           <th>Email</th> 
           <th>City</th> 
           <th>Pincode</th> 
           
        </tr>
     </thead>
     <tbody>
         
        <%int i=1 ; for(ConsumersMasterBean consumerInfo: consumersMasterBeanList)  {%>
          
           <tr>
              
              <td>    <%= i %>   </td>
              <td><%= consumerInfo.getRrNumber() %></td>
              <td><%= consumerInfo.getFirstName() %></td>
              <td><%= consumerInfo.getRegion() %></td>
              <td><%= consumerInfo.getConsumerType() %></td>  
              <td><%= consumerInfo.getAddress1() %></td>
              <td><%= consumerInfo.getMobileNumber() %></td>
              <td><%= consumerInfo.getEmail() %></td>
              <td><%= consumerInfo.getCity() %></td>
              <td><%= consumerInfo.getPinCode() %></td>      
              <% i++;%>
           </tr>
          
        <%} %>
     </tbody>
   </table>
   <% } %>
   
     <%if(consumersBillGenerationList != null){ %>
  
   <table style="margin-left: 450px;font-size: 20px;margin-top : -150px;border: 1px;width: 70%" >
    <h1 style="margin-left: 300px;color: navy">Consumer Bill Pendings</h1>
     <thead style="background: navy;color: white">
        <tr style="height: 35px">
           <th>SN No.</th>
           <th>RrNumber</th>
           <th>Name </th>
           <th>Region</th>  
           <th>Mobile Number</th> 
           <th>Email</th> 
           <th style="color: green;">Generate Bill</th>
           
        </tr>
     </thead>
     <tbody>
         
        <%int i=1 ; for(ConsumersMasterBean consumerInfo: consumersBillGenerationList)  {%>
          
           <tr>
              
              <td>    <%= i %>   </td>
              <td><%= consumerInfo.getRrNumber() %></td>
              <td><%= consumerInfo.getFirstName() %></td>
              <td><%= consumerInfo.getRegion() %></td>
              <td><%= consumerInfo.getMobileNumber() %></td>
              <td><%= consumerInfo.getEmail() %></td>
              <td><a href="../employee/getBillInputDetails?rrNumber=<%=consumerInfo.getRrNumber()%>">Generate Bill</a></td>
              <% i++;%>
           </tr>
          
        <%} %>
     </tbody>
   </table>
  <%} %>
  
  <%if(msg !=null && !msg.isEmpty()) {%>
<h3 style="color: green"><%= msg %></h3>
<% } %>
 <%if(errMsg !=null && !errMsg.isEmpty()) {%>
<h3 style="color: green"><%= errMsg %></h3>
<% } %>


</body>
</html>