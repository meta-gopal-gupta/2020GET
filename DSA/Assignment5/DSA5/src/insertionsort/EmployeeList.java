package insertionsort;

public class EmployeeList {

	Employee start; 
	Employee sorted; 
	void addEmployee(String name, int salary, int age) 
	{ 
		
		Employee newnode = new Employee(name,salary,age); 
		newnode.next = start; 
		start = newnode; 
	} 

	
	void insertionSort(Employee head) 
	{ 
		
		sorted = null; 
		Employee current = head; 
		while (current != null) 
		{ 
			Employee next = current.next; 
			sortedInsert(current); 
			current = next; 
		} 
		start = sorted; 
	} 

	void sortedInsert(Employee head) 
	{ 
		
		if (sorted == null || sorted.salary >= head.salary) 
		{ 
			head.next = sorted; 
			sorted = head; 
		} 
		else
		{ 
			Employee current = sorted; 
			while (current.next != null && current.next.salary < head.salary) 
			{ 
				current = current.next; 
			} 
			head.next = current.next; 
			current.next = head; 
		} 
	} 

	void display(Employee head) 
	{ 
		if(head == null) return; 
		display(head.next);
		System.out.println(head.name+" "+head.salary+" "+head.age);
	} 
	
}
