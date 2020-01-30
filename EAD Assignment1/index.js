var currencyType = "INR";
var price = [
    [5, 100, 500],
    [10, 200, 1000],
    [20, 500, 3500]
];
var USD_RATE = 0.014;
var YEN_RATE = 1.53;
var vehicleType = 1;
var selectedTypeRate = 1;
var selectedCurrency;

function checkValidation() {
    var name = document.getElementById('name').value;
    var email = document.getElementById("email").value;
    var mobile = document.getElementById("mobile").value;
    var password = document.getElementById("password").value;
    var rePassword = document.getElementById("rePassword").value;

    document.getElementById("nameField").style.borderColor = "black";
    document.getElementById("nameField").style.color = "black";
    document.getElementById("emailField").style.borderColor = "black";
    document.getElementById("emailField").style.color = "black";
    document.getElementById("mobileField").style.borderColor = "black";
    document.getElementById("mobileField").style.color = "black";

    document.getElementById("passwordField").style.borderColor = "black";
    document.getElementById("passwordField").style.color = "black";
    document.getElementById("rePasswordField").style.borderColor = "black";
    document.getElementById("rePasswordField").style.color = "black";


    if (name.length < 1) {
        document.getElementById("nameField").style.borderColor = "red";
        document.getElementById("nameField").style.color = "red";
    }
    if (email.length < 1) {
        document.getElementById("emailField").style.borderColor = "red";
        document.getElementById("emailField").style.color = "red";
    }
    if (mobile.length < 1) {
        document.getElementById("mobileField").style.borderColor = "red";
        document.getElementById("mobileField").style.color = "red";
    }
    if (password.length < 1) {
        document.getElementById("passwordField").style.borderColor = "red";
        document.getElementById("passwordField").style.color = "red";
    }
    if (rePassword.length < 1) {
        document.getElementById("rePasswordField").style.borderColor = "red";
        document.getElementById("rePasswordField").style.color = "red";
    } else if (password != rePassword) {
        document.getElementById("rePasswordField").style.borderColor = "red";
        document.getElementById("rePasswordField").style.color = "red";
        alert("Both Password are not same \nPlease Enter Again");
    } else if (!(name.length < 1 && email.length < 1 && mobile.length < 1 && password.length < 1 && rePassword.length < 1)) {

        document.getElementsByClassName("process")[0].style.color = "green";
        document.getElementsByClassName("process")[0].innerHTML = "Employee Detail - Completed";
        document.getElementsByClassName("employeeDetail")[0].style.display = "none";
        document.getElementsByClassName("vehicleDetail")[0].style.display = "block";
    }
}

function checkVehicleDetailValidation() {
    var vehicleName = document.getElementById('vehicleName').value;
    var vehicleCategory = document.getElementById("vehicleType").value;
    var vehicleNumber = document.getElementById("vehicleNumber").value;
    var employeeId = document.getElementById("employeeId").value;
    var vehicleDiscription = document.getElementById("vehicleDiscription").value;

    document.getElementById("vehicleCompanyNameField").style.borderColor = "black";
    document.getElementById("vehicleCompanyNameField").style.color = "black";
    document.getElementById("vehicleTypeField").style.borderColor = "black";
    document.getElementById("vehicleTypeField").style.color = "black";
    document.getElementById("vehicleNumberField").style.borderColor = "black";
    document.getElementById("vehicleNumberField").style.color = "black";
    document.getElementById("vehicleDiscriptionField").style.borderColor = "black";
    document.getElementById("vehicleDiscriptionField").style.color = "black";

    if (vehicleName.length < 1) {
        document.getElementById("vehicleCompanyNameField").style.borderColor = "red";
        document.getElementById("vehicleCompanyNameField").style.color = "red";
    }
    if (vehicleCategory == "Select Vehicle") {
        document.getElementById("vehicleTypeField").style.borderColor = "red";
        document.getElementById("vehicleTypeField").style.color = "red";
    }
    if (vehicleNumber.length < 1) {
        document.getElementById("vehicleNumberField").style.borderColor = "red";
        document.getElementById("vehicleNumberField").style.color = "red";
    }
    if (vehicleDiscription.length < 1) {
        document.getElementById("vehicleDiscriptionField").style.borderColor = "red";
        document.getElementById("vehicleDiscriptionField").style.color = "red";
    } else
    if (!(vehicleName.length < 1 && vehicleCategory == "Select Vehicle" && vehicleNumber.length < 1 && vehicleDiscription.length < 1)) {

        document.getElementsByClassName("process")[1].style.color = "green";
        document.getElementsByClassName("process")[1].innerHTML = "Vehicle Detail - Completed";
        document.getElementsByClassName("planDetail")[0].style.display = "block";
        document.getElementsByClassName("vehicleDetail")[0].style.display = "none";
        changeCurrency();
    }




    var vehicleType = document.getElementById("vehicleType").value;

    if (vehicleType == "Cycle") {
        vehicleType = 0;
    } else if (vehicleType == "Bicycle") {
        vehicleType = 1;
    } else if (vehicleType == "Car") {
        vehicleType = 2;
    }



}

function changeCurrency() {

    var currencyType = document.getElementById("currencyType").value;

    if (currencyType == "INR") {
        document.getElementById("dailyPriceRate").innerHTML = price[vehicleType][0] + " INR";
        document.getElementById("monthlyPriceRate").innerHTML = price[vehicleType][1] + " INR";
        document.getElementById("yearlyPriceRate").innerHTML = price[vehicleType][2] + " INR";
        selectedTypeRate = 1;
        selectedCurrency = " INR";
    } else if (currencyType == "USD") {
        document.getElementById("dailyPriceRate").innerHTML = (price[vehicleType][0] * USD_RATE).toFixed(2) + " USD";
        document.getElementById("monthlyPriceRate").innerHTML = (price[vehicleType][1] * USD_RATE).toFixed(2) + " USD";
        document.getElementById("yearlyPriceRate").innerHTML = (price[vehicleType][2] * USD_RATE).toFixed(2) + " USD";
        selectedTypeRate = USD_RATE;
        selectedCurrency = " USD";

    } else if (currencyType == "YEN") {
        document.getElementById("dailyPriceRate").innerHTML = (price[vehicleType][0] * YEN_RATE).toFixed(2) + " YEN";
        document.getElementById("monthlyPriceRate").innerHTML = (price[vehicleType][1] * YEN_RATE).toFixed(2) + " YEN";
        document.getElementById("yearlyPriceRate").innerHTML = (price[vehicleType][2] * YEN_RATE).toFixed(2) + " YEN";
        selectedTypeRate = YEN_RATE;
        selectedCurrency = " YEN";
    }
}

function calculateMoney() {
    if (document.getElementById("daily").checked) {
        var payableAmount = price[vehicleType][0] * selectedTypeRate;

    } else if (document.getElementById("monthly").checked) {
        var payableAmount = price[vehicleType][1] * selectedTypeRate;
    } else if (document.getElementById("yearly").checked) {
        var payableAmount = price[vehicleType][2] * selectedTypeRate;
    }
    document.getElementsByClassName("planDetail")[0].style.display = "none";
    document.getElementsByClassName("priceDetail")[0].style.display = "block";
    document.getElementById("priceRate").innerHTML = payableAmount.toFixed(2) + selectedCurrency;
    document.getElementsByClassName("process")[2].innerHTML = "Vehicle Pricing - Completed";
    document.getElementsByClassName("process")[2].style.color = "green";
}