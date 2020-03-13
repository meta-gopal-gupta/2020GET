public class TaskOnString {

	/**
	 * Comparison Of Strings
	 * 
	 * @param input String s
	 * @return character case converted value
	 */
	boolean comparisonOfString(String firstString, String SecondString) {
		if (firstString.length() != SecondString.length()) {
			return false;
		}
		else {
			for (int index = 0; index < firstString.length(); index++) {
				if (firstString.charAt(index) != SecondString.charAt(index)) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * reverse the order of string characters
	 * 
	 * @param input
	 *            String s
	 * @return character case converted value
	 */
	String reverseOfStrings(String inputString) {
		char[] charArrayOfString = inputString.toCharArray();
		for (int index = 0; index < charArrayOfString.length / 2; index++) {
			char temp;
			temp = charArrayOfString[index];
			charArrayOfString[index] = charArrayOfString[charArrayOfString.length
					- 1 - index];
			charArrayOfString[charArrayOfString.length - 1 - index] = temp;
		}
		String reverseString = new String(charArrayOfString); // Char Array To
																// String
		return reverseString;

	}

	/**
	 * Convert the lower to upper case and upper to lower case
	 * 
	 * @param input
	 *            String s
	 * @return character case converted value
	 */
	String stringCaseConversion(String inputString) {
		char[] charArrayOfString = inputString.toCharArray();
		for (int index = 0; index < charArrayOfString.length; index++) {
			if (charArrayOfString[index] >= 'a' && charArrayOfString[index] <= 'z') {
				charArrayOfString[index] = (char) (charArrayOfString[index] - 32);
			}
			else if (charArrayOfString[index] >= 'A' && charArrayOfString[index] <= 'Z') {
				charArrayOfString[index] = (char) (charArrayOfString[index] + 32);
			}
		}

		String str = new String(charArrayOfString); // Char Array To String
		return str;
	}

	/**
	 * To find the max length word in string
	 * 
	 * @param input String s
	 *            
	 * @return character case converted value
	 */

	String maxLengthWord(String inputString) {

		char[] charArray = inputString.toCharArray();
		String maxLengthWord = "";
		int maxLength = 0, wordLength = 0;
		int index, maxLengthWordStartIndex = 0;
		for (index = 0; index < charArray.length; index++) {
			if (charArray[index] != ' ') {
				wordLength++;
			}
			else {

				if (maxLength <= wordLength) {
					maxLength = wordLength;
					maxLengthWordStartIndex = index - wordLength;
					wordLength = 0;
				}
				else {
					wordLength = 0;
				}
			}
		}
		if (maxLength <= wordLength) {
			maxLength = wordLength;
			maxLengthWordStartIndex = index - wordLength;
		}
		while (maxLengthWordStartIndex < charArray.length) {
			maxLengthWord += charArray[maxLengthWordStartIndex];
			if (charArray[maxLengthWordStartIndex] == ' ') {
				break;
			}

			maxLengthWordStartIndex++;
		}
		return maxLengthWord;
	}

}
