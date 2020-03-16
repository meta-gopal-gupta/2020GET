String.prototype.repeatify = function(number) {
    var str = this;
    var resultString = this;
    for (var i = 0; i < number - 1; i++) {
        resultString += str;
    }
    return resultString;
}

console.log("hello".repeatify(3));