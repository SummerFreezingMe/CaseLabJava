package greenatom.bykov;

import java.util.*;

public class Collections {

    public static void main(String[] args) {
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("one", 1);
        originalMap.put("two", 2);
        originalMap.put("three", 3);
        Map<Integer, String> reversedMap = reverseMap(originalMap);
        System.out.println("Original Map: " + originalMap);
        System.out.println("Reversed Map: " + reversedMap);
    }

    public static <K, V> Map<V, K> reverseMap(Map<K, V> originalMap) {
    Map<V, K> reversedMap = new HashMap<>();
    for (Map.Entry<K, V> entry : originalMap.entrySet()) {
        reversedMap.put(entry.getValue(), entry.getKey());
    }
    return reversedMap;
}

}


