package Stream.Execises;

import java.util.List;

public class Exercise1 {
    public static void main(String[] args) {
        record Student(String name, double gpa) {
            @Override
            public String name() {
                return name;
            }

            @Override
            public double gpa() {
                return gpa;
            }
        }

        List<Student> students = List.of(
                new Student("An",    3.8),
                new Student("Binh",  2.9),
                new Student("Chau",  3.5),
                new Student("Dung",  3.2),
                new Student("Em",    4.0)
        );

        List<String> studentsWithHighGpa = students.stream().filter(Student -> Student.gpa >= 3.5).map(Student::name).sorted().toList();
        System.out.println(studentsWithHighGpa);

        StringBuffer
    }
}
