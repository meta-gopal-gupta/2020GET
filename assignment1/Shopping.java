package assignment1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Shopping {
	int ProductPrice[] = new int[5];
	String ProductName[] = new String[5];
	ArrayList<bucket> al = new ArrayList<bucket>();

	void setProductName() {
		ProductName[0] = "Nokia";
		ProductName[1] = "Samsung";
		ProductName[2] = "Gionee";
		ProductName[3] = "Apple";
		ProductName[4] = "Xiomi";
	}

	void setProductPrice() {
		ProductPrice[0] = 2;
		ProductPrice[1] = 4;
		ProductPrice[2] = 6;
		ProductPrice[3] = 8;
		ProductPrice[4] = 10;
	}

	int noOfProductInList() {
		return ProductName.length;
	}

	void displayListOfProducts() {
		System.out
				.println("*********************************************************");
		System.out.println("SN\tProduct Name\tPrice");
		for (int i = 0; i < 5; i++)
			System.out.println(i + 1 + "\t" + ProductName[i] + "\t\t"
					+ ProductPrice[i]);
		System.out
				.println("*********************************************************");
	}

	int SelectOption(Scanner scanner) {
		int SelectOption;
		System.out
				.println("*********************************************************");
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

	void AddInCart(int ProductSN, int Quantity) {
		System.out.println(Quantity + " Peace Of " + ProductName[ProductSN - 1]
				+ " SmartPhone is Successfully Added");
		updateList(ProductSN, Quantity);
	}

	boolean isListEmpty() {
		return al.isEmpty();
	}

	int sizeOfList() {
		return al.size();
	}

	void removeFromList(int RemoveProductSN) {
		al.remove(RemoveProductSN - 1);
	}

	int totalPrice() {
		int TotalPrice = 0;
		Iterator itr = al.iterator();

		// traversing elements of ArrayList scannerect
		while (itr.hasNext()) {
			bucket st = (bucket) itr.next();
			TotalPrice = TotalPrice + st.price;
		}
		return TotalPrice;
	}

	int totalProduct() {
		int TotalProduct = 0;
		Iterator itr = al.iterator();

		// traversing elements of ArrayList scannerect
		while (itr.hasNext()) {
			bucket st = (bucket) itr.next();
			TotalProduct = TotalProduct + st.qnt;
		}
		return TotalProduct;
	}

	void displayFinalBucketProducts() {
		Iterator itr = al.iterator();
		int ProductSequence = 1;
		System.out
				.println("*********************************************************");
		System.out.println("Product Sequence\tProduct Name\tQuantity\tPrice");

		// traversing elements of ArrayList scannerect
		while (itr.hasNext()) {
			bucket st = (bucket) itr.next();
			System.out.println(ProductSequence++ + "\t\t\t" + st.name + "\t\t"
					+ st.qnt + "\t\t" + st.price);
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

	void updateList(int productSequenceNumber, int Qnt) {
		Iterator itr = al.iterator();
		boolean flag = true;
		// traversing elements of ArrayList scannerect
		while (itr.hasNext()) {
			bucket st = (bucket) itr.next();
			if (st.sn == productSequenceNumber - 1) {
				st.qnt = st.qnt + Qnt;
				st.price = st.price
						+ (Qnt * ProductPrice[productSequenceNumber - 1]);
				flag = false;
				break;
			}
		}
		if (flag) {
			al.add(new bucket(productSequenceNumber - 1,
					ProductName[productSequenceNumber - 1],
					ProductPrice[productSequenceNumber - 1] * Qnt, Qnt));
		}
	}
	void reUpdateBucketProduct(int productSequenceNumber, int Qnt){
		Iterator itr = al.iterator();
		// traversing elements of ArrayList scannerect
		while (itr.hasNext()) {
			bucket st = (bucket) itr.next();
			if (st.sn == productSequenceNumber - 1) {
				st.qnt =  Qnt;
				st.price = Qnt * ProductPrice[productSequenceNumber - 1];
				break;
			}
		}
	}
}

class bucket {
	int sn;
	String name;
	int price;
	int qnt;

	bucket(int sn, String name, int price, int qnt) {
		this.sn = sn;
		this.name = name;
		this.price = price;
		this.qnt = qnt;
	}
}