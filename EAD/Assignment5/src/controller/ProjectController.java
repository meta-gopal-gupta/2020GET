package controller;
import java.util.ArrayList;
import dao.UserBucket;
import view.InputView;
import view.OutputView;
import facade.ProductFasade;

/**
 * 
 * @author Gopal Gupta 
 * Shopping Cart ProjectController Code
 * copyright GET2020
 */
public class ProjectController {
	InputView inputView = null;
	OutputView outputView = null;
	ProductFasade productList = null;

	public ProjectController(){
		if(inputView == null){
			inputView = new InputView();
			}
			
		if(outputView == null){
			outputView = new OutputView();
		}
		
		if(productList == null){
			productList = new ProductFasade();
		}
	}
	
	
	/**
	 * 
	 * @return prices of product in interger Array 
	 */
	public int[] getPriceOfProduct() {
		return productList.getPriceOfProduct();
	}

	/**
	 * 
	 * @return product name
	 */
	public String[] getNameOfProduct() {
		return productList.getNameOfProduct();
	}


	/**
	 * 
	 * @return product price
	 */
	public int getPriceOfProduct(int productId) {
		return productList.getPriceOfProduct(productId);
	}


	/**
	 * 
	 * @return product name
	 */
	public String getNameOfProduct(int productId) {
		return productList.getNameOfProduct(productId);
	}
	

	/**
	 * 
	 * @return user bucket array list
	 */
	public ArrayList<UserBucket> getUserBucket() {
		return productList.getUserBucket();
	}
	
	/**
	 * 
	 * @return number of available products
	 */
	public int getSizeOfProductList(){
		return getNameOfProduct().length;
	}
	
	/**
	 * 
	 * Display the user bucket 
	 */
	public void displayBucketProducts(){
		outputView.displayBucketProducts(getUserBucket());
	}
	

	/**
	 * 
	 * Display the available product list
	 */
	public void displayListOfProducts(){
		outputView.displayListOfProducts(getNameOfProduct(),getPriceOfProduct());
	}
	

	/**
	 * 
	 * Add Products in the bucket
	 * varify quantity and product id is correct or not 
	 * @return Added product status
	 */
	public String addProductInBucket(){
		int maxProductQuantity = productList.getMaxQuantityOfProduct();
		int minProductQuantity = productList.getMinQuantityOfProduct();
		int indexOfFirstProducts = 0 ;

		int productID = inputView.getProductID();
		if (!(productID <= getSizeOfProductList())) {
			return "Sorry Now we have only "+ getSizeOfProductList() + " Products";
		} 
		else if (!(productID > indexOfFirstProducts)) {
			return "Sorry Prduct Sequence Starts From 1";
		} 
		else {
			int productQuantity = inputView.getProductQuantity();
			if (!(productQuantity > minProductQuantity)) {
				return "Sorry you need to buy one or more product";
			} 
			else if (!(productQuantity <= maxProductQuantity)) {
				return "Sorry at a time you can buy 100 or less products";
			} 
			else {
				productList.addInCart(productID,productQuantity);
				return "Your product is addad successfully";
			}
		}
	}
	
	/**
	 * Remove product from the bucket
	 * check remove details are correct or not
	 * @return remove status
	 */
	public String removeProductFromBucket(){
		int indexOfFirstProducts = 1 ;
		
		if (productList.isListEmpty() == true)
			return "Sorry Your Bucket Is Empty";
		else {
			displayBucketProducts();
			int productID = inputView.getProductID();
			if (!(productID <= productList.sizeOfList() && (productID >= indexOfFirstProducts))) {
				return "Sorry Product Sequence " + productID	+ " Doesn't Exist";
			} 
			else {
				productList.removeFromList(productID);
				return "Product Removed Successfully";
			} 
		}
	}

	/**
	 * Place the oreder and display price and quantity
	 * @return order placing status
	 */
	public String placeTheOrder(){
		if (productList.isListEmpty() == true)
			return "Sorry Your Bucket Is Empty";
		else {
			displayBucketProducts();
			outputView.displayTotalPriceAndQuantity(productList.totalPrice(),productList.totalProduct());
			return "Order is placed successfully";
		}
	}
	
	/**
	 * Ask user He wanna buy more product or not
	 * @return true if he press 1 as yes
	 */
	public boolean wantsToBuyMore(){
		outputView.askToBuyMore();
		int option = inputView.returnOptionNumber();
		
		if(option == 1){
			return true;
		}
		else {
			return false;
		}
	}
}
