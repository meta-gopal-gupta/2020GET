public class Arithmetic {

	/*
	 * HexaDecimal to Decimal Conversion
	 * @param HexaDecimal String and Conversion Base
	 * @return Decimal Converted Value
	 * 
	 * */
	int conversionInDecimal(String inputString, int baseValue) {
		int increasingBasePower = 1, decimalValue = 0, charToAscii = 0;
		for (int index = inputString.length() - 1; index >= 0; index--) {
			if (inputString.charAt(index) >= '0' && inputString.charAt(index) <= '9') {
				charToAscii = inputString.charAt(index) - 48;
			}
			else if (inputString.charAt(index) >= 'A' && inputString.charAt(index) <= 'F') {
				charToAscii = inputString.charAt(index) - 65 + 10;
			}
			else if (inputString.charAt(index) >= 'a' && inputString.charAt(index) <= 'f') {
				charToAscii = inputString.charAt(index) - 97 + 10;
			}
			
			decimalValue += charToAscii * increasingBasePower;
			increasingBasePower = increasingBasePower * baseValue;
		}
		return decimalValue;
	}
	
	/*
	 * Function To Check String Is HexaDecimal Or Not
	 * @param HexaDecimal String and Conversion Base
	 * 
	 * */
	boolean isHexaDecimal(String inputString) {
		
		for (int index = inputString.length() - 1; index >= 0; index--) {
			if (!((inputString.charAt(index) >= '0' && inputString.charAt(index) <= '9') || (inputString.charAt(index) >= 'A' && inputString.charAt(index) <= 'F') || (inputString.charAt(index) >= 'a' && inputString.charAt(index) <= 'f'))) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Decimal To HexaDecimal Conversion
	 * @param Decimal String and Conversion Base
	 * @return Decimal Converted Value
	 * 
	 * */
	String reverseConversionFromDecimal(int decimalValue, int base) {
		String convertedValue = "";
		while (decimalValue != 0) {
			int reminder = 0;
			reminder = decimalValue % base;
			if (reminder < 10) {
				convertedValue = ((char) (reminder + 48)) + convertedValue;
			}
			else {
				convertedValue = ((char) (reminder + 55)) + convertedValue;
			}
			decimalValue = decimalValue / base;
		}

		return convertedValue;
	}

	
	int Addition(int Decimal1, int Decimal2) {
		return Decimal1 + Decimal2;
	}

	int Subtraction(int Decimal1, int Decimal2) {
		return Decimal1 - Decimal2;
	}

	int Multiplication(int Decimal1, int Decimal2) {
		return Decimal1 * Decimal2;
	}

	int division(int Decimal1, int Decimal2) {
		return (int) (Decimal1 / Decimal2);
	}
	int reminder(int Decimal1, int Decimal2) {
		return (int) (Decimal1 % Decimal2);
	}

	boolean string1IsGreaterThenString2(String string1, String string2) {
		if (string1.length() > string2.length()) {
			return true;
		}
		else {
			for (int index = 0; index < string1.length(); index++) {
				if (string1.charAt(index) > string2.charAt(index)) {
					return true;
				}

			}
		}
		return false;
	}

	boolean string1IsLessThenString2(String string1, String string2) {
		if (string1.length() < string2.length()) {
			return true;
		}
		else {
			for (int index = 0; index < string1.length(); index++) {
				if (string1.charAt(index) < string2.charAt(index)) {
					return true;
				}

			}
		}
		return false;
	}
}
