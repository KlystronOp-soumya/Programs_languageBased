const fs = require('fs')
const home = (response)=>{
    console.log("Executing 'home' handler");
    let data=fs.readFileSync("home.html","utf-8");
    //console.log(data);
    response.writeHead(200,{"Content-Type": "text/html"});
    response.write(data);
    response.end();
}
const review = (response) =>{
    console.log("Executing 'review' handler");
}

exports.home = home;
exports.review = review ;