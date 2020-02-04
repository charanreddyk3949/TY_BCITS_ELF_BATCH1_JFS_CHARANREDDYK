<%@page import="com.bcits.discomusecase.beans.BillHistory"%>
<%@page import="java.util.List"%>
<%@page import="com.bcits.discomusecase.beans.ConsumersMasterBean"%>
<%@page import="com.bcits.discomusecase.beans.EmployeeMaster"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <% String msg=(String) request.getAttribute("msg");
       String errMsg=(String) request.getAttribute("errMsg"); 
      List<ConsumersMasterBean> consumersMasterBeanList=(List<ConsumersMasterBean>) request.getAttribute("consumerDetails");
     EmployeeMaster employeeMaster=(EmployeeMaster) request.getAttribute("EmployeeDetails");
      
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
         <a href="" class="btn btn-outline-success my-2 my-sm-0"style="border:1px solid">Logout</a>
        </form>
</div>
</nav>

<div style="margin-top: 50px">
    <a href="../employee/employeeConsumerDetails" class="btn btn-primary btn-lg active" role="button" aria-pressed="true" style="width: 100%;background-color: blue;color: white">Consumer Details</a>
    <a href="../consumer/getBillHistory" role="button" class="btn btn-info"style="width: 100%;color :white; font-size: 20px ">Bill History</a>
    <a href="./getCurrentBill" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true" style="width: 100%">Current Bill</a>
  </div>
 <%if (employeeMaster != null) { %>
       <div >
           <table style="margin-left: 600px;font-size: 20px" >
           <h1 style="margin-left: 600px;">Employee Details</h1>
              <tr style="margin-top:  70px">
                 <th>Emoployee Name</th>
                 <td>:</td>
                <td> <%= employeeMaster.getEmpName() %></td>
              </tr>
               <tr>
                 <th>Employee Id</th>
                 <td>:</td>
                <td> <%= employeeMaster.getEmpId() %></td>
              </tr>
               <tr>
                 <th>Designation</th>
                 <td>:</td>
                <td> <%= employeeMaster.getDesignation() %></td>
              </tr>
              <tr>
                 <th>Region</th>
                 <td>:</td>
                <td> <%= employeeMaster.getRegion() %></td>
              </tr>
              <%-- <tr>
                 <th>Address</th>
                 <td>:</td>
                <td> <%= consumersMasterBean.getAddress2() %></td>
              </tr>
              <tr>
                 <th>Region</th>
                 <td>:</td>
                <td> <%= consumersMasterBean.getRegion() %></td>
              </tr> --%>
          
              
           </table>
       
       </div>
   <% }%>



  <%if(consumersMasterBeanList != null){ %>
   <table border="1" style="width: 80%">
     <thead style="background: navy;color: white">
        <tr style="height: 35px">
           <th>RrNumber</th>
           <th>Name </th>
           <th>Region</th>
           <th>Address</th>
           <th>Mobile Number</th>
           
        </tr>
     </thead>
     <tbody>
        <% for(ConsumersMasterBean consumerInfo: consumersMasterBeanList) {%>
           <tr>
              <td><%= consumerInfo.getRrNumber() %></td>
              <td><%= consumerInfo.getFirstName() %></td>
              <td><%= consumerInfo.getRegion() %></td>
              <td><%= consumerInfo.getAddress1() %></td>
               <td><%= consumerInfo.getMobileNumber() %></td>
     
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