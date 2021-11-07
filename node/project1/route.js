const router = (pathName,handle,response)=>{
 //console.log("Routing a request for "+pathName);
 if(typeof handle[pathName] === 'function')
 {
    handle[pathName](response);
 }
 else
 {
    console.error("no handler for the path: "+pathName);
    response.writeHead(404,{"content-type": "text/plain" });
      response.write("404 Not Found");
      response.end();
 }
}
module.exports.router = router ;