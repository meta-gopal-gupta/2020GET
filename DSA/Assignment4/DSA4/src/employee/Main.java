package employee;

import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		EmployeeCollection employeeCollection = new EmployeeCollection();
		try {
			employeeCollection.addEmployee(new Employee(1, "Gopal", "Jaipur"));
			employeeCollection.addEmployee(new Employee(3, "Ram", "Jodhpur"));
			employeeCollection.addEmployee(new Employee(2, "Ashish", "Kota"));
			employeeCollection.addEmployee(new Employee(5, "Mangal", "Bara"));

			System.out.println("Sorting By The EmpId");
			List<Employee> sortByEmpId = employeeCollection.sortByEmpId();
			for (Employee employee : sortByEmpId) {
				System.out.println(employee.toString());
			}

			System.out.println("Sorting By Employee Name");
			List<Employee> sortedOnName = employeeCollection.sortByName();
			for (Employee employee : sortedOnName) {
				System.out.println(employee.getEmployeeName());
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
