<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Payment page</title>

    <link rel="stylesheet" href="${css}/paymentPage.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"  />
    <link rel="stylesheet" href="${css}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/all.css">
</head>
<body>

    <body background="${images}/images1.jpg" style="background-size:cover;background-position: center; 
    background-repeat: no-repeat; 
    background-size: cover; height: 724px;">

    <nav id="head" style="background-color: aquamarine; margin-top: -20px;" class="navbar navbar-light bg-light">
      <img id="headImg" src="${images}/discom.png" alt="">
      <form class="form-inline">
          <p id="headText"style="margin-right:150px">Discom Electricity Limited  </p> 
          <a href="">English</a>&nbsp;|&nbsp;
           <a href="" style="margin-right:20px">Kannada</a>
      </form>
    </nav>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>


  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul  class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" style="color: aqua;padding-left: 100px;font-size: 20px;" href="#">Home </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" style="color: aqua;padding-left: 100px;font-size: 20px;" href="#">AboutUs</a>
      </li>
      <li class="nav-item">
          <a class="nav-link" style="color: aqua;padding-left: 100px;font-size: 20px;" href="#">Consumer Portal</a>
        </li>
      
      <li class="nav-item">
        <a class="nav-link disabled" style="color: aqua;padding-left: 100px;font-size: 20px;" href="#" tabindex="-1" >New Connection</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search"style="font-size:13px" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>


    <div class="container">
        <div class=" col-10 col-sm-10 col-md-10 col-lg-10 col-xl-10 mt-5">

    <form action="" style="border: 1px solid black;width: 600px;height: 540px;border-radius: 10px;background-color:lavender; margin-left: 300px; ">

        <h1 style="text-align: center; color: navy;">Payment</h1>
        <div style="margin-top: 30px;">
            
            <span >
          <!-- <p style="font-size: 25px; padding-bottom: -50px;">Pay Using</p> -->
            <img  src="${images}/visa.jpg" alt="" style="height: 50px; width: 100px;margin-left: 100PX;" >
            <img src="${images}/master card.png" alt="" style="height: 50px; width: 100px;" >
            <img src="${images}/rupay card.jpg" alt="" style="height: 50px; width: 100px;">
            <img src="${images}/upi card.jpg" alt="" style="height: 50px; width: 100px;">
            </span>
        </div>

        <h2 style="text-align: center; font-size: 30px; color: royalblue;margin-top: 30PX;">Enter Card Details</h2>
        <div>          
            <label for="" style="padding-left: 20px;font-size: 15px; padding-left: 150px;margin-top: 30PX;">Card Number:</label>
            <input type="number" name="cardNumber" id="" style="height: 25px;width: 200px;" placeholder="Enter Card Number...">
        </div>
        <div style="padding-top: 20px;">
             <label for="" style="padding-left: 20px;font-size: 15px; padding-left: 120px;">Card Holder Name:</label>
             <input type="text" name="" id="" style="height: 25px;width: 200px;" placeholder="Enter Card Holder Name...">
        </div>
        <div style="padding-top: 30px;">          
            <label for="" style="padding-left: 160px;font-size: 15px; ">Expiry Date:</label>
            <input type="number" name="month" id="" style="height: 25px;width: 50px;"placeholder="MM">
            <input type="number" name="year" id="" style="height: 25px;width: 50px;"placeholder="YYYY">
        </div>
        
        <div style="padding-top: 20px;">
            <label for="" style="padding-left: 150px;font-size: 15px;">CVV Number:</label>
            <input type="number" name="" id="" style="height: 25px;width: 200px;" placeholder="CVV no.">
       </div>
        
        <div style="padding-top: 20px;text-align: center;">
            <input type="submit" value="PAY NOW" style="height: 50px;width: 200px;background-color: turquoise;border-radius: 10PX;">   
        </div>
        <div style="text-align:center; font-size: 20PX;">
            <a href="" >Cancel</a>
        </div>
        
    </form>
 </div>
 </div>
    
  <script src="./jquery-3.4.1.js"></script> 
  <script src="./js/bootstrap.min.js"></script>
</body>
</html>