package employee;

import java.util.Comparator;

public class SortByName implements Comparator<Employee> {

      @Override
      public int compare(Employee employee1, Employee employee2) {
              return employee1.getEmployeeName().compareTo(employee2.getEmployeeName());
      }

}
