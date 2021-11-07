let server = require("./server")
let route = require("./route")
let handler = require("./handler");

handle={};
handle["/home"] = handler.home;//stores the function
handle["/review"] = handler.review ;


server.startServer(route.router,handle);