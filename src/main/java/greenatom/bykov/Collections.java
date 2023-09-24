package greenatom.bykov;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class Collections {

    public static void main(String[] args) {
        try {
            writeToFile(listAnalysis(),Collections.class.getDeclaredMethod("listAnalysis"));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
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

    @WriteToFile(filename = "test.txt")
    public static List<String> listAnalysis() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        List<String> messages = new ArrayList<>();
        List<Collection<Integer>> collections =
                List.of(arrayList, linkedList, hashSet, treeSet);
        messages.addAll(additionAnalysis(collections));
        messages.addAll(containsAnalysis(collections));
        messages.addAll(removalAnalysis(collections));
        return messages;
    }

    private static List<String> removalAnalysis(List<Collection<Integer>> collections) {
        long start, end;
        List<String> messages = new ArrayList<>();
        for (Collection<Integer> collection : collections) {
            start = System.nanoTime();
            collection.remove(50000);
            end = System.nanoTime();
            String msg = collection.getClass().getSimpleName() +
                    " remove time: " + (end - start) + " ns";
            System.out.println(msg);
            messages.add(msg);
        }
        messages.add("-");
        return messages;
    }

    private static List<String> containsAnalysis(List<Collection<Integer>> collections) {
        long start, end;
        List<String> messages = new ArrayList<>();
        for (Collection<Integer> collection : collections) {
            start = System.nanoTime();
            collection.contains(50000);
            end = System.nanoTime();
            String msg = collection.getClass().getSimpleName() +
                    " contains time: " + (end - start) + " ns";
            System.out.println(msg);
            messages.add(msg);
        }
        messages.add("-");
        return messages;
    }

    private static List<String> additionAnalysis(List<Collection<Integer>> collections) {
        long start, end;
        List<String> messages = new ArrayList<>();
        for (Collection<Integer> collection : collections) {
            start = System.nanoTime();
            for (int i = 0; i < 100000; i++) {
                collection.add(i);
            }
            end = System.nanoTime();
            String msg = collection.getClass().getSimpleName() +
                    " add time: " + (end - start) + " ns";
            System.out.println(msg);
            messages.add(msg);
        }
        messages.add("-");
        return messages;
    }

    public static void writeToFile( List<String >messages, Method method) {
        if (method.isAnnotationPresent(WriteToFile.class)) {
            WriteToFile annotation = method.getAnnotation(WriteToFile.class);
            String path = annotation.filename();
            try (FileWriter writer = new FileWriter(path)) {
                for (String msg: messages
                     ) {
                    writer.write(msg+"\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


