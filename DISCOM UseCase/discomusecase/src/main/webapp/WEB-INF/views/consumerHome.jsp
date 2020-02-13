
<%@page import="com.bcits.discomusecase.beans.ConsumerSupportRequest"%>
<%@page import="com.bcits.discomusecase.beans.PaymentDetails"%>
<%@page import="com.bcits.discomusecase.beans.MonthlyConsumption"%>
<%@page import="com.bcits.discomusecase.beans.CurrentBill"%>
<%@page import="java.util.List"%>
<%@page import="com.bcits.discomusecase.beans.BillHistory"%>
<%@page import="com.bcits.discomusecase.beans.ConsumersMasterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% String msg=(String) request.getAttribute("msg");
       String errMsg=(String) request.getAttribute("errMsg"); 
       String paymentMsg=(String) request.getAttribute("paymentSuccessMsg");
       ConsumersMasterBean consumersMasterBean=(ConsumersMasterBean) request.getAttribute("consumerDetails");
       List<BillHistory> billData=(List<BillHistory>) request.getAttribute("billHistory");
       CurrentBill currentBill=(CurrentBill) request.getAttribute("currentBillDetails");
       List<MonthlyConsumption> monthlyConsumptions=(List<MonthlyConsumption>)request.getAttribute("monthlyConsumptionList");
       PaymentDetails paymentDetails=(PaymentDetails) request.getAttribute("paymentInfo");
       List<ConsumerSupportRequest> responseList=(List<ConsumerSupportRequest>) request.getAttribute("supportRequestDetails");
    
       List<BillHistory> pendingBillData=(List<BillHistory>) request.getAttribute("PendingBills");
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
</ul>
<form class="form-inline my-2 my-lg-0">
      <a href="../consumer/logout" class="btn btn-outline-success my-2 my-sm-0"style="border:1px solid">Logout</a>
   </form>
