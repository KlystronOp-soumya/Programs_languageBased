var express = require('express') ;
var app = express()
var path = require('path')
var fs= require('fs')
var body_parser=require('body-parser')

//to use the static files
app.use(body_parser())
app.use(express.static('public'))
app.use(express.static('views'))
app.set("view engine","jade");
app.get('/',(req,res)=>{

//res.sendFile(__dirname+'/views/index.html');
//res.sendFile("index.html",{root: path.join(__dirname,'/views')}) ;
res.render(__dirname+'/views/welcome',{title:'Welcome To Express',message:'Hello World Express'}) ;
});

app.listen(3000,()=>{
    console.log("Server satrted at the port 3000") ;
});