<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
    
     <% String msg=(String) request.getAttribute("msg");
       String errMsg=(String) request.getAttribute("errMsg");
      
    %>
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>ConsumerLogin</title>
    <link rel="stylesheet" href="${css}/consumerLogin.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"  />
    <link rel="stylesheet" href="${css}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${css}/all.css">
    <link rel="stylesheet" href="${js}/all.js">
    
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
       <spring:url var="css" value="/resources/css"/>
       <spring:url var="js" value="/resources/js"/>
       <spring:url var="images" value="/resources/images"/>
  
</head>
<body>
          <body background="${images}/bulb1.jpg" style="background-size:cover;background-position: center; 
          background-repeat: no-repeat; 
          background-size: cover; height: 724px;">

          <nav id="head" style="background-color: aquamarine; margin-top: -20px;" class="navbar navbar-light bg-light">
            <img id="headImg" src="${images}/discom.png" alt="">
            <form class="form-inline">
                <p id="headText"style="font-size: 45px;margin-right: 570px;">Discom Power Limited </p> 
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
              <a class="nav-link" style="color: aqua;padding-left: 100px;font-size: 20px;" href="../employee/employeeHomePage">Home </a>
            </li>
            
           <form class="form-inline my-2 my-lg-0" >
                <a href="../employee/logout" class="btn btn-outline-success my-2 my-sm-0"style="border:1px solid;text-align: right;">Logout</a>
           </form>
       </form>
          </ul>
          
        </div>
      </nav>
     <% if(msg !=null && !msg.isEmpty()) {%>
       <h3 style="color: green; padding-left:270px"><%= msg %></h3>
       <% } %>
      
     
  <div align="center">
   <form action="../employee/updateResponse" method="post"
    style="border: 1px solid black;margin-top: 100px;width: 700px;height: 500px;   box-shadow: 5px 10px inset;">
    <h2 style="color: white;">Response</h2>
  
     <div class="form-group col-8" style="color : white;">
      <label for="exampleFormControlTextarea1"> Response area</label>
      <textarea class="form-control" id="exampleFormControlTextarea1" name="response" rows="5" placeholder="enter response here..."></textarea>
     </div>
     <button style="margin-left: 0px; background-color: cyan;color: black;font-size: 20px;margin-top: 20px;height: 40px;width: 120px;border-radius: 10px">Submit</button>
  </form>
</div>    
 

<% if(errMsg !=null && !errMsg.isEmpty()) {%>
<h3 style="color: red;padding-left:270px"><%= errMsg %></h3>
<% } %>
    
  <script src="${js}/consumerLogin.js"></script>   
  <script src="./jquery-3.4.1.js"></script> 
  <script src="./js/bootstrap.min.js"></script>    
</body>
</html>