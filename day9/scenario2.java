//Design a for an attendence tracking system for an employee highlighting the number weakoff that previal a particular month using an insertion sort algorithm 
import java.util.ArrayList;
import java.util.List;
public class scenario2 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 2));
        employees.add(new Employee("Bob", 5));
        employees.add(new Employee("Charlie", 3));
        employees.add(new Employee("David", 1));

        insertionSort(employees);

        for (Employee employee : employees) {
            System.out.println(employee.getName() + ": " + employee.getWeakOffCount());
        }
    }

    public static void insertionSort(List<Employee> employees) {
        for (int i = 1; i < employees.size(); i++) {
            Employee key = employees.get(i);
            int j = i - 1;

            while (j >= 0 && employees.get(j).getWeakOffCount() > key.getWeakOffCount()) {
                employees.set(j + 1, employees.get(j));
                j--;
            }
            employees.set(j + 1, key);
        }
    }
}
class Employee {
    private String name;
    private int weakOffCount;

    public Employee(String name, int weakOffCount) {
        this.name = name;
        this.weakOffCount = weakOffCount;
    }

    public String getName() {
        return name;
    }

    public int getWeakOffCount() {
        return weakOffCount;
    }
}