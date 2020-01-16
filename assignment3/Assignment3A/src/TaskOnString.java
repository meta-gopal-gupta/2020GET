public class TaskOnString {
 
	/**
	 * Comparison Of Strings
	 * @param input String s
	 * @return character case converted value
	 */
	boolean comparisonOfString(String firstString, String SecondString) {
		if (firstString.length() != SecondString.length()) {
			return false;
		}
		else {
			for (int i = 0; i < firstString.length(); i++) {
				if (firstString.charAt(i) != SecondString.charAt(i)) {
					return false;
				}
			}
			return true;
		}
	}
	/**
	 * Comparison Of Strings
	 * @param input String s
	 * @return character case converted value
	 */
	// reverse the order of string characters
	String reverseOfStrings(String s) {
		char[] charArrayOfString = s.toCharArray();
		for (int i = 0; i < charArrayOfString.length / 2; i++) {
			char temp;
			temp = charArrayOfString[i];
			charArrayOfString[i] = charArrayOfString[charArrayOfString.length - 1 - i];
			charArrayOfString[charArrayOfString.length - 1 - i] = temp;
		}
		String reverseString = new String(charArrayOfString); // Char Array To String
		return reverseString;

	}


	/**
	 * Convert the lower to upper case and upper to lower case
	 * @param input String s
	 * @return character case converted value
	 */
	String stringCaseConversion(String s) {
		char[] charArrayOfString = s.toCharArray();
		for (int i = 0; i < charArrayOfString.length; i++) {
			if (charArrayOfString[i] >= 'a' && charArrayOfString[i] <= 'z') {
				charArrayOfString[i] = (char) (charArrayOfString[i] - 32);
			}
			else if (charArrayOfString[i] >= 'A' && charArrayOfString[i] <= 'Z') {
				charArrayOfString[i] = (char) (charArrayOfString[i] + 32);
			}
		}

		String str = new String(charArrayOfString); // Char Array To String
		return str;
	}
	
	/**
	 * To find the max length word in string
	 * @param input String s
	 * @return character case converted value
	 */
	
	String maxLengthWord(String s) {

		char[] charArray = s.toCharArray();
		String maxLengthWord = "";
		int maxLength = 0, wordLength = 0;
		int i, maxLengthWordStartIndex = 0;
		for (i = 0; i < charArray.length; i++) {
			if (charArray[i] != ' ') {
				wordLength++;
			}
			else {

				if (maxLength <= wordLength) {
					maxLength = wordLength;
					maxLengthWordStartIndex = i - wordLength;
					wordLength = 0;
				}
				else {
					wordLength = 0;
				}
			}
		}
		if (maxLength <= wordLength) {
			maxLength = wordLength;
			maxLengthWordStartIndex = i - wordLength;
		}
		while (maxLengthWordStartIndex < charArray.length) {
			maxLengthWord += charArray[maxLengthWordStartIndex];
			if (charArray[maxLengthWordStartIndex] == ' '){
				break;
			}
				
			maxLengthWordStartIndex++;
		}
		return maxLengthWord;
	}

}
