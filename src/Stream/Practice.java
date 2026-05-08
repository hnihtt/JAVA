package Stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Practice {
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

        //forEach
        System.out.println("forEach + sout");
        danhSach.forEach(System.out::println);
        //map - convert stream type
        System.out.println("map convert type");
        danhSach.stream().map(SanPham::getProduct).forEach(System.out::println);
        //filter - predicate return true/false
        System.out.println("filter");
        danhSach.stream().filter(sp -> sp.getCategory().equals("sach")).forEach(System.out::println);
        //filter + map
        System.out.println("filter + map");
        danhSach.stream().filter(SanPham -> SanPham.getPrice() > 1000000).map(SanPham::getProduct).forEach(System.out::println);
        //count
        System.out.println("count");
        System.out.println(danhSach.stream().filter(SanPham -> SanPham.getCategory().equals("sach")).count());
        //anyMatch
        System.out.println("anyMatch");
        System.out.println(danhSach.stream().anyMatch(SanPham -> SanPham.getPrice()>10000000) ? "co" : "khong");
        //allMatch
        System.out.println("allMatch");
        System.out.println(danhSach.stream().allMatch(SanPham -> SanPham.getPrice() < 1000) ? "co" : "khong");
        //findFirst
        System.out.println("findFirst");
        Optional<SanPham> spFindFirst = danhSach.stream().filter(sp -> sp.getPrice() > 1000000).findFirst();
        spFindFirst.ifPresent(System.out::println);
        //Optional, orElse
        danhSach.stream().filter(sp -> sp.getPrice() > 20000000)
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("khong co")); //consumer, runnable
        //mapToType, sum, avg
        double totalValue = danhSach.stream().mapToDouble(SanPham::getPrice).sum();
        System.out.println(totalValue);
        int totalStock = danhSach.stream().mapToInt(SanPham::getStock).sum();
        System.out.println(totalStock);
        double totalStockValue = danhSach.stream().mapToDouble(sp -> sp.getPrice() * sp.getStock()).sum();
        System.out.println(totalStockValue);
        danhSach.stream().mapToDouble(SanPham::getPrice).average().ifPresent(System.out::println);
        double avgPrice =  danhSach.stream().mapToDouble(SanPham::getPrice).average().orElse(0);
        System.out.println(avgPrice);
        //sort
        System.out.println("sort by price");
        List<SanPham> sortedList = danhSach.stream().sorted(Comparator.comparingDouble(SanPham::getPrice)).toList();
        sortedList.forEach(System.out::println);
        System.out.println("3 cheapest");
        danhSach.stream().sorted(Comparator.comparingDouble(SanPham::getPrice)).limit(3).forEach(System.out::println);
        System.out.println("highest price");
        danhSach.stream().max(Comparator.comparingDouble(SanPham::getPrice)).ifPresentOrElse(System.out::println, () -> System.out.println("khong"));
        //collect, group
        Map<String, List<SanPham>> groupedByCategory = danhSach.stream().collect(Collectors.groupingBy(SanPham::getCategory));
        System.out.println(groupedByCategory);

    }
}
