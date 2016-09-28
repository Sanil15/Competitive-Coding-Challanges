/**
 * Created by jains on 8/20/2016.
 */

var request = require('request');

module.exports = function (app) {

    app.get("/api/project/data", getData)
    app.post("/api/project/data",postData)

    // Easy REST Get call to HubSpot API
    function getData(req,res) {

        request({
            url: 'https://candidate.hubteam.com/candidateTest/v1/partners?userKey=56f7b9de36e3bc2ddcff1e443039',
            method: 'GET',
        }, function(error, response, body){
            if(error) {
                console.log("Error")
                console.log(error);
            } else {
                console.log(response.statusCode);
                var data = JSON.parse(body);
                res.json(data);
            }
        });

    }

    // EASY Rest Post call to HubSpot Api
    function postData(req,res) {
        var query = req.body;
        request({
            json:query,
            url: 'https://candidate.hubteam.com/candidateTest/v1/results?userKey=56f7b9de36e3bc2ddcff1e443039',
            method: 'Post'
        }, function(error, response, body){
            if(error) {
                console.log(error);
            } else {
                console.log("Done");
                console.log(response.statusCode);
                res.json(body);
            }
        });
    }
    

}