package view;

import java.util.Scanner;


/**
 * 
 * @author Gopal Gupta 
 * Shopping Cart InputView Code
 * copyright GET2020
 */
public class InputView {
	Scanner scanner = new Scanner(System.in);
	
	/**
	 * Take string input and check correct or not in integer form
	 * @return integer value
	 */
	public int returnOptionNumber(){
		System.out.print("Enter Your Option: ");
		String option = scanner.nextLine();
		return convertStringToInt(option);
	}
	
	/**
	 * Take string input and check correct or not in integer form
	 * @return integer value
	 */
	public int getProductID(){
		System.out.print("Enter Product ID: ");
		String productID = scanner.nextLine();
		return convertStringToInt(productID);
	}
	
	/**
	 * Take string input and check correct or not in integer form
	 * @return integer value
	 */
	public int getProductQuantity(){
		System.out.print("Enter Product Quantity: ");
		String productQuantity = scanner.nextLine();
		return convertStringToInt(productQuantity);
	}
	
	/**
	 * 
	 * @param inputValue
	 * @return converted integer value or -1 if not an integer value
	 */
	int convertStringToInt(String inputValue){
		if(isIntegerValue(inputValue)){
			return -1;
		}
		int integerValue=0;
		int length = inputValue.length();
		for(int index=0;index<length;index++){
			integerValue += (inputValue.charAt(index)-48) * pow(10,length-1-index);
		}
		return integerValue;
	}
	
	/**
	 * 
	 * @param inputValue
	 * @return true if string is convertable into integer
	 */
	boolean isIntegerValue(String inputValue){
		int length = inputValue.length();
		for(int index=0;index<length;index++){
			if(!(inputValue.charAt(index)<='0' && inputValue.charAt(index)>='9')){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param X
	 * @param Y
	 * @return to get the y power of x
	 */
	int pow(int X, int Y){
		int powerIs = 1;
		for(int i=0;i<Y;i++){
			powerIs *= X;
		}
		return powerIs;
	}
}
