function validateForm(){
   var loginForm= document.forms['loginForm']
   var userMail=loginForm['userEmail'].value;
   var pwd=loginForm['userPwd'].value;

   console.log(loginForm);
   console.log('User mail',userMail);
   console.log(' User password',pwd);
   if(userMail.trim().length>10){
    document.getElementById('emailErr').style.display='none'
       console.log('User mail is valid');
       
   }else{
       document.getElementById('emailErr').style.display='block'
    
       console.log('user mail is not valid');
   }
   if(pwd.trim().length>5){
    // document.getElementById('passwordErr').style.display='none'
       console.log('password is valid');
   }else{
    // document.getElementById('passwordErr').style.display='block'
       console.log('password is invalid'); 
   }
  
}



