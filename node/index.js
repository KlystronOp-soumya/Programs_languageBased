const { user_data } = require('./array');
//console.log(Array.isArray(user_data));
//console.log(user_data.length)

const userName = (user_data) => { 
  //write code to display the user name
  user_data_names= new Array();
  user_data.forEach(element => {
    user_data_names.push(element.name);
  });
 // console.log(user_data_names);
 return user_data_names ;
}

const displayBloodType = (user_data) => {
    //write code to display the user blood type
    let op= "Available blood groups are ";
    bldSet = new Set();
    user_data.forEach(element => {
        bldSet.add(element.blood_group);
      });
      bldSet.forEach(element => {
          op+=element+',' ;
      })
     // console.log(op.substring(0,op.length-1));
      return op.substring(0,op.length-1) ;
}

const frequentBloodOccurence = (user_data) => {
  //write code to display the frequent blood type
  let bldFreqMap = new Map();
  user_data.forEach(element =>{
    if(bldFreqMap.get(element.blood_group)!= undefined)
    {
        let curr_count = bldFreqMap.get(element.blood_group) ;
       // console.log(curr_count) ;
        bldFreqMap.set(element.blood_group,curr_count+1) ;
    }
    else
    {
       // console.log("Inside Else");
        bldFreqMap.set(element.blood_group,1) ;
    }


  });
 // console.log(bldFreqMap);
  let itr = bldFreqMap.values();
  let maxFreqVal = itr.next().value ;//shifted

  for(let i =1 ;i<bldFreqMap.length ;++i)
  {
      let curr = itr.next().value;
        if(maxFreqVal < curr)
            maxFreqVal = curr ;
  }
 // console.log(maxFreqVal) ;
  return maxFreqVal ;
}

const sortEligibleData = (user_data) => {
  //write code to display the eligible user
  //console.log("called");
  var data= new Array();
  let retData = new Array();
  var opObj={
    age: undefined,
      blood_group: undefined,
      height: undefined,
      location: undefined,
      medication:undefined,
      name: undefined,
      prev_donation_timeline: undefined,
      weight: undefined
  };
  data = user_data.filter(element => element.blood_group === "A+" && element.age >=18 && element.location === "Chennai" && element.medication == false && element.prev_donation_timeline >6 );
  //console.log(data.length);

  for(let i =0 ;i<data.length ;++i)
  {
    let opObj={
        age: undefined,
          blood_group: undefined,
          height: undefined,
          location: undefined,
          medication:undefined,
          name: undefined,
          prev_donation_timeline: undefined,
          weight: undefined
      };
   
        opObj.age = data[i].age ;
        opObj.blood_group = data[i].blood_group ;
        opObj.height = data[i].height ;
        opObj.location = data[i].location ;
        opObj.medication =data[i].medication ;
        opObj.name = data[i].name ;
        opObj.prev_donation_timeline = data[i].prev_donation_timeline ;
        opObj.weight = data[i].weight ;
    
        //console.log("Current Object: "+opObj) ;
    
        retData.push(opObj);
  }
  

  return retData  ;
}

const AddBmi = (sortedData) => {
  //write code to add BMI to eligible users

  let retData = new Array();
    
    sortedData.forEach(element =>{
        let bmi = (element.weight / ((element.height * element.height) 
                            / 10000)).toFixed(2);
                            let opObj={
                                age: undefined,
                                blood_group: undefined,
                                bmi:undefined,
                                height: undefined,
                                location: undefined,
                                medication:undefined,
                                name: undefined,
                                prev_donation_timeline: undefined,
                                weight: undefined
                            };  
                            opObj.age = element.age ;
                            opObj.blood_group = element.blood_group ;
                            opObj.bmi = bmi;
                            opObj.height =element.height ;
                            opObj.location =element.location ;
                            opObj.medication =element.medication ;
                            opObj.name = element.name ;
                            opObj.prev_donation_timeline = element.prev_donation_timeline ;
                            opObj.weight =element.weight ;  
           // retData.push(opObj)  ;
            user_data.push(opObj);            
    }) ;
    //console.log(retData) ;  
}


userName(user_data);
displayBloodType(user_data);
frequentBloodOccurence(user_data);
let sortedData = sortEligibleData(user_data)
//console.log(sortedData);
AddBmi(sortedData);
//sortEligibleData(user_data);
console.log("\n\n\n");
console.log(user_data);
module.exports = {
    userName,
    displayBloodType,
    frequentBloodOccurence,
    sortEligibleData,
    AddBmi,
    sortedData
  };