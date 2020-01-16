import java.util.Scanner;

/**
 * @author Gopal Gupta
 * Program to Perform Comparison, Reverse, Lower to Upper case,
 * Upper to Lower Case Conversion and Maximum Length Word in String
 * 
 */
public class MainOfStringOperation {
	public static void main(String[] args){
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("|  Program to Perform Comparison, Reverse, Lower to Upper case, Upper      |");
		System.out.println("|  to Lower Case Conversion and to find Maximum Length Word in String      |");
		System.out.println("----------------------------------------------------------------------------");
		
		
		Scanner scanner = new Scanner(System.in);
		String String1 ;
		String String2 ;
		TaskOnString a = new TaskOnString();
		
		System.out.print("Please Enter First String :");
		String1 = scanner.nextLine();
		System.out.print("Please Enter Second String :");
		String2 = scanner.nextLine();
		
		boolean isStringsSame = a.comparisonOfString(String1, String2);
		
		String reverseFirstString = a.reverseOfStrings(String1);
		String reverseSecondString = a.reverseOfStrings(String2);

		String caseConvertedFirstString = a.stringCaseConversion(String1);
		String caseConvertedSecondString = a.stringCaseConversion(String2);
		
		String maxLengthWordInFirstString = a.maxLengthWord(String1);
		String maxLengthWordInSecondString = a.maxLengthWord(String2);
		
		if(isStringsSame){
			System.out.println("Both Strings Are Same");
		}
		else{
			System.out.println("Both Strings Are Not Same");
		}
		System.out.println("\""+String1+"\" \tReverse Is\t \""+ reverseFirstString+"\"");
		System.out.println("\""+String2+"\" \tReverse Is\t \""+ reverseSecondString+"\"");

		System.out.println("\""+String1+"\" \tCase Conversion Is\t \""+caseConvertedFirstString+"\"");
		System.out.println("\""+String2+"\" \tCase Conversion Is\t \""+caseConvertedSecondString+"\"");
		

		System.out.println("Longest Length Word In \""+String1+"\" Is \""+maxLengthWordInFirstString+"\"");
		System.out.println("Longest Length Word In \""+String2+"\" Is \""+maxLengthWordInSecondString+"\"");
	
		scanner.close();
	}
}
