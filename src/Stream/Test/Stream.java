package Stream.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        // tạo class student :
        //List<Student> students = List.of(
        //        new Student("An",    20, 3.5, "CNTT"),
        //        new Student("Binh",  22, 2.8, "Toan"),
        //        new Student("Cuong", 21, 3.8, "CNTT"),
        //        new Student("Dung",  19, 3.1, "Ly"),
        //        new Student("Em",    23, 2.5, "Toan"),
        //        new Student("Phong", 20, 3.9, "CNTT"),
        //        new Student("Giang", 21, 3.2, "Ly"),
        //        new Student("Huy",   22, 2.9, "CNTT")
        //);
        //Lọc sinh viên ngành CNTT có GPA >= 3.5, in ra tên
        //Tính GPA trung bình của toàn bộ sinh viên
        //Tìm sinh viên có GPA cao nhất
        //Nhóm sinh viên theo ngành học → Map<String, List<Student>>
        //Đếm số sinh viên theo từng ngành → Map<String, Long>
        //Lấy top 3 sinh viên GPA cao nhất
        //Kiểm tra xem có sinh viên nào dưới 20 tuổi không

        List<Student> students = List.of(
                new Student("An",    20, 3.5, "CNTT"),
                new Student("Binh",  22, 2.8, "Toan"),
                new Student("Cuong", 21, 3.8, "CNTT"),
                new Student("Dung",  19, 3.1, "Ly"),
                new Student("Em",    23, 2.5, "Toan"),
                new Student("Phong", 20, 3.9, "CNTT"),
                new Student("Giang", 21, 3.2, "Ly"),
                new Student("Huy",   22, 2.9, "CNTT")
        );

        students.stream().filter(sd -> sd.getGpa() >= 3.5).forEach(System.out::println);
        students.stream().mapToDouble(Student::getGpa).average().ifPresent(System.out::println);
        students.stream().mapToDouble(Student::getGpa).max().ifPresent(System.out::println);
        students.stream().collect(Collectors.groupingBy(Student::getMajor)).forEach((x, y) -> System.out.println(x+ " : " + y));
        students.stream().sorted(Comparator.comparing(Student::getGpa).reversed()).limit(3).forEach(System.out::println);
        System.out.println(students.stream().anyMatch(sd -> sd.getAge() < 20) ? "co" : "khong");


    }
}
