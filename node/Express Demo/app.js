const express = require('express');
var bodyParser = require("body-parser");

var app = express();

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(express.static(__dirname + "/login.html"));

app.get("/",(request,response) =>{
    response.send("Hello World");
    //usign the request parametes to extract different informations

    
});
app.get("/login",(request,response)=>{
    response.sendFile(__dirname + "/login.html");
});

app.get("/register",(request,response)=>{
    request.accepts(["html"]);
    response.sendFile(__dirname+"/register.html");
});

app.post("/doRegister/:name",(request,response)=>{
    console.log(request.params)
    response.status(200).send("<h4>Name is : </h4>"+request.params.name) ;
});

app.post("/validateCreds/",(request,response)=>{
    console.log(`Received User ID: ${request.body.userID} Password: ${request.body.Password}`) ;
    response.status(200).send("<h4>Received</h4>") ;
});

var server=  app.listen(3000,()=>{
    console.log("Listening to the port 3000");
    var host=server.address();//returns a json
    var port=server.address().port;
    hostStr=JSON.stringify(host);
    console.log(`Running config:${hostStr}`);
});