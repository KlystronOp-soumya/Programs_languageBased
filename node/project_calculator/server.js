/* Module to up the server and pass the request*/

var http = require('http');
var url = require('url');
var querystring = require('querystring');
function startserver(route, handle){
	function onRequest(request,response){
		var reviewData = "";
		//var pathname = url.parse(request.url).pathname;
        var parsedUrl=url.parse(request.url);
        route(handle,parsedUrl,request,response);
		//console.log("Request received for " + pathname);
		request.setEncoding("utf8");
	}
	http.createServer(onRequest).listen(8888);
	console.log("Server started on localhost port 8888");
}
exports.startserver = startserver;