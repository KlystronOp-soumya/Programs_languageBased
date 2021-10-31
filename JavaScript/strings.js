/*This script demonstrates all the varous convepts and methods of String class in javascript */
var name="Soumya";
var title=new String("Paul");

var name2="Soumya";

console.log(typeof(name));
console.log(typeof name2);
console.log(name==name2?"Yes":"No");

//string methods in javaScript
let str="I love JavaScript.This JavaScript is a great language.";
console.log(`The length of "${str}" is ${str.length}`);

//get the last index of the string
var pos=str.lastIndexOf("JavaScript");
console.log(pos);//returns -1 if not found 

//also index of is available and both the parameters are accept second parameter as the lookup index
var str = "Please locate where 'locate' occurs!";
var pos = str.indexOf("locate", 15);

//get the position
var str = "Please locate where 'locate' occurs!";
var pos = str.search("locate");//cant take any second parameter

//Extraction
/**
 * 
 * slice(start, end)
   substring(start, end)
  substr(start, length)
 */

  var str = "Apple, Banana, Kiwi";
  var res = str.slice(7, 13); //supports negative indexing as well
  var res = str.slice(7);//7 to the end of the string

  //replace
  str = "Please visit Microsoft!";
var n = str.replace("Microsoft", "W3Schools");
//regex
str = "Please visit Microsoft! and I love Microsoft";
var n = str.replace(/MICROSOFT/i, "W3Schools");

//upper and loxer cae
var n="Hello".toLowerCase();
//toUpperCase

//chacter extraction
/**
 * charAt()
 * charCodeAt()
 * []
 */

//if includes
var n="Hello world".includes("Hello");
console.log(n);

//split a string into array of chars
//python string.split("delimeter")
var ar=n.split(',');
console.log(ar);

//omit spaces from the both ends
console.log(" Hello World   ".trim());

//toString
var n=10;
console.log(typeof(n.toString()));