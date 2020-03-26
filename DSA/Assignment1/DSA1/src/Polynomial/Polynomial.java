package Polynomial;

/***
 * 
 * @author Gopal
 * Polynomial
 */


public class Polynomial {
	static DoublyLinkList startNode = null;
	static Power tempHead;
	static int maxPower;
	
	/***
	 * To add polynomial
	 * @param coefficient
	 * @param power
	 */
	public static void add(int coefficient, int[] power) {
		int index = 0;
		tempHead = null;
		while (index != power.length){
			Power newNode1 = new Power(power[index]);
			if (tempHead == null)
				tempHead = newNode1;
			else{
				Power tempNode = tempHead;
				while (tempNode.next != null)
					tempNode = tempNode.next;
				tempNode.next = newNode1;
			}
			index++;
		}
		
		DoublyLinkList newNode = new DoublyLinkList(coefficient, tempHead);
		if (startNode == null)
			startNode = newNode;
		else{
			DoublyLinkList tempNode = startNode;
			while (tempNode.next != null)
				tempNode = tempNode.next;
			tempNode.next = newNode;
		}
	}
	
	/***
	 * To display the polynomials
	 */
	public static void display() {
		DoublyLinkList tempNode = startNode;
		char[] charExp = {'x','y','z'};
		while (tempNode != null){
			int temp = 0;
			int index = 0;
			System.out.print(tempNode.coefficient);
			Power headNode = tempNode.power;
			while( index < charExp.length){
				System.out.print(charExp[index++]);
				System.out.print(headNode.degree);
				temp += headNode.degree;
				headNode = headNode.next;
			}
			if(maxPower<temp){
				maxPower = temp;
			}
			System.out.print(" + ");
			tempNode = tempNode.next;
		}
	}
	
}
