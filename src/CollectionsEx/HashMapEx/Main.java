package CollectionsEx.HashMapEx;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> sdMap = new HashMap<>();
        sdMap.put("a", 9);
        sdMap.put("b", 8);
        sdMap.put("c", 7);
        sdMap.put("d", 6);
        sdMap.put("e", 5);

//        for (Map.Entry<K, V> entry : map.entrySet())


        for (Map.Entry<String, Integer> entry : sdMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        String maxStudent = null;
        int maxScore = Integer.MIN_VALUE;

        String minStudent = null;
        int minScore = Integer.MAX_VALUE;


        for (Map.Entry<String, Integer> student : sdMap.entrySet()) {
            String name = student.getKey();
            int score = student.getValue();

            if (score > maxScore) {
                maxScore = score;
                maxStudent = name;
            }

            if (score < minScore) {
                minScore = score;
                minStudent = name;
            }
        }

        System.out.println("Max: " + maxStudent + " " + maxScore);
        System.out.println("Min: " + minStudent + " " + minScore);

        final int BONUS_POINT = 1;
        sdMap.put("a", sdMap.getOrDefault("a", 0) + BONUS_POINT);
        sdMap.put("t", sdMap.getOrDefault("t", 0) + BONUS_POINT);

        for (Map.Entry<String, Integer> entry : sdMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
