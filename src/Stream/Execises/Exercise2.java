package Stream.Execises;

import java.util.*;
import java.util.stream.Collectors;

public class Exercise2 {
    public static void main(String[] args) {
        record Order(String id, double amount, String status) {
            @Override
            public String id() {
                return id;
            }

            @Override
            public double amount() {
                return amount;
            }

            @Override
            public String status() {
                return status;
            }

            @Override
            public String toString() {
                return "Order{" +
                        "id='" + id + '\'' +
                        ", amount=" + amount +
                        ", status='" + status + '\'' +
                        '}';
            }
        }

        List<Order> orders = List.of(
                new Order("O5", 150_000, "PAID"),
                new Order("O2",  80_000, "PENDING"),
                new Order("O3", 200_000, "PAID"),
                new Order("O4",  50_000, "CANCELLED"),
                new Order("O5", 120_000, "PENDING")
        );

        Double totalPaidAmount = orders.stream().filter(order -> order.status.equals("PAID")).mapToDouble(Order::amount).sum();
        System.out.println(totalPaidAmount);

        OptionalDouble highestValue = orders.stream().mapToDouble(Order::amount).max();
        highestValue.ifPresentOrElse(System.out::println, () -> System.out.println("Khong co"));

        Order highestValueOrder = orders.stream().max(Comparator.comparingDouble(Order::amount)).orElse(null);
        System.out.println(highestValueOrder);

        Map<String, Long> countByStatus = orders.stream().collect(Collectors.groupingBy(Order::status, Collectors.counting()));
        System.out.println(countByStatus);

        // lấy tẩt cả order , , tính tổng giá trị sản phẩm theo từng loại , rồi map thành <String , Double >
        // loại coi như là id
        System.out.println("--------------------");
        Map<String, Double> groupedById = orders.stream().collect(Collectors.groupingBy(Order::id, Collectors.summingDouble(Order::amount)));
        System.out.println(groupedById);

        //map -> trả 1 giá trị
        //flatmap -> trả ra 1 stream hoặc 1 list

        // moỗi 1 thread đọc / ghi biến ở trong cpu cache / không phải ram
        /*
        nên nếu có nhiều thread thì sẽ có nhiều cache riêng -> không đọc đự , ghi đu ược biến ocuẻa thread khác
        -> volatile
         */

        /*
        buổi sau học db trên linux ubuntu không dùng giao diện 
         */
    }
}
