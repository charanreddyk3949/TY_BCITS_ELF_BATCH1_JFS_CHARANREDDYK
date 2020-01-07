function showAlert(){
    alert("Hi welcome to cinema Hall!!!")
}
var ele= document.createElement('p')
function myshowAlert() {
   
    ele.textContent='element is created'
   document.body.appendChild(ele)

} 


function displayElement(){
    var dispElement= document.getElementById('disp')
    var myBtn=document.getElementById('myBtn')
    if(dispElement.style.display ==='' ||
    dispElement.style.display === 'none'){
        dispElement.style.display='block'
        myBtn.textContent='Click here to hide h1 element'
    }else{
        dispElement.style.display='none'
        myBtn.textContent='Click here to show  h1 element'
    }
    
}

function changeColortoWhite(){
   var text=document.getElementById('cgcolor')
    text.style.backgroundColor="red"
    
}
function changeColorToBlue(){
    var text=document.getElementById('cgcolor')
    text.style.backgroundColor="blue"
 }

 function showData() {
     console.log('Working!!');
 }
 function showDetail() {
    console.log('on key down');
}
function getInputValue(){
    var inpElement=document.getElementById('inp')
    console.log(inpElement.value);
   var showElement=document.getElementById('show');
   showElement.textContent=inpElement.value;
}