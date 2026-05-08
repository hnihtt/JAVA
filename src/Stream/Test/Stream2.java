package Stream.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream2 {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("O1", "An",    OrderStatus.COMPLETED, 500000,  "HN"),
                new Order("O2", "Binh",  OrderStatus.PENDING,   300000,  "HCM"),
                new Order("O3", "An",    OrderStatus.CANCELLED, 150000,  "HN"),
                new Order("O4", "Cuong", OrderStatus.COMPLETED, 900000,  "DN"),
                new Order("O5", "Binh",  OrderStatus.COMPLETED, 450000,  "HCM"),
                new Order("O6", "An",    OrderStatus.PENDING,   200000,  "HN"),
                new Order("O7", "Cuong", OrderStatus.CANCELLED, 750000,  "DN"),
                new Order("O8", "Dung",  OrderStatus.COMPLETED, 1200000, "HN")
        );

        orders.stream().filter(x -> x.getStatus().equals(OrderStatus.COMPLETED)).forEach(x -> System.out.println(x.getId()));
        double totalCompleted = orders.stream().filter(x -> x.getStatus().equals(OrderStatus.COMPLETED)).mapToDouble(Order::getAmount).sum();
        System.out.println(totalCompleted);
        orders.stream().sorted(Comparator.comparing(Order::getAmount).reversed()).limit(1).forEach(System.out::println);
        orders.stream().collect(Collectors.groupingBy(Order::getName)).forEach((x, y) -> System.out.println(x + " : " + y));
        orders.stream().collect(Collectors.groupingBy(Order::getLocation, Collectors.summingDouble(Order::getAmount))).forEach((x, y) -> System.out.println(x + ":" + y));
        orders.stream().sorted(Comparator.comparingDouble(Order::getAmount).reversed()).limit(3).forEach(System.out::println);
        System.out.println(orders.stream().filter(o -> o.getLocation().equals("HN")).anyMatch(o -> o.getStatus() == OrderStatus.PENDING)? "Co" : "Khong");
    }
}
