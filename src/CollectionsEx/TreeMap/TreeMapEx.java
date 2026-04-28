package CollectionsEx.TreeMap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapEx {
    public static void main(String[] args) {
        String text = "Loremipsumdolorsitamet";
        Map<Character, Integer> textMap = new HashMap<>();
        char[] chars =  text.toCharArray();
        for (char c : chars) {
            textMap.put(c, textMap.getOrDefault(c, 0) + 1);
        }

        System.out.println(textMap);

        TreeMap<Character, Integer> sortedMap = new TreeMap<>(textMap);
        System.out.println(sortedMap);

        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastKey());
    }
}
