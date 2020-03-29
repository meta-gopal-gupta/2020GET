package employee;

public class Employee implements Comparable<Employee> {

        private int empId;
        private String name;
        private String address;

        public Employee(int empId, String name, String address)
                        throws Exception {

                if (empId < 0) {
                        throw new Exception("Invalid employee id");
                }

                if (name.trim().length() == 0) {
                        throw new Exception("Invalid employee name");
                }

                if (address.trim().length() == 0) {
                        throw new Exception("Invalid employee address");
                }

                this.empId = empId;
                this.name = name;
                this.address = address;
        }

        public int getId() {
                return empId;
        }

        public void setId(int id) {
                this.empId = id;
        }

        public String getEmployeeName() {
                return name;
        }

        public void setEmployeeName(String employeeName) {
                this.name = employeeName;
        }

        public String getEmployeeAddress() {
                return address;
        }

        public void setEmployeeAddress(String employeeAddress) {
                this.address = employeeAddress;
        }

        @Override
        public int compareTo(Employee employee) {

                if (this.empId < employee.empId) {
                        return -1;
                } else if (this.empId > employee.empId) {
                        return 1;
                } else {
                        return 0;
                }
        }

        @Override
        public String toString() {
            return "EmpId: " + empId + ", Name: " + name
                    + ", Address: " + address ;
        }
        
        

}