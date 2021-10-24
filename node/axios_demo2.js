const axios=require('axios');
const api_url="http://localhost:9000/RestDemo/webapi/employees";
axios.get(api_url)
   .then((response)=>{
      // console.log(response);
        return response.data;
})
.then((actualdata) => {
     //let country_array=actualdata.Countries;

    /*  country_array.forEach((element,index) => {
         if(element.Country === "India"){
             console.log(element);
             //console.log(index);
             console.log(`New Deaths:${element.NewDeaths}`);
         } */
          console.log(actualdata);
        
    
})
.catch((error)=>{
    console.error(error)
});