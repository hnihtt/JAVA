package Stream.Execises;

import java.util.Comparator;
import java.util.List;

public class Exercise3 {
    public static void main(String[] args) {
        record Employee(String name, double salary) {
            @Override
            public String name() {
                return name;
            }

            @Override
            public double salary() {
                return salary;
            }
        }
        record Department(String dept, List<Employee> employees) {
            @Override
            public String dept() {
                return dept;
            }

            @Override
            public List<Employee> employees() {
                return employees;
            }
        }

        List<Department> company = List.of(
                new Department("Engineering", List.of(
                        new Employee("Alice", 20_000_000),
                        new Employee("Bob",   12_000_000))),
                new Department("Marketing", List.of(
                        new Employee("Carol", 16_000_000),
                        new Employee("Alice", 20_000_000)))  // trung Alice
        );

        company.stream().flatMap(e -> e.employees().stream())
                .filter(e -> e.salary > 15_000_000)
                .distinct().sorted(Comparator.comparingDouble(Employee::salary).reversed())
                .forEach(System.out::println);
    }
}
