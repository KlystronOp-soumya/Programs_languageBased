const { response } = require('express');
const express = require('express');
const { request } = require('http');
var bodyParser = require("body-parser");

var app = express();

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(express.static(__dirname + "/login.html"));

app.get("/",(request,response) =>{
    response.send("Hello World");
    
});
app.get("/login",(request,response)=>{
    response.sendFile(__dirname + "/login.html");
});

app.post("/validateCreds",(request,response)=>{
    console.log(`Received User ID: ${request.body.userID} Password: ${request.body.Password}`) ;
    response.status(200).send("<h4>Received</h4>") ;
});

var server=app.listen(3000,()=>{
    console.log("Listening to the port 3000");
    var host=server.address();//returns a json
    var port=server.address().port;
    hostStr=JSON.stringify(host);
    console.log(`Running config:${hostStr}`);
});