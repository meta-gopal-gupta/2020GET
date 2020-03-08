var currencyType = "INR";
var price = [
    [5, 100, 500],
    [10, 200, 1000],
    [20, 500, 3500]
];
var USD_RATE = 0.014;
var YEN_RATE = 1.53;
var selectedTypeRate = 1;
var selectedCurrency;
var vehicleType;
function changeCurrency(vehicleTypeName) {
	
    if (vehicleTypeName == "Cycle") {
        vehicleType = 0;
    } else if (vehicleTypeName == "Bicycle") {
        vehicleType = 1;
    } else if (vehicleTypeName == "Car") {
        vehicleType = 2;
    }

    var currencyType = document.getElementById("currencyType").value;

    
    if (currencyType == "USD") {
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
        
    } else {
        document.getElementById("dailyPriceRate").innerHTML = price[vehicleType][0] + " INR";
        document.getElementById("monthlyPriceRate").innerHTML = price[vehicleType][1] + " INR";
        document.getElementById("yearlyPriceRate").innerHTML = price[vehicleType][2] + " INR";
        selectedTypeRate = 1;
        selectedCurrency = " INR";
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
}