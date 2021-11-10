
function route(handle,parsedUrl,request,response){
    var pathname = parsedUrl.pathname ;
	//console.log("Routing a reqest for " + pathname);
	if(typeof handle[pathname] === 'function'){
		handle[pathname](request.method,response,parsedUrl);
	}else{
		//console.log("No handler for " + pathname);
		response.writeHead(404,{"Content-Type": "text/plain"});
		response.write("Error 404 page not found");
		response.end();
	}
}
exports.route = route;