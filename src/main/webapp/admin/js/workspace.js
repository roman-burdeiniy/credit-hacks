/**
 * Created by roman_b on 3/24/2015.
 */
$(document).ready(function() {
    $("#logoutButton").button();
    loadCurrentUser();
});

function loadCurrentUser(){
    $.get( "resources/loggedInUser", function(data) {
        $("#name").val(data.username);
        $("#name").val(data.username);
    });
}