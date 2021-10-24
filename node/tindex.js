module.exports= function(){
 
    const data = require("./testData.json");
    
    /*Explore the JSON file and return required JSON data*/
    //console.log(data);
    let jsonData = JSON.parse(data);
    console.log(jsonData);
    let studentData = jsonData.studentData ;
    //console.log(studentData);
    //this contains the array of the objects
    studentData.forEach(element => {
        //console.log(element);
        //console.log("Before conversion Data type: "+typeof element.aggregate) ;
        element.aggregate = parseInt(element.aggregate);
        //console.log(element.percentages);
        //console.log("After conversion Data type: "+typeof element.aggregate) ;
        element.percentages.forEach(percentageArr => {
            percentageArr.sub1=parseInt(percentageArr.sub1);
            percentageArr.sub2=parseInt(percentageArr.sub2);
            percentageArr.sub3=parseInt(percentageArr.sub3);
            element.percentages=new Array(percentageArr);
        });
        //console.log(element.percentages);
        
    });
   //console.log(a.studentData);
   jsonData.studentData = studentData;
   //console.log(jsonData);
    return jsonData;
    }
    
    var json = JSON.parse(data).studentData;

json.forEach(function(element, index){

element['aggregate'] = parseInt(element['aggregate']);

element.forEach(function(per,ind){

per['sub1'] = parseInt(per['sub1']);

per['sub2'] = parseInt(per['sub2']);

per['sub3'] = parseInt(per['sub3']);

});

});

return json;



}