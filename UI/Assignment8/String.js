function findString(inputString) {
    var consecutiveRepeated = false;
    console.log(inputString);
    var str;
    for (var i = 1; i < inputString.length; i++) {
        if (inputString[i] == inputString[i - 1]) {
            consecutiveRepeated = true;
            break;
        }
    }
    if (consecutiveRepeated == true) {
        str = inputString.substring(0, i - 1);
        str += inputString.substring(i + 1, inputString.length);
        return findString(str);
    } else {
        return inputString;
    }
}

findString("eeabcddcbfgf");