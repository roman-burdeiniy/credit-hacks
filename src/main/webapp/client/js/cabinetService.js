/**
 * Created by roman_b on 3/30/2015.
 */
var clientCabinetServices = angular.module('clientCabinetServices', ['ngResource']);

clientCabinetServices.factory('LoggedInUserInfo', ['$resource',
    function($resource){
        return $resource('/resources/loggedInUser', {}, {
            query: {method:'GET'}
        });
    }]);
