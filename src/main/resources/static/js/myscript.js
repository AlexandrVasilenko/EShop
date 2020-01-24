window.onload = validationAdminButton;

var url_string = window.location.href;
var url = new URL(url_string);
var userIsAdmin = url.searchParams.get("auth");


function validationAdminButton(){
    if (userIsAdmin == true){
        document.getElementById("AdminButton").disabled = false;
    }

}
