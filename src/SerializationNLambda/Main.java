package SerializationNLambda;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //B1
        Employee emp = new Employee("Name", "Department", 12000, "Role", "Password", 12000);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./src/SerializationNLambda/emp.txt"));
        oos.writeObject(emp);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/SerializationNLambda/emp.txt"));
        Employee empR = (Employee) ois.readObject();
        ois.close();
        System.out.println(empR.toString());

        //B2
        BufferedWriter bw = new BufferedWriter(new FileWriter("./src/SerializationNLambda/employees.txt", true));
        bw.write(empR.getName());
        bw.newLine();
        bw.write(empR.getDepartment());
        bw.newLine();
        bw.write(String.valueOf(empR.getSalary()));
        bw.newLine();
        bw.close();


        //B3
        EmployeeFilter bySalary = new EmployeeFilter() {
            private static final double RATIO = 1.2;

            @Override
            public void filter(Employee e) {
                if (e.getSalary() > 10000) {
                    System.out.println(">10000");
                } else {
                    System.out.println("<=10000");
                }

                //test field
                e.setSalary(e.getSalary() * RATIO);
            }

            @Override
            public void desc() {
                System.out.println("Filtered by Salary");
            }
        };

        EmployeeFilter byDepartment = new EmployeeFilter() {
            @Override
            public void filter(Employee e) {
                System.out.println("Logic filter by Department");
            }

            @Override
            public void desc() {
                System.out.println("Filtered by Department");
            }
        };

        EmployeeFilter byRole = new EmployeeFilter() {
            @Override
            public void filter(Employee e) {
                System.out.println("Logic filter by Role");
            }

            @Override
            public void desc() {
                System.out.println("Filtered by Role");
            }
        };

        bySalary.filter(empR);
        bySalary.desc();
        System.out.println(empR.toString());

        //B4
        Formatter fmt1 = (x) -> x.getName().toUpperCase();
        Formatter fmt2 = (Employee x) -> x.getName().concat(" - From: " + x.getDepartment());

        System.out.println(fmt1.format(empR));
        System.out.println(fmt2.format(empR));

        Test test = new Test();
        System.out.println(test.test.format(empR));
    }
}
