/*let min=11;
let max=20;
var v=Math.floor(Math.random()*(max-min+1)+min);
console.log(v)*/

function checkSign(num) {
    var dec=(num >0)?"positive":(num === 0 )?"zero":"negative";
    return dec;
    }
    
    console.log(checkSign(10)) ;
    console.log(checkSign(0)) ;
    console.log(checkSign(-1)) ;

