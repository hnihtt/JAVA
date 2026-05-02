package Stream.MorePracticing;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> danhSachUser = List.of(
                new User.Builder().id(0).name("Admin").role("ADMIN").isActive(true).build(),
                new User.Builder().id(1).name("User1").role("MOD").isActive(true).build(),
                new User.Builder().id(2).name("User2").role("USER").isActive(false).build(),
                new User.Builder().id(3).name("User3").role("USER").isActive(true).build(),
                new User.Builder().id(4).name("User4").role("USER").isActive(false).build(),
                new User.Builder().id(5).name("IThinkThisIsTheLongestNameInTheWorld").role("USER").isActive(false).build()
        );

        System.out.println("find active users");
        danhSachUser.stream().filter(User::isActive).map(User::getName).forEach(System.out::println);
        System.out.println("check if a user named Admin exists");
        System.out.println(danhSachUser.stream().anyMatch(x -> x.getName().equals("Admin")) ? "Co" : "Khong");
        System.out.println("find the first active user/ return null if there is none");
        User firstActiveUser =  danhSachUser.stream().filter(User::isActive).findFirst().orElse(null);
        System.out.println("count inactive users");
        long inactiveUsers = danhSachUser.stream().filter(User::isActive).count();
        System.out.println(inactiveUsers);
        String usersString = danhSachUser.stream().map(User::getName).collect(Collectors.joining(", "));
        System.out.println(usersString);
        Map<String, List<User>> groupedByRole = danhSachUser.stream().collect(Collectors.groupingBy(User::getRole));
        System.out.println(groupedByRole);
        Map<String, Long> countByRole = danhSachUser.stream()
                .collect(Collectors.groupingBy(
                        User::getRole,
                        Collectors.counting()
                ));
        System.out.println(countByRole);
        System.out.println("user with the longest name");
        User userWithTheLongestName = danhSachUser.stream().max(Comparator.comparingInt(x -> x.getName().length())).orElse(null);
        System.out.println(userWithTheLongestName);


        System.out.println(firstActiveUser);
        List<Order> danhSachOrder = List.of(
                new Order(10000, true),
                new Order(20000, false),
                new Order(30000, true),
                new Order(40000, false)
        );

        double totalAmountPaid = danhSachOrder.stream().filter(Order::isPaid).mapToDouble(Order::getAmount).sum();
        System.out.println(totalAmountPaid);


    }
}
