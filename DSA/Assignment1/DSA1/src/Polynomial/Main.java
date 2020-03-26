package Polynomial;
/***
 * 
 * @author Gopal
 *	Polynomial
 */
public class Main {

	public static void main(String[] args){
		int[] a = {2,1,0};
		int[] b = {1,2,1};
		int[] c = {3,1,3};
		
		Polynomial.add(3,a);
		Polynomial.add(1,b);
		Polynomial.add(4,c);		
		Polynomial.display();
	}
}
