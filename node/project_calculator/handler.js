var querystring = require('querystring');
const {addition,subtraction,multiplication,dividation} = require('./calService');

function cal(reqMeth,response,parsedUrl){
	console.log("Executing 'cal' handler");
    var queryString = querystring.parse(parsedUrl.query);//json
    //console.log(queryString);
    //var htmlfile=querystring.stringify(queryString);
    //console.log(htmlfile);
    //handle the queries
    if (queryString.func === "add" && reqMeth === "GET") {
        
        let sum = addition(parseInt(queryString.a),parseInt(queryString.b));
        response.writeHead(200,{"Content-Type":"text/html"});
        response.write(`Addition is: ${sum.toString()}`);
        response.end();
        
    }
    else if (queryString.func === "subtract" && reqMeth === "GET") {
        
        let sub = subtraction(parseInt(queryString.a),parseInt(queryString.b));
        response.writeHead(200,{"Content-Type":"text/html"});
        response.write(`Subtraction is: ${sub.toString()}`);
        response.end();
    }
    else if (queryString.func === "multiple" && reqMeth === "GET") {
        
        let mult = multiplication(parseInt(queryString.a),parseInt(queryString.b));
        response.writeHead(200,{"Content-Type":"text/html"});
        response.write(`Multiplication is: ${mult.toString()}`);
        response.end();
    }
    else if(queryString.func === undefined && reqMeth === "GET")
    {
        
        let divd = dividation(parseInt(queryString.a),parseInt(queryString.b));
        response.writeHead(200,{"Content-Type":"text/html"});
        response.write(`Division is: ${divd.toString()}`);
        response.end();
    }
    else 
    {
        response.writeHead(404,{"Content-Type":"text/html"});
        response.write("Unknown Operation");
        response.end();
    }

}

exports.cal = cal;

