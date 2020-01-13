package assignment1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Shopping {
	int priceOfProduct[] = new int[5];
	String nameOfProduct[] = new String[5];
	ArrayList<bucket> userBucket = new ArrayList<bucket>();

	void setProductName() {
		nameOfProduct[0] = "Nokia";
		nameOfProduct[1] = "Samsung";
		nameOfProduct[2] = "Gionee";
		nameOfProduct[3] = "Apple";
		nameOfProduct[4] = "Xiomi";
	}
	

	void setProductPrice() {
		priceOfProduct[0] = 2;
		priceOfProduct[1] = 4;
		priceOfProduct[2] = 6;
		priceOfProduct[3] = 8;
		priceOfProduct[4] = 10;
	}

	int noOfProductInList() {
		return nameOfProduct.length;
	}

	void displayListOfProducts() {
		System.out
				.println("*********************************************************");
		System.out.println("SN\tProduct Name\tPrice");
		for (int i = 0; i < 5; i++)
			System.out.println(i + 1 + "\t" + nameOfProduct[i] + "\t\t"
					+ priceOfProduct[i]);
		System.out
				.println("*********************************************************");
	}
	
	// Features of bucket
	int displayOptions(Scanner scanner) {
		int SelectOption;
		System.out
				.println("\n*********************************************************");
		System.out.println("1: Add Product in Bucket");
		System.out.println("2: Remove Product form Bucket");
		System.out.println("3: Update Orders List");
		System.out.println("4: Display Orders List");
		System.out.println("5: Place the Order");
		System.out.print("Your Option: ");
		SelectOption = scanner.nextInt();
		System.out
				.println("*********************************************************");
		return SelectOption;
	}

	void addInCart(int sequenceNumberOfProduct, int quantityOfProduct) {
		System.out.println(quantityOfProduct + " Peace Of " + nameOfProduct[sequenceNumberOfProduct - 1]
				+ " SmartPhone is Successfully Added");
		updateList(sequenceNumberOfProduct, quantityOfProduct);
	}

	boolean isListEmpty() {
		return userBucket.isEmpty();
	}

	int sizeOfList() {
		return userBucket.size();
	}

	void removeFromList(int sequenceToRemoveProduct) {
		userBucket.remove(sequenceToRemoveProduct - 1);
	}

	int totalPrice() {
		int TotalPrice = 0;
		Iterator itr = userBucket.iterator();

		// traversing elements of ArrayList scannerect
		while (itr.hasNext()) {
			bucket st = (bucket) itr.next();
			TotalPrice = TotalPrice + st.productPrice;
		}
		return TotalPrice;
	}

	int totalProduct() {
		int totalProduct = 0;
		Iterator itr = userBucket.iterator();

		// traversing elements of ArrayList scannerect
		while (itr.hasNext()) {
			bucket st = (bucket) itr.next();
			totalProduct = totalProduct + st.productQuantity;
		}
		return totalProduct;
	}

	void displayFinalBucketProducts() {
		Iterator itr = userBucket.iterator();
		int productSequence = 1;
		System.out
				.println("*********************************************************");
		System.out.println("Product Sequence\tProduct Name\tQuantity\tPrice");

		// traversing elements of ArrayList
		while (itr.hasNext()) {
			bucket st = (bucket) itr.next();
			System.out.println(productSequence++ + "\t\t\t" + st.productName + "\t\t"
					+ st.productQuantity + "\t"+st.productSequence+"\t" + st.productPrice);
		}
		System.out
				.println("*********************************************************");
	}

	void orderPlace() {
		System.out
				.println("*********************************************************");
		System.out.println("Quantity of Products: " + totalProduct()
				+ "\nTotal Price: " + totalPrice());
	}
	
	void updateList(int productSequenceNumber, int quantityOfProduct) {
		Iterator itr = userBucket.iterator();
		boolean flag = true;
		// traversing elements of ArrayList 
		// If Product already exist in bucket
		while (itr.hasNext()) {
			bucket st = (bucket) itr.next();
			if (st.productSequence == productSequenceNumber - 1) {
				st.productQuantity = st.productQuantity + quantityOfProduct;
				st.productPrice = st.productPrice
						+ (quantityOfProduct * priceOfProduct[productSequenceNumber - 1]);
				flag = false;
				break;
			}
		}
		// If product doesn't exist in bucket
		if (flag) {
			userBucket.add(new bucket(productSequenceNumber - 1,
					nameOfProduct[productSequenceNumber - 1],
					priceOfProduct[productSequenceNumber - 1] * quantityOfProduct, quantityOfProduct));
		}
	}
	
	// It will change old quantity with new quantity
	void reUpdateBucketProduct(int productSequenceNumber, int Qnt){
		Iterator itr = userBucket.iterator();
		// traversing elements of ArrayList scannerect
		while (itr.hasNext()) {
			bucket st = (bucket) itr.next();
			if (st.productSequence == productSequenceNumber - 1) {
				st.productQuantity =  Qnt;
				st.productPrice = Qnt * priceOfProduct[productSequenceNumber - 1];
				break;
			}
		}
	}
}

class bucket {
	int productSequence;
	String productName;
	int productPrice;
	int productQuantity;

	bucket(int sn, String name, int price, int qnt) {
		this.productSequence = sn;
		this.productName = name;
		this.productPrice = price;
		this.productQuantity = qnt;
	}
}