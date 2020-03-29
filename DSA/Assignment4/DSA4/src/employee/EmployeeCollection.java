package employee;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeCollection {

        private List<Employee> employeeList;

        public EmployeeCollection() {
                employeeList = new ArrayList<>();
        }
        public void addEmployee(Employee employee) throws Exception {
                if (employee == null) {
                        throw new Exception("Null object can't be added.");
                }

                if (isUnique(employee.getId())) {
                        employeeList.add(employee);
                } else {
                        throw new Exception("ID is not unique");
                }
        }

        private Boolean isUnique(int empId) {
                for (Employee iterator : employeeList) {
                        if (iterator.getId() == empId) {
                                return false;
                        }
                }
                return true;
        }

        public List<Employee> sortByEmpId() {
                List<Employee> tempList = employeeList;
                Collections.sort(tempList);
                return employeeList;
        }

        public List<Employee> sortByName() {
                List<Employee> tempList = employeeList;
                Collections.sort(tempList, new SortByName());
                return tempList;
        }

}