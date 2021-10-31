//script to demonstrate the numbers
var n=123;
var n1=Number(123);

var mx=Number.MAX_VALUE;
var mn=Number.MIN_VALUE;

//change the type
console.log(parseInt("13.33"));
console.log(parseFloat("13.22"));

var x = 9.656;
x.toExponential(2);     // returns 9.66e+0
x.toExponential(4);     // returns 9.6560e+0
x.toExponential(6);     // returns 9.656000e+0

//returns string
var x = 9.656;
x.toFixed(0);           // returns 10
x.toFixed(2);           // returns 9.66
x.toFixed(4);           // returns 9.6560
x.toFixed(6);           // returns 9.656000

var x = 123;
x.valueOf();            // returns 123 from variable x
(123).valueOf();        // returns 123 from literal 123
(100 + 23).valueOf();   // returns 123 from expression 100 + 23

//set NaN
var x=Number.NaN;
