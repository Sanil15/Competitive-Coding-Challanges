/**
 * Created by jains on 8/20/2016.
 */

(function () {

    'use-strict';

    angular
        .module("HubSpotApp")
        .factory("DataService",DataService);

    function DataService($rootScope,$http) {

        var api = {
            getData:getData,
            postData:postData
        };

        return api;

        function getData() {
            return $http.get("/api/project/data");
        }

        function postData(data) {
            return $http.post("/api/project/data",data);
        }
    }

})();