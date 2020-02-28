package view;

import java.util.ArrayList;
import java.util.Iterator;
import dao.UserBucket;


/**
 * 
 * @author Gopal Gupta 
 * Shopping Cart OutputView Code
 * copyright GET2020
 */
public class OutputView {
	
	/**
	 * Display Welcome message 
	 */
	public void aboutProgram(){
		System.out.println("+-----------------------------------------------------------------+");
		System.out.println("|                        SHOPPING SERVICE                          |");
		System.out.println("|            ADD   |   REMOVE   |   UPDATE   |   DELETE           |");
		System.out.println("+-----------------------------------------------------------------+");
	}
	
	/**
	 * 
	 * @param productName
	 * @param produtPrice
	 * Display Product list and there corresponding price
	 */
	public void displayListOfProducts(String[] productName, int[] produtPrice) {
		System.out.println("+-----------------------------------------------------------------+");
		System.out.println("|\t\tSN\tProduct Name\tPrice \t \t\t  |");
		for (int productId = 0; productId < 5; productId++)
			System.out.println("|\t\t"+(productId + 1) + "\t"	+ productName[productId]+"\t\t"+ produtPrice[productId]);
		System.out.println("+-----------------------------------------------------------------+");
	}

	/**
	 * Display Operation List  
	 */
	public void displayOptions() {
		System.out.println("+-----------------------------------------------------------------+");
		System.out.println("1: Add Product in Bucket");
		System.out.println("2: Remove Product form Bucket");
		System.out.println("3: Display Orders List");
		System.out.println("4: Place the Order");
		System.out.println("5: Exit ");
		System.out.println("+-----------------------------------------------------------------+");
	}

	/**
	 * 
	 * @param userBucket
	 * Display user bucket
	 */
	public void  displayBucketProducts(ArrayList<UserBucket> userBucket) {
		Iterator<UserBucket> itrator = userBucket.iterator();
		int productID = 1;
		System.out.println("+-----------------------------------------------------------------+");
		System.out.println("\tID\tProduct Name\tQuantity\tPrice");

		while (itrator.hasNext()) {
			UserBucket itreatorIndex = (UserBucket) itrator.next();
			System.out.println("\t"+productID++ + "\t" + itreatorIndex.getProductName() + "\t\t"
					+ itreatorIndex.getProductQuantity() + "\t\t" + itreatorIndex.getProductPrice());
		}

		System.out.println("+-----------------------------------------------------------------+");

	}
	/**
	 * 
	 * @param totalPrice
	 * @param totalProductinBucket
	 * DIsplay total price and total product
	 */
	public void displayTotalPriceAndQuantity(int totalPrice, int totalProductinBucket){
		System.out.println("\tQuantity of Products: " + totalProductinBucket+ "\n\tTotal Price: " + totalPrice);
		System.out.println("+-----------------------------------------------------------------+");
	}
	
	/**
	 * Ask to buy more
	 */
	public void askToBuyMore(){
		System.out.println("DO you want to buy more Product ?");
		System.out.println("Press 1 for Yes and other key for No");
	}

}
