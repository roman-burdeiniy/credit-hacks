/**
 * Created by roman_b on 3/24/2015.
 */
$(document).ready(function() {
    $("#logoutButton").button();
});

var clientCabinetApp = angular.module('clientCabinetApp', ['clientCabinetServices', 'clientCabinetControllers']);
