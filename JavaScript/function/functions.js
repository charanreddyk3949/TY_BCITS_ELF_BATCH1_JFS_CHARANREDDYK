function add(a,b){
    var c=a+b;
    return c;
}
var sum=add(10,20);
console.log('Sum  is ',sum);


console.log('----------------------------------------------------');


var  n1=10;
var str='10';
if(n1=== str){
    console.log('Equal');
    
}else{
    console.log('Not Equal');
    
}
console.log("------------------------------------------------------");


console.log(typeof null);
console.log(typeof 10);
console.log(typeof 'hello');
console.log(typeof true);
var nums=[10,20,30]
console.log(typeof nums);
console.log(typeof undefined);
console.log(typeof add);



var isAry=Array.isArray(nums)
if(isAry===true){
    
    
    console.log("num is an array")
    console.log(nums);                                                                                                                                        
    
}else{
    console.log("num is not an array")
    
}

console.log("=======================arrow functions======================");
  
var addM=(a,b) =>a+b;
var s=addM(10,20);
console.log('Sum ',s)

var sqr=a=>a*a;
var n = sqr(10)
console.log(`Square is ${n}`);
console.log(`Square of 10 is ${10*10}`);











