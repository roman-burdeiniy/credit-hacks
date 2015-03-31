/**
 * Created by roman_b on 11/14/2014.
 */
$(document).ready(function() {
    $("#mainContentSection").load('main.html', function(){
        $("#mainContentSection").on("registrationClick", function(e){
            $(this).load('registration.html');
        });
    });

});
