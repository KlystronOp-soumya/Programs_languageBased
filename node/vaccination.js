const axios=require('axios');
const URL0="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?"
const URL1="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode=110001&date=31-03-2021";
const URL2="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode=700125&date=19-05-2021";
/* const makeUrl = (params)=>{
    let query = ""
    for (let eaach_param in params)
         query += encodeURIComponent(eaach_param) + '=' 
                  + encodeURIComponent(params[eaach_param]) + '&'
    return query.slice(0, -1)
}

const params={
    "pincode":"110001",
    "date": "18-05-2021"
}
//console.log(makeUrl(params));
async function getVaccinationDetails(){
    let queries=makeUrl(params);
    let api_url=URL0+queries;
    console.log(api_url);
    let fetchedData=await axios.get(URL1);
    //let jsonFetchedData= await JSON.stringify(fetchedData);
    console.log(fetchedData);
    return fetchedData;
}

getVaccinationDetails()
 .then((response)=>{
   
    console.log("Success");


 }).catch((err)=>{
console.log("Some Error has occured:: "+err);
 });
 */
 let header={"accept": "application/json","Accept-Language":"hi_IN","User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64"}

 axios.get(URL2,{header}).then((response)=>{
    console.log(response.data);

}).catch((err)=>{
console.log("Some error has occurred:: "+err);
});