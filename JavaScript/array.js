//Array basics in JavaScript
var ar1=[1,2,3,4,5];
var ar2=["apple","banana","grape"];

len_ar1=ar1.length;
len_ar2=ar2.length;

//check array
console.log(ar1.isArray());
console.log(ar2 instanceof Array);

//insert an element
ar1.push(12);
ar1.shift();//removes the first element
ar1.unshift(13,14,15);//inserts in front
ar1.pop();//removes the last element
console.log(ar1);

//comma seperated array values
console.log(ar1.toString());
//joint as python
console.log(ar1.join("/"));//delimeter
//deleting elements like python
delete ar2[2];

//splice=>used to add new elements in a array
/**Syntax
 * splice(indexAfter,numberOFElelmentsToBeREmoved,elements)
 */

ar2.splice(0,0,"Kiwi","grape","coconut");
//remove elements
ar2.concat(0,1);//removes the element @index=0,others are shifted
//slice[start,end)
//returns a new array
var new_ar3=ar2.slice(1,4);
console.log(new_ar3);


//membership test
//https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/for...of
var s="cauliflower";
let vowels = ["a", "e", "i", "o", "u"];

    for(let v of s) {
        if(vowels.includes(v))
            console.log(v);
    }
    
    for(let v of s) {
        if(!vowels.includes(v))
            console.log(v);
    }
