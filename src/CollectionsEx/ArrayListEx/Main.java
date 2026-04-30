package CollectionsEx.ArrayListEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> sdList = new ArrayList<>(List.of("a", "b", "c", "d", "e"));
        Collections.reverse(sdList);
        System.out.println(sdList);

        sdList.add(1, "new");
        sdList.remove(sdList.size()-1);
        System.out.println(sdList);

        Collections.sort(sdList);
        System.out.println(sdList.get(sdList.size()/2));
        System.out.println(sdList);

        if (sdList.contains("c")) {
            System.out.println("c at: " + sdList.indexOf("c"));
        } else {
            System.out.println("Khong co c");
        }
    }
}
