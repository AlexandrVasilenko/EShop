

var url_string = window.location.href;
var url = new URL(url_string);
var isUserAuthorized = url.searchParams.get("error");
var adminButtonValidator = url.searchParams.get("isAdmin");


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

var registrationError = function() {
    if (document.getElementById('password').value ==
      document.getElementById('confirm_password').value) {
      document.getElementById('message').style.color = 'green';
      document.getElementById('message').innerHTML = 'matching';
      document.getElementById('signup-submit').disabled = false;
    } else {
      document.getElementById('message').style.color = 'red';
      document.getElementById('message').innerHTML = 'not matching';
      document.getElementById('signup-submit').disabled = true;
    }
  }