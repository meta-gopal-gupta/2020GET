package LinkList;
/***
 * 
 * @author Gopal
 * Polynomial
 */

public class Main {
	public static void main(String[] args){
		
		final int l = 2; // Position of the starting element
		final int r = 7;  // Position of the last element
		final int n = 9; // Number of rotation

		SinglyLinkList.addNode(2);
		SinglyLinkList.addNode(3);
		SinglyLinkList.addNode(4);
		SinglyLinkList.addNode(5);
		SinglyLinkList.addNode(6);
		SinglyLinkList.addNode(7);
		

		System.out.println("\nList Values before rotation");
		SinglyLinkList.display();
		
		SinglyLinkList.rotate(l, r, n);
		System.out.println("\nList Values After Rotating");
		SinglyLinkList.display();

		SinglyLinkList.startNode.next.next.next.next = SinglyLinkList.startNode.next.next;
		
		if(SinglyLinkList.detectLoop()){
			System.out.println("\nYes! Loop exist");
		}
		else{
			System.out.println("\nNo! Loop not exist");
		}
			
		
	}
}
