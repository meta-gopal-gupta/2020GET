package view;

import controller.ProjectController;


/**
 * 
 * @author Gopal Gupta 
 * Shopping Cart MainView Code
 * copyright GET2020
 */
public class MainView {
	public static void main(String[] args){
		OutputView outputView = new OutputView();
		InputView inputView = new InputView();
		ProjectController controller = new ProjectController();
		
		outputView.aboutProgram();
		
		boolean repeat = true;
		while(repeat){
			outputView.displayOptions();
			int option = inputView.returnOptionNumber();
			switch(option){
			
			// To add product in bucket
			case 1:
				controller.displayListOfProducts();
				String addProductStatus = controller.addProductInBucket();
				System.out.println(addProductStatus);
				break;
				
			// To remove product from the bucket 	
			case 2:
				String removeProductStatus = controller.removeProductFromBucket();
				System.out.println(removeProductStatus);
				break;
				
			// 	Display all added product
			case 3:
				controller.displayBucketProducts();
				break;
			
			// Place the order and display total price and total products
			case 4:	
				String orderPlacingStatus = controller.placeTheOrder();
				System.out.println(orderPlacingStatus);
				repeat = controller.wantsToBuyMore();
				break;
				
			//	Exit the program
			case 5:
				System.out.println("Thank you for using our shopping service");
				repeat = false;
				break;
			default: System.out.println("Enter Correct Option");
			}
			
		}		
	}
}
