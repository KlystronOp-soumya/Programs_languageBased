var server = require('./server');
var router = require('./router');
var handler = require('./handler');

var handle = {};
handle["/"] = handler.home;
handle["/cal"] = handler.cal;

server.startserver(router.route,handle);