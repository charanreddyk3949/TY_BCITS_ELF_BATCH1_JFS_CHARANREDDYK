function validateForm(){

    var rrNumber=document.getElementById("empId").value;
    var password=document.getElementById("password").value;
    
    var rrNumCheck=/^[0-9]+$/;
    var pwdCheck=/^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/;

    var rrNum=false;
    var pwdVal=false;




      if (rrNumber.length == 0) {
        document.getElementById("empId").innerHTML="Please enter the employeeId";
      }else if(rrNumber.length <=6 && rrNumber.length >=9){
        document.getElementById('empId').innerHTML = "**Provide the Valid employeeId**";
      }else if (rrNumCheck.test(rrNumber)) {
        document.getElementById('empId').innerHTML = "";
        rrNum =true;
      } else {
        document.getElementById('empId').innerHTML = "**Provide valid employeeId**";
      }




    if (password.length == 0) {
        document.getElementById("pwdErr").innerHTML="Please enter the password";
    }else if(pwdCheck.test(password)) {
        document.getElementById('pwdErr').innerHTML = "";
        pwdVal= true;
    }else{
        document.getElementById('pwdErr').innerHTML = "Please provide the password ";
    }
}