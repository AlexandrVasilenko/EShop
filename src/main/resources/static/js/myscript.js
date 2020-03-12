

var url_string = window.location.href;
var url = new URL(url_string);
var isUserAuthorized = url.searchParams.get("error");
var adminButtonValidator = url.searchParams.get("isAdmin");
var timeReserve = document.getElementById("timeReserve").innerHTML;
var timeLeft = parseInt(timeReserve,10);


function validationAdminButton() {
  if (adminButtonValidator == "true") {
    document.getElementById("AdminButton").disabled = false;
  }
}

function authorizationError() {
  if (isUserAuthorized == "true") {
    document.getElementById("invalidLoginNotifictation").style.display = "block";
  }
}

var registrationError = function () {
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

function validationTime() {
  if (timeLeft < 0) {
    document.getElementById("buyButton").disabled = true;
  } else {
    document.getElementById("buyButton").disabled = false;
  }
}

function calculationTimeLeft(id) {
  var matchingId = id.split(/abilityList(.*?).obtained/);
  var priceElementId = "abilityList" + matchingId[1] + ".Price";
  timeCostFromField = document.getElementById(priceElementId).value;
  if (document.getElementById(id).checked == true) {
    timeLeft = timeLeft - parseInt(timeCostFromField,10);
    document.getElementById("timeReserve").innerHTML = timeLeft;
    // document.getElementById("timeReserve").value = timeLeft;
  } else {
    timeLeft = timeLeft + parseInt(timeCostFromField,10);
    document.getElementById("timeReserve").innerHTML = timeLeft;
  }
  validationTime()
}



