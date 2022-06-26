const path = require('path')
const fs = require('fs')

const dirName = path.dirname(__dirname)
const filePath = path.resolve(dirName+'/resources/agent.json')

console.log(filePath)

const getData = () => {
  try {
    // Get the content of the JSON file 
    const data = fs.readFileSync(filePath,(err,data)=>{});

    // Turn it to an object
     const obj = JSON.parse(data);

    // Do something with the result
    return obj
  } catch (err){
    console.log(err);
  }
}

const agentDataObject=getData()
//export
module.exports.data=agentDataObject ;
