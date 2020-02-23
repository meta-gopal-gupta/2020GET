package facade;

import java.util.ArrayList;
import java.util.Iterator;

import dao.ProductListDao;
import dao.UserBucket;


/**
 * 
 * @author Gopal Gupta 
 * Shopping Cart ProductFasade Code
 * copyright GET2020
 */
public class ProductFasade {
	
	ProductListDao productList = null;
	public ProductFasade(){
		productList = new ProductListDao();
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
	 * @return max quantity user can buy at a time
	 */
	public int getMaxQuantityOfProduct(){
		return productList.getMAX_QUANTITY();
	}
	
	/**
	 * 
	 * @return min quantity user can buy at a time
	 */
	public int getMinQuantityOfProduct(){
		return productList.getMIN_QUANTITY();
	}
	
	
	/**
	 * 
	 * @return total price of added products 
	 */
	public int totalPrice() {
		int TotalPrice = 0;
		Iterator<UserBucket> itrator = getUserBucket().iterator();

		while (itrator.hasNext()) {
			UserBucket itratorIndex = (UserBucket) itrator.next();
			TotalPrice = TotalPrice + itratorIndex.getProductPrice();
		}
		return TotalPrice;
	}

	/**
	 * @return total prducts added in bucket
	 */
	public int totalProduct() {
		int totalProduct = 0;
		Iterator<UserBucket> itrator = getUserBucket().iterator();

		while (itrator.hasNext()) {
			UserBucket itratorIndex = (UserBucket) itrator.next();
			totalProduct = totalProduct + itratorIndex.getProductQuantity();
		}
		return totalProduct;
	}

	
	/**
	 * 
	 * @param productID
	 * @param productQuantity
	 * if same product added again then update old one
	 * else add a new product in the bucket
	 */
	public void addInCart(int productID, int productQuantity) {
		Iterator<UserBucket> itrator = productList.getUserBucket().iterator();
		boolean flag = true;
		while (itrator.hasNext()) {
			UserBucket itreatorIndex = (UserBucket) itrator.next();
			if (itreatorIndex.getProductID() == productID - 1) {
				itreatorIndex.setProductQuantity(itreatorIndex.getProductQuantity() + productQuantity);
				itreatorIndex.setProductPrice(itreatorIndex.getProductPrice()
						+ (productQuantity * getPriceOfProduct(productID - 1)));
				flag = false;
				break;
			}
		}
		// If product doesn't exist in bucket
		if (flag) {
			productList.getUserBucket().add(new UserBucket(productID - 1,
					getNameOfProduct(productID - 1),
					getPriceOfProduct(productID - 1) * productQuantity, productQuantity));
		}
	}	
	
	/**
	 * 
	 * @return true if user bucket is empty
	 */
	public boolean isListEmpty() {
		return productList.getUserBucket().isEmpty();
	}

	/**
	 * 
	 * @return number of different product added in bucket
	 */
	public int sizeOfList() {
		return productList.getUserBucket().size();
	}

	/**
	 * 
	 * @param sequenceToRemoveProduct
	 * remove product from the bucket
	 */
	public void removeFromList(int sequenceToRemoveProduct) {
		productList.getUserBucket().remove(sequenceToRemoveProduct - 1);
	}
	
}
