const http = require('http');

const startServer = () => {
  const onRequest =  (request,response) => {
      console.log("Received request");
      response.writeHead(200, "Server Up", { "content-type": "text/plain" });
      response.write("Hello From Server");
      response.end();
  }

http.createServer(onRequest).listen(8000) ;
console.log("Server running at port:8000");
}
exports.startServer = startServer