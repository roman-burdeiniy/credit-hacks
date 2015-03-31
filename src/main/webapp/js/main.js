/**
 * Created by roman_b on 11/14/2014.
 */
$(document).ready(function() {
    $("#sendSMS").button();
    $("#submit").button();
    $("#registrationLink").click(function(e){
        e.preventDefault();
        e.stopImmediatePropagation();
        $("#mainSection").trigger("registrationClick");
    });
});


