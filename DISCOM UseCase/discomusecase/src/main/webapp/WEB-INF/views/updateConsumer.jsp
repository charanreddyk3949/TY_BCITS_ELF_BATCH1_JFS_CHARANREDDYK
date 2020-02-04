<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <% String msg=(String) request.getAttribute("msg");
       String errMsg=(String) request.getAttribute("errMsg");
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

<body background="${images}/Pylons_Main.jpg" style="background-size:cover;background-position: center; background-repeat: no-repeat; background-size: cover; height: 724px;">

<nav id="head" style="background-color: aquamarine; margin-top: -20px;" class="navbar navbar-light bg-light">
  <img id="headImg" src="${images}/discom.png" alt="">
  <form class="form-inline">
      <p id="headText">Discom Power Limited  </p> 
      
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


  <div class="container">
    <div class=" col-10 col-sm-10 col-md-10 col-lg-10 col-xl-10 mt-5">
      
      
      <body background="${images}/power-lines-fields-seen.jpg" style="background-size:cover;background-position: center; background-repeat: no-repeat; 
            background-size: cover; height: 724px;">

           <!--  <form id="consumersignupform"  > -->
             <h1 id="heading">Edit Consumer</h1>
              <form action="../consumer/updateConsumer" method="post">
                <div class="form-row" >
                  <div class="col">
                    <label for="inputEmail4">Name</label>
                    <input type="text" class="form-control"id="firstName" name="firstName" placeholder="First name">
                  </div>
                  <div class="col">
                    <label for="inputEmail4">LastName</label>
                    <input type="text" class="form-control" id="lastName"name="lastName"placeholder="Last name">
                  </div>
                </div>
              <div class="form-row">
                <div class="form-group col-md-12">
                  <label for="inputEmail4">Email</label>
                  <input type="email" class="form-control" id="email"name="email" placeholder="enter email ID">
                </div>
              </div>
              <div class="form-group" style="margin-top: -20px;">
                <label for="inputAddress">Address</label>
                <input type="text" class="form-control" id="address1"name="address1" placeholder="HouseNo.street...">
              </div>
              <div class="form-group"style="margin-top: -20px;">
                <label for="inputAddress2">Address 2</label>
                <input type="text" class="form-control" id="address2"name="address2" placeholder="Apartment...">
              </div>
              <div class="form-row"style="margin-top: -20px;">
                <div class="form-group col-md-6">
                  <label for="inputCity">City</label>
                  <input type="text" class="form-control" id="city"name="city"placeholder="city...">
                </div>
                <div class="form-group col-md-4">
                  <label for="inputState">State</label>
                  <select id="inputState" class="form-control" id="state" name="state" style="height: 25px;font-size:15px;padding-top:0px">
                    <option selected disabled>select state</option>
                    <option>Karnataka</option>
                    <option>Andhra Pradesh</option>
                  </select>
                </div>
                <div class="form-group col-md-2"style="margin-top: 0px;">
                  <label for="inputZip">Pincode</label>
                  <input type="text" class="form-control" id="pinCode" name="pinCode"placeholder="pincode">
                </div>
              </div>
            
                <div class="form-row" style="margin-top: -20px;">
                  <div class="col">
                    <label for="inputEmail4">Region</label>
                    <select id="inputState" class="form-control"id="region" name="region"style="height: 25px;font-size:15px;padding-top:0px">
                      <option selected disabled>select region</option>
                      <option>Banglore North</option>
                      <option>Banglore South</option>
                    </select>
                  </div>
                  <div class="col">
                    <label for="inputEmail4">Consumer Type</label>
                    <select id="inputState" class="form-control"id="consumerType" name="consumerType"style="height: 25px;font-size:15px;padding-top:0px">
                      <option selected disabled>select consumer</option>
                      <option>Residential </option>
                      <option>Commertial</option>
                      <option>Industries</option>
                    </select>
                </div>

              </div>
              <div class="form-group"style="margin-top: 0px;">
                <label for="inputAddress">Meter Number</label>
                <input type="text" class="form-control" id="rrNumber" name="rrNumber" placeholder="enter service/meter number...">
              </div>

             
                <div class="form-row"style="margin-top: -20px;">
                  <div class="form-group col-md-6">
                    <label for="inputpassword">Password</label>
                    <input type="password" class="form-control" id="password"name="password"placeholder="Enter password">
                  </div>
                  <div class="form-group col-md-6"style="margin-top: 0px;">
                    <label for="confirminputPassword4">Confirm Password</label>
                    <input type="password" class="form-control" id="confirmPassword"name="confirmPassword"placeholder="Confirm password">
                  </div>
                </div>

              <div class="form-group"style="margin-top: -20px;">
                <div class="form-check" style="margin-left: 20px;">
                  <input class="form-check-input" type="checkbox" id="gridCheck">
                  <label class="form-check-label" for="gridCheck">
                    Check me out
                  </label>
                </div>
              </div>
              <button id="button" type="submit" class="btn btn-primary" class="form-group col-md-5"style="margin-left: 350px;margin-top: -20px;">Submit</button>
           </form>

        <!--   </form> -->

       
    </div>
  </div>
  
  <%if(msg !=null && !msg.isEmpty()) {%>
<h3 style="color: green"><%= msg %></h3>
<% } %>
 <%if(errMsg !=null && !errMsg.isEmpty()) {%>
<h3 style="color: red; margin-left: 400px"><%= errMsg %></h3>
<% } %>
 
  
  <script src="./jquery-3.4.1.js"></script> 
  <script src="./js/bootstrap.min.js"></script>  
</body>
</html>