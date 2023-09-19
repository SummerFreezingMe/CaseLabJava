package greenatom.bykov;

import java.util.*;

public class Collections {

    public static void main(String[] args) {
        listAnalysis();
        reverseMapDisplay();
    }

    private static void reverseMapDisplay() {
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
    public static void listAnalysis(){
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        List<Collection<Integer>> collections = List.of(arrayList,linkedList,hashSet,treeSet);
        additionAnalysis(collections);
        containsAnalysis(collections);
        removalAnalysis(collections);
    }

    private static void removalAnalysis(List<Collection<Integer>> collections) {
        long start,end;
        for (Collection<Integer> collection: collections) {
            start = System.nanoTime();
            collection.remove(50000);
            end = System.nanoTime();
            System.out.println(collection.getClass().getSimpleName()+
                    " add time: " + (end - start) + " ns");
        }
    }

    private static void containsAnalysis(List<Collection<Integer>> collections) {
        long start,end;
        for (Collection<Integer> collection: collections) {
            start = System.nanoTime();
          collection.contains(50000);
            end = System.nanoTime();
            System.out.println(collection.getClass().getSimpleName()+
                    " add time: " + (end - start) + " ns");
        }
    }

    private static void additionAnalysis(List<Collection<Integer>> collections) {
        long start,end;
        for (Collection<Integer> collection: collections) {
            start = System.nanoTime();
            for (int i = 0; i < 100000; i++) {
                collection.add(i);
            }
            end = System.nanoTime();
            System.out.println(collection.getClass().getSimpleName()+
                    " add time: " + (end - start) + " ns");
        }
    }
}


