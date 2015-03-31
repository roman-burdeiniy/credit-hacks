/**
 * Created by roman_b on 3/30/2015.
 */
var clientCabinetControllers = angular.module('clientCabinetControllers', []);

clientCabinetControllers.controller('LoggedInUserController',['$scope', '$http', 'LoggedInUserInfo',
    function ($scope, $http, LoggedInUserInfo) {
        LoggedInUserInfo.get({}, function(data){
            $scope.user = data;
        });
        $scope.logout = function() {
            $http.post('/logout').success(function() {
                window.location.replace("../index.html");
            });
        };
    }]);