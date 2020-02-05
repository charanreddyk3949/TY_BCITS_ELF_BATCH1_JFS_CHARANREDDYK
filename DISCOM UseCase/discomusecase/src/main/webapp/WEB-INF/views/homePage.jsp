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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HomePage</title>
    <link rel="stylesheet" href="${css}/homePage.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"  />
    <link rel="stylesheet" href="${css}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/all.css">

</head>
<body>
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
            <a class="nav-link" style="color: aqua;padding-left: 100px;font-size: 20px;" href="../consumer/homePage">Home </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" style="color: aqua;padding-left: 100px;font-size: 20px;" href="../consumer/consumerLogin">Consumer Portal</a>
          </li>
          <li class="nav-item">
              <a class="nav-link" style="color: aqua;padding-left: 100px;font-size: 20px;" href="../employee/employeeLogin">Employee Portal</a>
            </li>            
        </ul>       
      </div>
     </nav>
    
    <body background="${images}/electricity-background-blue-sky-97140981.jpg" style="background-size:cover;background-position: center; 
      background-repeat: no-repeat; 
      background-size: cover; height: 724px;">
      

    <Div id="body">
      <p>WELCOME TO DISCOM INDIA LIMITED</p>
    </Div>
    
    <div id="hfooter">
    <footer class="page-footer font-small mdb-color darken-3 pt-4"style="padding-top: -20px;">
 
      <div class="footer-copyright text-center py-3" >
        Total Visitors - 5715466 , Last Modified on - January 4, <br> 2020Copyright©2020 BESCOM, All Rights Reserved. Powered by BCITS
        <a href="https://mdbootstrap.com/education/bootstrap/"> www.DISCOM.com</a>
      </div>  
    </footer>
   </div>
  
  <script src="./jquery-3.4.1.js"></script> 
  <script src="./js/bootstrap.min.js"></script>
</body>
</html>