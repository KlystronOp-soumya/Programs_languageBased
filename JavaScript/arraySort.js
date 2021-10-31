var arr=[];

function getMaxElement(){
    return Math.max.apply(null,arr);
}
function getMinElement(){
    return Math.min.apply(null,arr);
}

function createArray(){
  for(let i=0;i<10;++i)
  {
      arr.push(Math.floor(Math.random()*25));
  }
 
}

console.log("Before Sorting:");
createArray(); 
console.log(arr);
arr.sort((a,b)=>{
    return a-b;
});
console.log("After Sorting:(asc)");
console.log(arr);

arr.sort((a,b)=>{
    return b-a;
});
console.log("After Sorting:(dsc)");
console.log(arr);

console.log(`MAximum value=${getMaxElement()} Minimum value=${getMinimumValue()} `);


//sorting object
var cars = [
    {type:"Volvo", year:2016},
    {type:"Saab", year:2001},
    {type:"BMW", year:2010}
  ];
  cars.sort(function(a, b){return a.year - b.year});
