<%@page import="com.bcits.discomusecase.beans.ConsumerSupportRequest"%>
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
      
     List<ConsumerSupportRequest> requestList=(List<ConsumerSupportRequest>) request.getAttribute("consumerRequestList");

     
     List<BillHistory> billList=(List<BillHistory>) request.getAttribute("billHistory");
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
<body>
<body background="${images}/bulb1.jpg" style="background-size:cover;background-position: center; 
background-repeat: no-repeat; 
background-size: cover; height: 724px;">

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
</ul>
<form class="form-inline my-2 my-lg-0">
         <a href="../employee/employeeLogout" class="btn btn-outline-success my-2 my-sm-0"style="border:1px solid">Logout</a>
        </form>
</div>
</nav>
  <div align="center" style="background-color: aqua;color: black;height: 45px"><h2>Welcome to Employee Home</h2></div>
  <div class="row" style="margin-top: 200px;">
  <div class="col-3" >
    <div class="list-group" id="list-tab" role="tablist" >     
       <a class="list-group-item list-group-item-action"style="background-color: aqua;color: white;font-size: 20px" id="list-profile-list" data-toggle="list" href="../employee/getEmployeeDetails" role="tab" aria-controls="profile">Employee Details</a>
    
      <a class="list-group-item list-group-item-action"style="background-color: green;color: white;font-size: 20px" id="list-profile-list" data-toggle="list" href="../employee/employeeConsumerDetails" role="tab" aria-controls="profile">Consumer Details</a>
      <a class="list-group-item list-group-item-action" style="background-color: blue;color: white;font-size: 20px"id="list-messages-list" data-toggle="list" href="../employee/getBillHistory" role="tab" aria-controls="messages">Bill History</a>
      <a class="list-group-item list-group-item-action"style="background-color: aqua;color: white;font-size: 20px" id="list-settings-list" data-toggle="list" href="../employee/consumerBillGeneration" role="tab" aria-controls="settings">Month Bill Generation</a>
     <a class="list-group-item list-group-item-action" style="background-color: green;color: white;font-size: 20px"id="list-settings-list" data-toggle="list" href="../employee/displayRequests" role="tab" aria-controls="settings">View Consumer Requests</a>
      
    </div>
  </div>
 <%if (employeeMaster != null) { %>
       <div >
          <table style="margin-left: 400px;font-size: 20px;border: 1px;color: white;" >
           <h1 style="margin-left: 400px;color:  navy">Employee Details</h1>
              <tr style="margin-top:  70px">
                 <th>Emoployee Name</th>
                 <th>:</th>
                <td> <%= employeeMaster.getEmpName() %></td>
              </tr>
               <tr>
                 <th>Employee Id</th>
                 <th>:</th>
                <td> <%= employeeMaster.getEmpId() %></td>
              </tr>
               <tr>
                 <th>Designation</th>
                 <th>:</th>
                <td> <%= employeeMaster.getDesignation() %></td>
              </tr>
              <tr>
                 <th>Region</th>
                 <th>:</th>
                <td> <%= employeeMaster.getRegion() %></td>
              </tr>
              
           </table>
       
       </div>
   <% }%>



  <%if(consumersMasterBeanList != null){ %>
   <h1 style="margin-left: 300px;color: navy;margin-top : -40px;">Consumer Details</h1>
   <table style="margin-left: 450px;font-size: 20px;margin-top : -250px;border: 1px;width: 70%;color:white;background: black" >
   
     <thead style="background: navy;color: white">
        <tr style="height: 35px;text-align: center;">
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
          
           <tr style="text-align: center;">
              
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
   
  <%if(consumersBillGenerationList != null ){ %>
     <table style="margin-left: 450px;font-size: 20px;margin-top : -200px;border: 1px;width: 70%;background-color: black;color:white" >
    <h1 style="margin-left: 300px;color: navy">Consumer Bill Pendings</h1>
     <thead style="background: navy;color: white">
        <tr style="height: 35px;text-align: center;">
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
              
              <td style="text-align: center;">    <%= i %>   </td>
              <td><%= consumerInfo.getRrNumber() %></td>
              <td><%= consumerInfo.getFirstName() %></td>
              <td><%= consumerInfo.getRegion() %></td>
              <td><%= consumerInfo.getMobileNumber() %></td>
              <td><%= consumerInfo.getEmail() %></td>
              
              
              <td style="height: 50px;width: 150px"><a href="../employee/getBillInputDetails?rrNumber=<%=consumerInfo.getRrNumber()%>" style="background-color: aqua;">Generate Bill</a></td>
              <% i++;%>
           </tr>
          
        <%} %>
     </tbody>
   </table>
  <%} %>
  
  
  <% if(billList != null) { %>
       <div align="center" style="margin-left: 200px;">
       <h3 style="color: navy">Bill History Details</h3>
           <table border="1" style="width: 1000px;background-color: black;color:white">
              <tr style="background: navy; color: white;height: 50px;font-size: 20px;text-align: center">
                 <th>RR Number</th>
                 <th>Date</th>
                 <th>Bill Amount</th>
                 <th>Units</th>
                 <th>Status</th>
                 
                 
              </tr>
              <%for(BillHistory billDetails :billList) { %>
              <tr style="height: 50px;text-align: center;">
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
  
  
  <% if(requestList != null) { %>
       <div align="center" style="margin-left: 60px;color: white;">
       <h1 style="color: navy">Consumer Request Details</h1>
           <table border="1" style="width: 1200px;background-color: black">
              <tr style="background: navy; color: white;height: 35px;font-size: 20px">
                 <th>SN No.</th>
                 <th>RR Number</th>
                 <th>Email</th>
                 <th>Date</th>
                 <th>Region</th>
                 <th>Request</th>
                 <th>Response</th>
                 <th>Send Response</th>
                 
              </tr>
              
              <% int i=1; for(ConsumerSupportRequest consumerRequest :requestList) { %>
              <form action="../employee/updateResponse" method="post">
                <input type="text" class="form-control" id="rrNumber"name="rrNumber" value="<%=consumerRequest.getConsumerSupportRequestPK().getRrNumber() %>" hidden="true" >
               <input type="text" class="form-control" id="date"name="date" value="<%=consumerRequest.getConsumerSupportRequestPK().getDate() %>" hidden="true">
                
              <tr style="height: 35px;font-size: 17px">
                   <td>    <%= i %>   </td>
                   <td><%= consumerRequest.getConsumerSupportRequestPK().getRrNumber() %></td>
                   <td><%= consumerRequest.getEmail() %></td>
                   <td><%= consumerRequest.getConsumerSupportRequestPK().getDate() %></td>
                   <td><%= consumerRequest.getRegion() %></td>
                   <td><%= consumerRequest.getText() %></td>
                   <td><input type="text" class="form-control" id="response" name="response" style="height: 50px;" value="<%=consumerRequest.getResponse() %>"></td>
                  <td><button style="height: 50px;width: 120px;background-color: aqua;color: blue">submit</button></td>
                    <% i++;%>
              </tr>
              </form>
              <% } %>
            
           </table>
       </div>
    <% } %>  
  
  <%if(msg !=null && !msg.isEmpty()) {%>
<h3 style="color: green; margin-left: 300px;"><%= msg %></h3>
<% } %>
 <%if(errMsg !=null && !errMsg.isEmpty()) {%>
<h3 style="color: red;text-align:  center;"><%= errMsg %></h3>
<% } %>


</body>
</html>