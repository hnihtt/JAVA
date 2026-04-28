package CollectionsEx.HashSetEx;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<>(List.of(1,1,1,2,3,4,5,5,6,3,1));
        Set<Integer> integerSet1 = new HashSet<>(arrList);
        Set<Integer> integerSet2 = new HashSet<>();
        integerSet2.add(4);
        integerSet2.add(5);
        integerSet2.add(6);
        integerSet2.add(7);
        integerSet2.add(8);
        integerSet2.add(9);
        System.out.println(integerSet1);
        System.out.println(integerSet2);

        System.out.println();

        Set<Integer> backupSet = new HashSet<>(integerSet1);
        integerSet1.retainAll(integerSet2);
        System.out.println(backupSet);
        System.out.println(integerSet2);
        System.out.println("Giao: " + integerSet1);

        System.out.println();

        System.out.println(backupSet);
        System.out.println(integerSet2);
        backupSet.removeAll(integerSet2);
        System.out.println("Hieu: " + backupSet);
    }
}
