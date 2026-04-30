package Stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<SanPham> danhSach = List.of(
                new SanPham("Laptop Dell",    "dientu",    15000000, 5),
                new SanPham("Chuột Logitech", "dientu",     500000, 20),
                new SanPham("Bàn phím cơ",   "dientu",    1200000, 15),
                new SanPham("Áo thun",        "thoitrang",  200000, 50),
                new SanPham("Quần jeans",     "thoitrang",  450000, 30),
                new SanPham("Giày Nike",      "thoitrang", 2500000, 10),
                new SanPham("Sách Java",      "sach",       350000, 25),
                new SanPham("Sách Python",    "sach",       300000, 40),
                new SanPham("Sách Design",    "sach",       280000,  8)
        );

        /*
        Bài 1: Lọc ra tất cả sản phẩm thuộc loại "dientu"
        Bài 2: In tên của tất cả sản phẩm ra màn hình
        Bài 3: Lấy danh sách tên sản phẩm có giá trên 1,000,000
        Bài 4: Đếm số lượng sản phẩm loại "sach"
        Bài 5: Kiểm tra xem có sản phẩm nào giá trên 10,000,000 không
         */

        danhSach.stream().filter(x -> x.getCategory().equals("dientu")).forEach(System.out::println);
        System.out.println();
        danhSach.forEach(System.out::println);
        System.out.println();
        danhSach.stream().filter(x -> x.getPrice() > 1000000).forEach(System.out::println);
        System.out.println();
        danhSach.stream().filter(x -> x.getCategory().equals("sach")).forEach(System.out::println);
        System.out.println();
        danhSach.stream().anyMatch(x -> x.getPrice() > 10000000);


        String check = danhSach.stream().anyMatch(x -> x.getPrice() > 10000000) ? "co" : "khong";
        System.out.println(check);
        System.out.println();

        /*
        Bài 6: Tính tổng giá trị tồn kho của tất cả sản phẩm
        Gợi ý: giá trị tồn kho = gia * soLuong
        Bài 7: Tìm sản phẩm có giá cao nhất
        Bài 8: Tính giá trung bình của sản phẩm loại "thoitrang"
        Bài 9: Sắp xếp sản phẩm theo giá tăng dần, lấy 3 sản phẩm rẻ nhất
        Bài 10: Nhóm sản phẩm theo loai
        Kết quả mong đợi: Map<String, List<SanPham>>
         */

        double value = danhSach.stream().mapToDouble(x -> x.getPrice()* x.getStock()).sum();
        System.out.println(value);

        SanPham maxSanPham = danhSach.stream().max((sp1, sp2) -> Double.compare(sp1.getPrice(), sp2.getPrice())).orElse(null);
        System.out.println(maxSanPham);
        System.out.println();

        double avg = danhSach.stream().filter(sp -> sp.getCategory().equals("thoitrang")).mapToDouble(SanPham::getPrice)
                .average()
                .orElse(0);

        System.out.println("Giá trung bình thoitrang: " + avg);
        System.out.println();

        List<SanPham> sortedList = danhSach.stream().sorted((a, b) -> Double.compare(a.getPrice(), b.getPrice())).toList();
        System.out.println("Sorted:");
        sortedList.forEach(System.out::println);
        System.out.println("3 cai re nhat:");
        sortedList.stream().limit(3).forEach(System.out::println);
        System.out.println();

        Map<String, List<SanPham>> grouped = danhSach.stream()
                .collect(Collectors.groupingBy(SanPham::getCategory)); //????
        System.out.println(grouped);
        System.out.println();

        /*
        Bài 11: Với mỗi loại sản phẩm, tìm sản phẩm có giá cao nhất trong loại đó

        Kết quả: Map<String, Optional<SanPham>>

        Bài 12: Tính tổng giá trị tồn kho theo từng loại

        Kết quả: Map<String, Double>

        Bài 13: Lấy tên tất cả sản phẩm, viết hoa, sắp xếp A→Z, nối thành 1 chuỗi cách nhau bởi " | "
        Bài 14: Phân loại sản phẩm thành 2 nhóm: đắt (giá ≥ 1,000,000) và rẻ (giá < 1,000,000)

        Kết quả: Map<Boolean, List<SanPham>>

        Bài 15: Tìm loại sản phẩm có tổng giá trị tồn kho cao nhất
         */
        Map<String, Optional<SanPham>> highestByCategory = danhSach.stream()
                .collect(Collectors.groupingBy(
                        SanPham::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(SanPham::getPrice))
                ));
        System.out.println(highestByCategory);

        Map<String, Double> stockValueByCategory = danhSach.stream()
                .collect(Collectors.groupingBy(
                        SanPham::getCategory,
                        Collectors.summingDouble(sp -> sp.getPrice() * sp.getStock())
                ));
        System.out.println(stockValueByCategory);

        //Bài 13: Lấy tên tất cả sản phẩm, viết hoa, sắp xếp A→Z, nối thành 1 chuỗi cách nhau bởi " | "
        String res = danhSach.stream().map(sp -> sp.getProduct().toUpperCase()).sorted().collect(Collectors.joining("|"));
        System.out.println(res);

        /*
        Bài 14: Phân loại sản phẩm thành 2 nhóm: đắt (giá ≥ 1,000,000) và rẻ (giá < 1,000,000)

        Kết quả: Map<Boolean, List<SanPham>>
         */
        Map<Boolean, List<SanPham>> groupedByPrice = danhSach.stream().collect(Collectors.partitioningBy(sp -> sp.getPrice() >= 1000000));
        System.out.println(groupedByPrice);
        System.out.println();
//        Bài 15: Tìm loại sản phẩm có tổng giá trị tồn kho cao nhất
        danhSach.stream().mapToDouble(sp -> sp.getPrice() * sp.getStock()).max().ifPresentOrElse(System.out::println, () -> System.out.println("khong"));
        danhSach.stream().max(Comparator.comparingDouble(sp -> sp.getPrice() * sp.getStock())).ifPresentOrElse(System.out::println, () -> System.out.println("khong"));
    }
}
