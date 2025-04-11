import java.util.*;

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Salary: " + salary;
    }
}

public class EmployeeSorter {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 50000));
        employees.add(new Employee("Bob", 25, 45000));
        employees.add(new Employee("Charlie", 28, 52000));
        employees.add(new Employee("David", 30, 48000));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose sorting criteria:");
        System.out.println("1. Name");
        System.out.println("2. Age");
        System.out.println("3. Salary");
        System.out.print("Enter your choice (1-3): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                employees.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
                break;
            case 2:
                employees.sort(Comparator.comparingInt(Employee::getAge));
                break;
            case 3:
                employees.sort(Comparator.comparingDouble(Employee::getSalary));
                break;
            default:
                System.out.println("Invalid choice. Showing unsorted list.");
        }

        System.out.println("\nSorted Employee List:");
        employees.forEach(System.out::println);

        scanner.close();
    }
}
