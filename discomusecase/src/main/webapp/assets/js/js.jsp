function validation() {
    var userid = document.getElementById('userid').value;
    var fname = document.getElementById('fname').value;
    var lname = document.getElementById('lname').value;
    var email = document.getElementById('email').value;
    var psw = document.getElementById('psw').value;
    var psw_repeat = document.getElementById('psw_repeat').value;

    var usercheck = /^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+$/;
    var fnamecheck = /^[A-Za-z. ]{3,20}$/;
    var lnamecheck = /^[A-Za-z. ]{3,20}$/;
    var emailcheck = /^[A-Za-z_]{3,}@[A-Za-z]{3,}[.]{1}[A-Za-z.]{2,6}$/;
    var pswcheck = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9@#$%^&*]{8,15}$/;

    if (usercheck.test(userid)) {
      document.getElementById('usererror').innerHTML = "";
    } else {
      document.getElementById('usererror').innerHTML = "**User id is         invalid";
      return false;
    }
    if (fnamecheck.test(fname)) {
      document.getElementById('fnameerror').innerHTML = "";
    } else {
      document.getElementById('fnameerror').innerHTML = "**Should not contain digits and special characters";
      return false;
    }
    if (emailcheck.test(email)) {
      document.getElementById('mail').innerHTML = "";
    } else {
      document.getElementById('mail').innerHTML = "**Email-id is invalid";
      return false;
    }
    if (pswcheck.test(psw)) {
      document.getElementById('pass').innerHTML = "";
    } else {
      document.getElementById('pass').innerHTML = "**Should not contain digits and special characters";
      return false;
    }
    if (psw.match(psw_repeat)) {
      document.getElementById('conpass').innerHTML = "";
    } else {
      document.getElementById('conpass').innerHTML = "**Password doesnot match";
      return false;
    }
 }
 
 
 
 
 
 <html>
<body>
<form id="reg" method="post" onsubmit="return validation()">    
   <legend><b>Create an account</b></legend>
      <div class="form-group">
        <label for="userid">User id</label>
        <input type="text" placeholder="Enter your User id" class="form-              control" name="userid" id="userid">
         <span id="usererror" class="text-danger font-weight-bold"></span>
       </div>
       <div class="form-group">
         <label for="fname">First Name</label>
         <input type="text" placeholder="Enter your First name" class="form-            control" name="fname" id="fname">
         <span id="fnameerror" class="text-danger font-weight-bold"></span>
       </div>
        <div class="form-group">
          <label for="email">Email id</label>
           <input type="email" placeholder="Enter your Email-id" class="form-             control" name="email" >
            <span id="mail" class="text-danger font-weight-bold"></span>
          </div>
         <div class="form-group">
            <label for="psw">Password</label>
            <input type="password" placeholder="Enter Password" class="form-              control" id="psw">
            <span id="pass" class="text-danger font-weight-bold"></span>
          </div>
         <div class="form-group">
             <label for="psw_repeat">Confirm Password</label>
             <input type="password" placeholder="Re-enter Password"                        class="form-control" id="psw_repeat" >
             <span id="conpass" class="text-danger font-weight-bold"></span>
          </div>
          <div class="form-group">
              <div class="dropdown">
                 <label for="affiliation">Affiliation</label>
                  <select class="form-control">
                  <option value="alumni" name="affiliation">Alumni</option>
                  <option value="faculty" name="affiliation">Faculty</option>                   <option value="student" name="affiliation">Student</option>
                  </select>
               </div>
            </div>
            <div class="form-group">
            <button type="submit" class="btn btn-success" id="submit"                      name="submit">Register</button>
             <button type="reset" class="btn btn-danger">Cancel</button>
            </div>
        </form>
 </body>
 </html>
 
 
 
 
 
 