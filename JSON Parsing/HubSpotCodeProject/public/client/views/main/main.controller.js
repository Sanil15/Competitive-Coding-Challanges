/**
 * Created by jains on 8/20/2016.
 */

(function (){

    angular
        .module("HubSpotApp")
        .controller("MainController",MainController);

    function MainController($scope,$location) {
        $scope.$location=$location;
    }

})();