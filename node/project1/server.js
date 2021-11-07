const http = require('http');
const url = require('url');

const startServer = (router,handle) => { //router is the function
  const onRequest =  (request,response) => {
      console.log("Received request");
      var pathName = url.parse(request.url).pathname ;
      console.log("Request received for "+pathName);
      router(pathName,handle);
      response.writeHead(200, "Server Up", { "content-type": "text/plain" });
      response.write("Hello From Server");
      response.end();
  }

http.createServer(onRequest).listen(8000) ;
console.log("Server running at port:8000");
}
exports.startServer = startServer ;
