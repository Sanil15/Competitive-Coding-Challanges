/**
 * Created by jains on 8/20/2016.
 */

(function () {

    'use-strict'

    angular
        .module("HubSpotApp")
        .config(Configure);

    function Configure($routeProvider){
        $routeProvider
            .when("/home",{
                templateUrl: "views/home/home.view.html",
                controller: "HomeController",
                controllerAs:"model"
            })
            .otherwise({
                redirectTo: "/home"
            });
    }

})();