<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <fieldset>
       <legend>Employee Login</legend>
     <form action="./login" method="post">
          <table>
              <tr>
                 <td> Name </td>
                 <td> : </td>
                 <td><input type="text" name="username" ></td>
             </tr>
              <tr>
                 <td> Password </td>
                 <td> : </td>
                 <td><input type="password" name="password"></td>
             </tr>
             
              <tr>
                 <td colspan="3" align="center"> 
                   <input type="submit">
                  </td>
             </tr>
          </table>
       </form>
    </fieldset>
</body>
</html>