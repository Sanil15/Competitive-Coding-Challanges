var express = require('express');
var app = express();

// load bodyParser
var bodyParser = require('body-parser');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

// load cookie parsers
var cookieParser = require('cookie-parser');

// configure cookie parser - needed for oauth
app.use(cookieParser());

// configure a public directory to host static content
app.use(express.static(__dirname + '/public'));


require ("./public/server/app")(app);

var ipaddress = process.env.OPENSHIFT_NODEJS_IP;
var port      = process.env.OPENSHIFT_NODEJS_PORT || 5000;

app.listen(port, ipaddress);