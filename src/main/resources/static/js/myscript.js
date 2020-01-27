

var url_string = window.location.href;
var url = new URL(url_string);
var isUserAuthorized = url.searchParams.get("error");

var adminButtonValidator = document.getElementById("adminButtonValidator").value;


function validationAdminButton(){
    if (adminButtonValidator == "true"){
        document.getElementById("AdminButton").disabled = false;
    } 
}

function authorizationError(){
    if (isUserAuthorized == "true"){
            document.getElementById("invalidLoginNotifictation").style.display = "block";
    }
}
