package quicksort;

/**
 * This class holds the structure of nodes in linked list
 * @author Gopal
 *
 */
public class Employee {
	private String name;
	private long salary;
	private int age;
	private Employee next;

	Employee(String empName, long empSalary, int empAge){
		this.salary = empSalary;
		this.name = empName;
		this.age = empAge;
		this.next = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Employee getNext() {
		return next;
	}

	public void setNext(Employee next) {
		this.next = next;
	}
}

