package dao;

public class UserBucket {
	int productID;
	String productName;
	int productPrice;
	int productQuantity;

	public UserBucket(int ID, String name, int price, int quantity) {
		this.productID = ID;
		this.productName = name;
		this.productPrice = price;
		this.productQuantity = quantity;
	}
	public int getProductID() {
		return productID;
	}

	public String getProductName() {
		return productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}
	
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	
}