</div>
</nav>
    <body background="${images}/bulb1.jpg" style="background-size:cover;background-position: center; 
          background-repeat: no-repeat; 
          background-size: cover; height: 724px;"/>
 
    <div align="center" style="background-color: aqua;color: black;height: 45px"><h2>Welcome to Consumer Home</h2></div>
  
   <%if(paymentMsg !=null && !paymentMsg.isEmpty()) {%>
     <h1 style="color: green;margin-left: 450px;margin-top: 50px;"><%= paymentMsg %></h1>
   <% } %>
  
  <div class="col-3" style="margin-top: 150px" >
    <div class="list-group" id="list-tab" role="tablist" >     
      <a class="list-group-item list-group-item-action"style="background-color: aqua ;color: white;font-size: 20px" id="list-profile-list" data-toggle="list" href="../consumer/getConsumer" role="tab" aria-controls="profile">Consumer Details</a>
      <a class="list-group-item list-group-item-action"style="background-color: green ;color: white;font-size: 20px" id="list-profile-list" data-toggle="list" href="../consumer/updateConsumerForm" role="tab" aria-controls="profile">Update Consumer</a>     
      <a class="list-group-item list-group-item-action" style="background-color: navy;color: white;font-size: 20px"id="list-messages-list" data-toggle="list" href="../consumer/getBillHistory" role="tab" aria-controls="messages">Bill History</a>
      <a class="list-group-item list-group-item-action" style="background-color: aqua;color: white;font-size: 20px"id="list-settings-list" data-toggle="list" href="./getCurrentBill" role="tab" aria-controls="settings">Current Bill</a>
      <a class="list-group-item list-group-item-action"style="background-color: green ;color: white;font-size: 20px" id="list-profile-list" data-toggle="list" href="../consumer/paymentDetails" role="tab" aria-controls="profile">Payment Details</a>
      <a class="list-group-item list-group-item-action"style="background-color: navy;color: white;font-size: 20px" id="list-settings-list" data-toggle="list" href="../consumer/consumerQueriesForm" role="tab" aria-controls="settings">Add Comments</a>
      <a class="list-group-item list-group-item-action"style="background-color: aqua;color: white;font-size: 20px" id="list-settings-list" data-toggle="list" href="../consumer/getResponseList" role="tab" aria-controls="settings">See Response</a>
      <a class="list-group-item list-group-item-action"style="background-color: green ;color: white;font-size: 20px" id="list-profile-list" data-toggle="list" href="../consumer/getPendingBillLists" role="tab" aria-controls="profile">Pending Bills</a>     
 
    </div>
  </div>
  
  
  
  <%if (consumersMasterBean != null) { %>
       <div align="center" style="margin-top: -350px;color: white;">
       <h3 style="color: blue;">Consumer Details</h3>
           <table style="font-size: 20px ;border:2px solid white;" >
              <tr >
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
              <tr style="background: navy; color: white;height: 50px;text-align: center">
                 <th>RR Number</th>
                 <th>Date</th>
                 <th>Bill Amount</th>
                 <th>Units</th>
                 <th>Status</th>
                 
              </tr>
              <%for(BillHistory billDetails :billData) { %>
              <tr style="height: 50px;text-align: center">
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





<% if (currentBill != null) { %>
  <div align="center" style="margin-top: -350px; color: white;">
	<h3 style="color: blue">Current Bill Details</h3>
	<table style="font-size: 20px; border: 2px solid white;">
		<tr>
			<th>RR Number</th>
			<td>:</td>
			<td><%=currentBill.getRrNumber()%></td>
		</tr>

		<tr>
			<th>Initial Reading</th>
			<td>:</td>
			<td><%=currentBill.getInitialReading()%></td>
		</tr>
		<tr>
			<th>Present reading</th>
			<td>:</td>
			<td><%=currentBill.getPresentReading()%></td>
		</tr>
		<tr>
			<th>Units Consumed</th>
			<td>:</td>
			<td><%=currentBill.getConsumption()%></td>
		</tr>

		<tr>
			<th>(Previous Bill amounts)+ Bill Amount </th>
			<td>:</td>
			<td><%=currentBill.getBillAmount()%></td>
		</tr>
		<tr>
			<th>Due date</th>
			<td>:</td>
			<td><%=currentBill.getDueDate()%></td>
		</tr>

	</table>

	<a href="../consumer/paymentPage" role="button" class="btn btn-info"style="width: 200px; 
	          color: white; font-size: 20px; margin-left: 00px">OnlinePayment</a>

  </div>
  <% } %>



<% if (monthlyConsumptions != null) { %>
       <div align="center" style="margin-left: 400px; margin-top: -350px">
        <h3 style="color: blue">Monthly Consumption Details</h3>
           <table border="1" style="width: 70%">
              <tr style="background: navy; color: white;height: 50px; text-align: center;">
                 <th>RR Number</th>
                 <th>Initial Date</th>
                 <th>Final Date</th>
                 <th>Initial Reading</th>
                 <th>Final Reading</th>
                 <th>Consumption Units</th>
                 
                 
              </tr >
              <%for(MonthlyConsumption consumption :monthlyConsumptions) { %>
              <tr style="height: 50px;text-align: center;">
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
    
    
    <%if (paymentDetails != null) { %>
       <div align="center" style="margin-left: 70px; margin-top: -350px" >
         <h3 style="color: blue">Payment Details</h3>
           <table style="margin-left: 50px;font-size: 20px;color:white;border:2px solid white;" >
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
  
  
    <% if(responseList != null) { %>
       <div align="center" style="margin-left: 300px;color: white;margin-top: -300px">
       <h3 style="color: navy">Response Details</h3>
           <table border="1" style="width: 1200px;background-color: black">
              <tr style="background: navy; color: white;height: 50px;font-size: 20px;text-align: center;">
                 <th>SN No.</th>
                 <th>RR Number</th>
                 <th>Email</th>
                 <th>Date</th>
                 <th>Region</th>
                 <th>Request</th>
                 <th>Response</th>
               
                 
              </tr>
              
              <% int i=1; for(ConsumerSupportRequest consumerRequest : responseList) { %>
              <tr style="height: 50px;font-size: 17px;text-align: center;">
                   <td>    <%= i %>   </td>
                   <td><%= consumerRequest.getConsumerSupportRequestPK().getRrNumber() %></td>
                   <td><%= consumerRequest.getEmail() %></td>
                   <td><%= consumerRequest.getConsumerSupportRequestPK().getDate() %></td>
                   <td><%= consumerRequest.getRegion() %></td>
                   <td><%= consumerRequest.getText() %></td>
                   <td><%= consumerRequest.getResponse() %></td>
                    <% i++;%>
              </tr>
              </form>
              <% } %>
            
           </table>
       </div>
    <% } %>  
    
    
    
    
    <% if(pendingBillData != null) { %>
       <div align="center" style="margin-left: 300px;color: white;margin-top: -300px">
       <h3 style="color: navy">Pending bills</h3>
           <table border="1" style="width: 1200px;background-color: black">
              <tr style="background: navy; color: white;height: 50px;font-size: 20px;text-align: center;">
                 <th>SN No.</th>
                 <th>RR Number</th>
                 <th>Region</th>
                 <th>BillAmount</th>
                 <th>Status</th>
                 <th>Due Date</th>
                 <th>Generate Bill</th>
               
                 
              </tr>
              
              <% int i=1; for(BillHistory pendingBills : pendingBillData) { %>
              <tr style="height: 50px;font-size: 17px;text-align: center;">
                   <td>    <%= i %>   </td>
                   <td><%= pendingBills.getBillHistoryPK().getRrNumber() %></td>
                   <td><%= pendingBills.getRegion() %></td>
                   <td><%= pendingBills.getUnitsConsumed() %></td>
                   <td><%= pendingBills.getBillAmount() %></td>
                   <td><%= pendingBills.getStatus() %></td>
                   <td><%= pendingBills.getBillHistoryPK().getDate() %></td>
                  <td style="height: 50px;width: 150px"><a href="../employee/getBillInputDetails?rrNumber=
                  <%=pendingBills.getBillHistoryPK().getRrNumber()%>" style="background-color: aqua;">Generate Bill</a></td>
                   
                    <% i++;%>
              </tr>
              </form>
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