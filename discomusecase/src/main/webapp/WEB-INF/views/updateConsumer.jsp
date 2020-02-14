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
<body>
  <body background="${images}/bulb1.jpg" style="background-size:cover;background-position: center; background-repeat: no-repeat; background-size: cover; height: 724px;">

   <nav id="head" style="background-color: aquamarine; margin-top: -20px;" class="navbar navbar-light bg-light">
     <img id="headImg" src="${images}/discom.png" alt="">
      <form class="form-inline">
        <p id="headText" style="font-size: 45px;margin-right: 570px;">Discom Power Limited  </p> 
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
         <a href="../consumer/logout" class="btn btn-outline-success my-2 my-sm-0"style="border:1px solid">Logout</a>
        </form>
</div>
</nav>

  <div class="container">
    <div class=" col-10 col-sm-10 col-md-10 col-lg-10 col-xl-10 mt-5">
           <h1 id="heading" style=" color: white">Udate Consumer</h1>
              <form action="../consumer/updateConsumer" method="post" style=" color: white">
                <div class="form-row" >
                  <div class="col col-md-12">
                    <label for="inputEmail4">Name</label>
                    <input type="text" class="form-control"id="firstName" name="firstName" placeholder="enter name">
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
               <div class="form-group col-md-13" style="margin-top: -10px;margin-left: -2px">
                <label for="inputAddress">Mobile Number</label>
                <input type="number" class="form-control" id="mobileNumber"name="mobileNumber" style="height: 25px;" placeholder="enter mobile number...">
              </div>
               <div class="form-row"style="margin-top: 10px;">
                  <div class="form-group col-md-12">
                    <label for="inputpassword">Password</label>
                    <input type="password" class="form-control" id="password"name="password"placeholder="Enter password">
                  </div> 
                </div>
             <button id="button" type="submit" class="btn btn-primary" class="form-group col-md-5"style="margin-left: 350px;margin-top: 0px;">Submit</button>
           </form>
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