if (localStorage.getItem("vehicle") == null) {
    location.replace("vehicle.html");
}
var currencyType = "INR";
var price = [
    [5, 100, 500],
    [10, 200, 1000],
    [20, 500, 3500]
];
var USD_RATE = 0.014;
var YEN_RATE = 1.53;
var vehicleType = localStorage.getItem("vehicle");
var selectedTypeRate = 1;
var selectedCurrency;
changeCurrency();

function changeCurrency() {
    if (vehicleType == "Cycle") {
        vehicleType = 0;
    } else if (vehicleType == "Bike") {
        vehicleType = 1;
    } else if (vehicleType == "Car") {
        vehicleType = 2;
    }
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
    document.getElementById("priceRate").innerHTML = payableAmount.toFixed(2) + selectedCurrency;
    document.getElementsByClassName("planDetail")[0].style.display = "none";
    document.getElementsByClassName("priceDetail")[0].style.display = "block";
}