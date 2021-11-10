/* This module provides the services for the handler */
const addition = (a,b)=>{
    return a+b;
}
const subtraction = (a,b) =>{
return a-b;
}
const multiplication = (a,b) =>{
    return a*b;
}
const dividation = (a,b)=>{
    //zero division
    try
     {
        return a/b ;
    } catch (error)
    {
        console.log(error);
    }
}

module.exports ={addition,subtraction,multiplication,dividation};