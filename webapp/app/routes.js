var express = require("express");
var http = require("http");
var router = express.Router();

var myData = []

router.get("/", function(req,res){
    console.log("I am on start page");
    res.render("index");
});

router.get("/details", function(req,resa){
    var cpath = req.query.cpath;
    var options = {
        host: '172.19.0.5',
        port: 8080,
        path: '/cources/' + cpath,
        method: 'GET'
      };
    var responseBody = "";
    http.request(options, function(res) {
    console.log('STATUS: ' + res.statusCode);
    console.log('HEADERS: ' + JSON.stringify(res.headers));
    res.setEncoding('utf8');

    res.once('data', function (chunk) {
             console.log(chunk);
         });
    

    res.on('data', function (chunk) {
        console.log(`--chunk--'  ${chunk.length}`);
        responseBody += chunk;
    });

    res.on('end', function (chunk) {
        
        responseBody = JSON.parse(responseBody);
        resa.render("details",  {'courselist' : responseBody });
        });
        
      }).end();
    console.log("I am on details page for cpath:" + cpath);
    
});


router.get("/sentiment", function(req,resa){
    var cpath = req.query.cpath;
    var options = {
        host: '172.19.0.6',
        port: 8082,
        path: '/cources/' + cpath,
        method: 'GET'
      };
    var responseBody = "";
    http.request(options, function(res) {
    console.log('STATUS: ' + res.statusCode);
    console.log('HEADERS: ' + JSON.stringify(res.headers));
    res.setEncoding('utf8');

    res.once('data', function (chunk) {
             console.log(chunk);
         });
    

    res.on('data', function (chunk) {
        console.log(`--chunk--'  ${chunk.length}`);
        responseBody += chunk;
    });

    res.on('end', function (chunk) {
        responseBody = JSON.parse(responseBody);
        resa.render("sentiment",  {'courselist' : responseBody });
        });
        
      }).end();
    console.log("I am on sentiment page for coursecode:" + cpath);
    
});


module.exports = router;
