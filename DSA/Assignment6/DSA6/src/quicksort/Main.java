package quicksort;


/**
 * Driver class for employee list
 * @author Gopal
 *
 */
public class Main {

	public static void main(String[] args){
		EmployeeList list = new EmployeeList(); 
		list.addEmployee("Gopal",10000,20);
		list.addEmployee("Dopal",9000,30); 
		list.addEmployee("Mopal",9000,22);  
		list.addEmployee("Bopal",9500,43); 
		list.addEmployee("Sopal",2500,67); 

		list.displayList();
		System.out.println("----------------");
		list.sortList();
		list.displayList();
	}
}
