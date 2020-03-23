package Polynomial;
/***
 * 
 * @author Gopal
 * Polynomial
 */

public class DoublyLinkList {
	public int coefficient;
	public DoublyLinkList next = null;
	public Power power = null;
	
	public DoublyLinkList(int coefficient, Power headNode) {
		this.coefficient = coefficient;
		this.power = headNode;
	}
	
	
}
