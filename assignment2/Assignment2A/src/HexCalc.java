import java.util.Scanner;


/**
 * @author Gopal Gupta
 * Program to Perform Arithmetic Operation
 * And Conversion  on HexaDecimal Values
 * 
 */
public class HexCalc {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int firstDecimalNumber = 0, secondDecimalNumber = 0;
		int decimalNumber = 0;
		int base = 16; // Conversion Base Value
		String firstHexaDecimalNumber = "", secondHexaDecimalNumber = "";
		String number = "";

		Arithmetic arithmeticOperation = new Arithmetic();
		while (true) {

			System.out.println("\nPlase Choose any Option");
			System.out.println("1: Addition");
			System.out.println("2: Substraction");
			System.out.println("3: Multiplication");
			System.out.println("4: Division");
			System.out.println("5: Comparision");
			System.out.println("6: HexaDecimal to Decimal");
			System.out.println("7: Decimal to HexaDecimal");
			System.out.println("8: Exit");
			System.out.print("Option : ");
			int option = scanner.nextInt();
			int hexaDecimalToDecimal = 6;
			int decimalToHexaDecimal = 7;
			int divisionOption = 4;
			
			// For Decimal To HexaDecimal Conversion Option
			// read 1 string and check whether string is hexadecimal or not
			if (option == hexaDecimalToDecimal) {
				boolean isHexaDecimal;
				System.out.print("Enter The HexaDecimal Number: ");
				number = scanner.next();
				isHexaDecimal = arithmeticOperation.isHexaDecimal(
						number);
				if (!(isHexaDecimal)){
					System.out.println("Sorry This is Not HexaDecimal ValueTry Again");
					System.out.println("Try Again");
					continue;
				}
			}
			
			// For Decimal To HexaDecimal Conversion Option
			// Here we read one integer only
			else if (option == decimalToHexaDecimal) {
				System.out.print("Enter The Decimal Number: ");
				decimalNumber = scanner.nextInt();
			}
			
			// For Option Addition, Subtraction, Multiplication, Comparison Option 
			// read 2 strings and check whether strings are hexadecimal or not
			// convert hexadecimal to decimal
			else {
				boolean isHexaDecimal;
				
				// read string1, verify string1 is hexadecimal or not
				// convert hexadecimal to decimal
				if(option == divisionOption){
					System.out.print("Enter The Dividend: ");
				}
				else{
					System.out.print("Enter The First Number: ");
				}
				firstHexaDecimalNumber = scanner.next();
				isHexaDecimal = arithmeticOperation.isHexaDecimal(firstHexaDecimalNumber);
				if (!(isHexaDecimal)){
					System.out.println("Sorry This is Not HexaDecimal Value");
					System.out.println("\nTry Again");
					continue;
				}
				firstDecimalNumber = arithmeticOperation.conversionInDecimal(
						firstHexaDecimalNumber, base);
				
				if(option == divisionOption){
					System.out.print("Enter The Divisor: ");
				}
				else{
					System.out.print("Enter The Second Number: ");
				}
				secondHexaDecimalNumber = scanner.next();
				isHexaDecimal = arithmeticOperation.isHexaDecimal(secondHexaDecimalNumber);
				if (!(isHexaDecimal)){
					System.out.println("Sorry This is Not HexaDecimal Value");
					System.out.println("Try Again");
					continue;
				}
				secondDecimalNumber = arithmeticOperation.conversionInDecimal(
						secondHexaDecimalNumber, base);
			}
			// To Store Returned Value By Functions
			int result;
			String reverseConvertedValue;
			switch (option) {
				
			
				case 1:// For Addition
					result = arithmeticOperation.Addition(firstDecimalNumber,
							secondDecimalNumber);
					reverseConvertedValue = arithmeticOperation
							.reverseConversionFromDecimal(result, base);
					System.out.println("Addition Is: " + reverseConvertedValue);
					break;
				
				
				case 2:// For Subtraction 
					result = arithmeticOperation.Subtraction(firstDecimalNumber,
							secondDecimalNumber);
					if(result < 0){
						result = result * (-1); // To Convert Negative to Positive
						reverseConvertedValue = arithmeticOperation
								.reverseConversionFromDecimal(result, base);
						System.out.println("Subtraction  Is: -" + reverseConvertedValue);
					}
					else if(result == 0){
						System.out.println("Subtraction Is: Zero");
					}
					else{
						reverseConvertedValue = arithmeticOperation
								.reverseConversionFromDecimal(result, base);
						System.out.println("Subtraction Is: " + reverseConvertedValue);
					}
					break;
				
				
				case 3:// For Multiplication
					result = arithmeticOperation.Multiplication(firstDecimalNumber,
							secondDecimalNumber);
					reverseConvertedValue = arithmeticOperation
							.reverseConversionFromDecimal(result, base);
					System.out.println("Multiplication Is: "
							+ reverseConvertedValue);
					break;
				
				
				case 4:// For Division
					result = arithmeticOperation.division(firstDecimalNumber,
							secondDecimalNumber);
					
					if(result == 0){
						System.out.println("Sorry Divisior Can't Be Grater");
						break;
					}
					reverseConvertedValue = arithmeticOperation
							.reverseConversionFromDecimal(result, base);
					int reminder = arithmeticOperation.reminder(firstDecimalNumber,
							secondDecimalNumber);
					System.out.println("Quotient Is: " + reverseConvertedValue +" And Reminder Is: "+ reminder);
					break;
	
					
				case 5:// For Comparison
					if (arithmeticOperation.string1IsGreaterThenString2(firstHexaDecimalNumber, secondHexaDecimalNumber)) {
						System.out.println(firstHexaDecimalNumber + " Is Greater Then " + secondHexaDecimalNumber);
					}
					else if (arithmeticOperation.string1IsLessThenString2(firstHexaDecimalNumber, secondHexaDecimalNumber)) {
						System.out.println(secondHexaDecimalNumber + " Is Greater Then " + firstHexaDecimalNumber);
					}
					else {
						System.out.println(firstHexaDecimalNumber + " And " + secondHexaDecimalNumber
								+ " Both are equal");
					}
					break;
					
					
				case 6:// For HexaDecimal To Decimal Conversion
					result = arithmeticOperation.conversionInDecimal(number, base);
					System.out.println("Decimal Value Is: " + result);
					break;
					
					
				case 7:// For Decimal To HexaDecimal Conversion
					reverseConvertedValue = arithmeticOperation
							.reverseConversionFromDecimal(decimalNumber, base);
					System.out.println("HexaDecimal Value Is: "
							+ reverseConvertedValue);
					break;
					
					
				case 8:// Exit Frpm The Program
					scanner.close();
					System.exit(0);
					
					
				default:
					System.out.println("Please Select Correct Option");
			}
		}

	}
}
