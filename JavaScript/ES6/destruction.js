//python like destruction

let ar=[1,2];
let [f,s]=ar;
console.log(`${f} and ${s}`);

let name="Rabindra Nath Tagore";
let [fname,lname]=name.split(" ");
let [fname1,,lname1]=name.split(" ");
console.log(`${fname} ${lname}`);
console.log(`${fname1} ${lname1}`);

//object destruction
let car={
    model:"Shelby",
    company:"Ford",
    year:"1960"
}

let {model,company}=car; //the name of the attributes the variable must be the same
console.log(`${model} ${company}`);

let model1="desire";
let company1 ="Hyundai";
let year1="1970";

//onject is created
let car2={
    model1,
    company1,
    year1
};
console.log(car2);