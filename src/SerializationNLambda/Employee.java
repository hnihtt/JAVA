package SerializationNLambda;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serial;
import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private String department;
    private double salary;
    private String role;
    transient private String password;
    transient private double bonus;

    public Employee(String name, String department, double salary, String role, String password, double bonus) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.role = role;
        this.password = password;
        this.bonus = bonus;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Employee(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                ", bonus=" + bonus +
                '}';
    }

    @Serial //khong co cung dc, co thi compiler check
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        bonus = salary * 0.1;
        password = "default123";
    }
}
