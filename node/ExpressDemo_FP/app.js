var express = require('express') ;
var app = express()
var path = require('path')
var fs= require('fs')
var body_parser=require('body-parser')


//to use the static files
app.use(body_parser())
app.use(express.static('public'))
app.use(express.static('views'))
app.use(express.static('public/js'))
app.set("view engine","jade");
const agentData = require('./public/js/getAgentJson.js');
app.get('/',(req,res)=>{

//res.sendFile(__dirname+'/views/index.html');
//res.sendFile("index.html",{root: path.join(__dirname,'/views')}) ;
res.render(__dirname+'/views/welcome',{title:'Welcome To Express',message:'Hello World Express'}) ;
});
app.get('/about',(req,res)=>{

    //res.sendFile(__dirname+'/views/index.html');
    //res.sendFile("index.html",{root: path.join(__dirname,'/views')}) ;
    res.render(__dirname+'/views/about',{title:'Welcome To Express',message:'About Me'}) ;
    });

//to show the agents
app.get('/agents',(req,res)=>{

        //res.sendFile(__dirname+'/views/index.html');
        //res.sendFile("index.html",{root: path.join(__dirname,'/views')}) ;
        res.render(__dirname+'/views/show_agents',{title:'Welcome To Full Agents\' Data ',message: agentData.data.Agents}) ;
        });

app.listen(3000,()=>{
    console.log("Server satrted at the port 3000") ;
});