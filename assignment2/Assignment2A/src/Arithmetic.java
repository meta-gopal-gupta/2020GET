import java.util.Scanner;

public class Arithmetic {

	Scanner scanner = new Scanner(System.in);
	
	/*
	 * HexaDecimal to Decimal Conversion
	 * @param HexaDecimal String and Conversion Base
	 * @return Decimal Converted Value
	 * 
	 * */
	int conversionInDecimal(String s, int base) {
		int b = 1, x = 0, charToAscii = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				charToAscii = s.charAt(i) - 48;
			}
			else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'F') {
				charToAscii = s.charAt(i) - 65 + 10;
			}
			else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'f') {
				charToAscii = s.charAt(i) - 97 + 10;
			}
			
			x += charToAscii * b;
			b = b * base;
		}
		return x;
	}
	
	/*
	 * Function To Check String Is HexaDecimal Or Not
	 * @param HexaDecimal String and Conversion Base
	 * 
	 * */
	boolean isHexaDecimal(String s) {
		
		for (int i = s.length() - 1; i >= 0; i--) {
			if (!((s.charAt(i) >= '0' && s.charAt(i) <= '9') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'F') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'f'))) {
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
		String convert = "";
		while (decimalValue != 0) {
			int temp = 0;
			temp = decimalValue % base;
			if (temp < 10) {
				convert = ((char) (temp + 48)) + convert;
			}
			else {
				convert = ((char) (temp + 55)) + convert;
			}
			decimalValue = decimalValue / base;
		}

		return convert;
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
			for (int i = 0; i < string1.length(); i++) {
				if (string1.charAt(i) > string2.charAt(i)) {
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
			for (int i = 0; i < string1.length(); i++) {
				if (string1.charAt(i) < string2.charAt(i)) {
					return true;
				}

			}
		}
		return false;
	}
}
