package dao;

import java.util.ArrayList;


/**
 * 
 * @author Gopal Gupta 
 * Shopping Cart ProductListDao Code
 * copyright GET2020
 */
public class ProductListDao {
	private int priceOfProduct[] = new int[5];
	private String nameOfProduct[] = new String[5];
	private final int  MAX_QUANTITY = 100;
	private final int MIN_QUANTITY = 0;
	private ArrayList<UserBucket> userBucket = new ArrayList<UserBucket>();
	
	/**
	 * Constructor to set product name and price
	 */
	public ProductListDao(){
		setProductName();
		setProductPrice();
	}

	/**
	 * 
	 * @return userbucket array list 
	 */
	public ArrayList<UserBucket> getUserBucket() {
		return userBucket;
	}

	/**
	 * set name of all product 
	 */
	void setProductName() {
		nameOfProduct[0] = "Nokia";
		nameOfProduct[1] = "Samsung";
		nameOfProduct[2] = "Gionee";
		nameOfProduct[3] = "Apple";
		nameOfProduct[4] = "Xiomi";
	}

	/**
	 * 
	 * set price of all products
	 */
	void setProductPrice() {
		priceOfProduct[0] = 2;
		priceOfProduct[1] = 4;
		priceOfProduct[2] = 6;
		priceOfProduct[3] = 8;
		priceOfProduct[4] = 10;
	}
	
	/**
	 * 
	 * @return max quantity of product which user can add in there bucket at a time
	 */
	public int getMAX_QUANTITY() {
		return MAX_QUANTITY;
	}


	/**
	 * 
	 * @return min quantity of product which user can add in there bucket at a time
	 */
	public int getMIN_QUANTITY() {
		return MIN_QUANTITY;
	}
	

	/**
	 * 
	 * @return price of product array
	 */
	public int[] getPriceOfProduct() {
		return priceOfProduct;
	}

	/**
	 * 
	 * @return name of product array
	 */
	public String[] getNameOfProduct() {
		return nameOfProduct;
	}

	/**
	 * 
	 * @return price of product by product id 
	 */
	public int getPriceOfProduct(int productId) {
		return priceOfProduct[productId];
	}

	/**
	 * 
	 * @return name of product by product id 
	 */
	public String getNameOfProduct(int productId) {
		return nameOfProduct[productId];
	}
}
