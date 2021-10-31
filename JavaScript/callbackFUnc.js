function display( res){
    console.log(res);
}

function calculate(a,b,operator){
    switch(operator){
        case "+": return a+b;
        break
        case "-": return a-b;
        break;
        case "*":return a*b;
        break;
        case "/":return (a!=0 | b!=0)?a/b:"Not possible";
        break;
        default:return "Not defined";
        break;
    }

}
function calculate2(a,b,operator){
    let res=Number.MAX_VALUE;
    switch(operator){
        case "+": res= a+b;
        break
        case "-": res=a-b;
        break;
        case "*":res= a*b;
        break;
        case "/":res= (a!=0 | b!=0)?a/b:"Not possible";
        break;
        default:return "Not defined";
        break;
    }
    display(res);

}

//calls

console.log("With out call back");
let res=calculate(2,3,"+");
display(res);
console.log("With Call back");
calculate2(2,3,"*",display);