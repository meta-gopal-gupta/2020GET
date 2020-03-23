if (localStorage.getItem("vehicle") == null) {
    location.replace("vehicle.html");
}

var currencyType:string = "INR";
var price:number[][] = [
    [5, 100, 500],
    [10, 200, 1000],
    [20, 500, 3500]
];
const USD_RATE:number = 0.014;
const YEN_RATE:number = 1.53;
let vehicleType:any = localStorage.getItem("vehicle");
let selectedTypeRate:number = 1;
let selectedCurrency:string;

changeCurrency();

function changeCurrency() {


    if (vehicleType == "Cycle") {
        vehicleType = 0;
    } else if (vehicleType == "Bike") {
        vehicleType = 1;
    } else if (vehicleType == "Car") {
        vehicleType = 2;
    }

    var currencyType = (<HTMLInputElement>document.getElementById("currencyType")).value;

    if (currencyType == "INR") {
        (<HTMLInputElement>document.getElementById("dailyPriceRate")).innerHTML = price[vehicleType][0] + " INR";
        (<HTMLInputElement>document.getElementById("monthlyPriceRate")).innerHTML = price[vehicleType][1] + " INR";
        (<HTMLInputElement>document.getElementById("yearlyPriceRate")).innerHTML = price[vehicleType][2] + " INR";
        selectedTypeRate = 1;
        selectedCurrency = " INR";
    } else if (currencyType == "USD") {
        (<HTMLInputElement>document.getElementById("dailyPriceRate")).innerHTML = (price[vehicleType][0] * USD_RATE).toFixed(2) + " USD";
        (<HTMLInputElement>document.getElementById("monthlyPriceRate")).innerHTML = (price[vehicleType][1] * USD_RATE).toFixed(2) + " USD";
        (<HTMLInputElement>document.getElementById("yearlyPriceRate")).innerHTML = (price[vehicleType][2] * USD_RATE).toFixed(2) + " USD";
        selectedTypeRate = USD_RATE;
        selectedCurrency = " USD";

    } else if (currencyType == "YEN") {
        (<HTMLInputElement>document.getElementById("dailyPriceRate")).innerHTML = (price[vehicleType][0] * YEN_RATE).toFixed(2) + " YEN";
        (<HTMLInputElement>document.getElementById("monthlyPriceRate")).innerHTML = (price[vehicleType][1] * YEN_RATE).toFixed(2) + " YEN";
        (<HTMLInputElement>document.getElementById("yearlyPriceRate")).innerHTML = (price[vehicleType][2] * YEN_RATE).toFixed(2) + " YEN";
        selectedTypeRate = YEN_RATE;
        selectedCurrency = " YEN";
    }
}

function calculateMoney() {
    if ((<HTMLInputElement>document.getElementById("daily")).checked) {
        var payableAmount = price[vehicleType][0] * selectedTypeRate;

    } else if ((<HTMLInputElement>document.getElementById("monthly")).checked) {
        var payableAmount = price[vehicleType][1] * selectedTypeRate;
    } else if ((<HTMLInputElement>document.getElementById("yearly")).checked) {
        var payableAmount = price[vehicleType][2] * selectedTypeRate;
    }
    (<HTMLInputElement>document.getElementById("priceRate")).innerHTML = payableAmount.toFixed(2) + selectedCurrency;
    (<HTMLInputElement>document.getElementsByClassName("planDetail")[0]).style.display = "none";
    (<HTMLInputElement>document.getElementsByClassName("priceDetail")[0]).style.display = "block";
}