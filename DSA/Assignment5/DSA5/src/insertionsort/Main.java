package insertionsort;

public class Main {

	public static void main(String[] args) {
		
		EmployeeList list = new EmployeeList(); 
		list.addEmployee("Gopal",10000,20);
		list.addEmployee("Dopal",9000,30); 
		list.addEmployee("Mopal",9000,22);  
		list.addEmployee("Bopal",9500,43); 
		list.addEmployee("Sopal",2500,67); 
		
		
		System.out.println("Linked List before Sorting"); 
		list.display(list.start); 
		list.insertionSort(list.start); 
		System.out.println("\nLinkedList After Sorting"); 
		list.display(list.start); 

	}
}
