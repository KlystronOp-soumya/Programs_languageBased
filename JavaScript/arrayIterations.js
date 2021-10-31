//using for each
let txt="";
var numbers = [45, 4, 9, 16, 25];
numbers.forEach(myFunction);

function myFunction(value, index, array) {
  txt = txt + value + "<br>";
}

//ES6 approach
var numbers = [45, 4, 9, 16, 25];
numbers.forEach((each_number,index,array)=>{
console.log(`number ${index} = ${each_number}`);
console.log(array)
});
/**
 * Map
 * The map() method creates a 
 * new array by performing a function on each array element.
 * Similar to python Map
 */
 var numbers1 = [45, 4, 9, 16, 25];
 var numbers2 = numbers1.map((each_elem)=>{
   return each_elem*2;
 });
console.log(numbers2);

/**
 * The filter() method creates a new array 
 * with array elements that passes a test.
 * 
 * 
 */

//find the numbers greater than 10
var over10=numbers1.filter((each_elem) => {
  return each_elem >10;
})
console.log(over10);

/**
 * reduce
 * 
 * 
 */
let total=0;//either declare here or
var sumArray=numbers1.reduce((total,each_elem)=>{
return total + each_elem;
},0);//decalre here
console.log(sumArray);

//get index of any element
var fruits=["apple","banana","coconut"];
console.log(`Index of banana is ${fruits.indexOf("coconut")}`);
