/**
 * Created by roman_b on 12/12/2014.
 */
$(document).ready(function() {
    $("#sendSMS").button();
    $("#submitSMS").button();
    registerToAddNewUser();
});

function registerToAddNewUser()
{
    $("#sendSMS").click(function(e){
        $("#registrationForm").bind("submit", function(e){
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#registrationForm").unbind("submit");
            var data = 'phone=' + $("#phone").val()  + '&' + "actionName=sendConfirmationSMS";
            $.post($(this).attr("action"), data, function(data, status){
                if(status == "success") {
                    $("#registrationForm .hidden").removeClass("hidden");
                    $("#registrationForm .hidden").removeClass("hidden");
                } else if(status == "failure") {
                    alert("Connection error!");
                }
            });
            return false;
        });
    });

    $("#submitSMS").click(function(e){
        $("#registrationForm").bind("submit", function(e){
            e.preventDefault();
            e.stopImmediatePropagation();
            $("#registrationForm").unbind("submit");
            var data = $(this).serialize();
            data = data + '&' + "actionName=registerNewClient";
            $.post($(this).attr("action"), data, function(data, status){
                if(status == "success") {
                } else if(status == "failure") {
                    alert("Connection error!");
                }
            });
            return false;
        });
    });
}
