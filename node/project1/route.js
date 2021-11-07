const router = (pathName,handle)=>{
 //console.log("Routing a request for "+pathName);
 if(typeof handle[pathName] === 'function')
 {
    handle[pathName]();
 }
 else
 {
    console.error("no handler for the path: "+pathName);
 }
}
module.exports.router = router ;