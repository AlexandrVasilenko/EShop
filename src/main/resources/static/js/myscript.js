

var url_string = window.location.href;
var url = new URL(url_string);
var userIsAdmin = url.searchParams.get("auth");

var adminButtonValidator = document.getElementById("adminButtonValidator").value;


function validationAdminButton(){
    if (adminButtonValidator == "true"){
        document.getElementById("AdminButton").disabled = false;
    } 
}
