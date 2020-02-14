function validateForm(){

    var rrNumber=document.getElementById("rrNumber").value;
    var password=document.getElementById("password").value;
    
    var rrNumCheck=/^[A-Z0-9]+$/;
    var pwdCheck=/^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/;

    var rrNum=false;
    var pwdVal=false;




      if (rrNumber.length == 0) {
        document.getElementById("rrNumErr").innerHTML="Please enter the RRNumber";
      }else if(rrNumber.length <=6 && rrNumber.length >=9){
        document.getElementById('rrNumErr').innerHTML = "**Provide the Valid rrNumber**";
      }else if (rrNumCheck.test(rrNumber)) {
        document.getElementById('rrNumErr').innerHTML = "";
        rrNum =true;
      } else {
        document.getElementById('rrNumErr').innerHTML = "**Provide valid password**";
      }




    if (password.length == 0) {
        document.getElementById("pwdErr").innerHTML="Please enter the password";
    }else if(pwdCheck.test(password)) {
        document.getElementById('pwdErr').innerHTML = "";
        pwdVal= true;
    }else{
        document.getElementById('pwdErr').innerHTML = "provide valid password ";
    }
}