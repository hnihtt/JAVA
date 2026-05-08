package Stream.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /*
        B1:
        Cho danh sach List<String> gom cac cau tieng Anh. Chi duoc dung Stream API (cam dung vong lap for/while), thuc hien theo thu tu:
          1. Loc cac cau co nhieu hon 5 tu
          2. Voi moi cau, dem so tu duy nhat (distinct words, khong phan biet hoa thuong)
          3. Sap xep giam dan theo so tu duy nhat
          4. Chi lay top 3 ket qua
          5. Thu thap vao Map<String, Long> (key = cau goc, value = so tu duy nhat)
        In ket qua ra man hinh theo dinh dang ro rang
         */

        List<String> danhSach = List.of(
                "Vo Vinh Thinh",
                "Vo Vinh Thinh",
                "Vo Vinh Thinh",
                "Cong nghe thong tin",
                "abc abc abc",
                "xyz"
        );

        Map<String, Integer> result = danhSach.stream()
                .map(s -> Arrays.stream(s.split(" "))       //map tu item String cua danh sach qua String sau khi xu ly
                        .map(String::toLowerCase)
                        .distinct()
                        .collect(Collectors.joining(" "))
                )
                .collect(Collectors.toMap(s -> s, s -> s.split(" ").length, (oldK, newK) -> newK))      //collect thanh map
                .entrySet().stream()        //covert map qua stream tiep
                .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))     //sort
                .limit(3).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldK, newK) -> newK));
        System.out.println(result);

//        Map<String, Long> result = danhSach.stream().filter(s -> s.length() > 5).distinct().

        /*
        B2:
        Viet ham parseUser(String input) nhan chuoi dinh dang "name:age:email" va tra ve doi tuong User(String name, int age, String email).
        Tao lop UserParseException (checked exception) va nem ra khi:
          - Chuoi dau vao khong du 3 truong (tach bang dau hai cham)
          - Truong age khong phai so nguyen hop le
          - Email khong chua ky tu '@'
        Xu ly it nhat 3 chuoi dau vao: 1 hop le, 1 sai dinh dang, 1 sai tuoi.
         */

        List<String> users = List.of(
                "thinh:18:thinh@gmail.com",
                "thinh:thinh",
                "thinh:-1:t@gmail.com",
                "thinh:thinh:t@gmail.com",
                "thinh:18:t"
        );

        for (String user : users) {
            try {
                User createdUser = User.parseUser(user);
                System.out.println(createdUser);
            } catch (UserParseException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
