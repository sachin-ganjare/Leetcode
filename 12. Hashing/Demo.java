import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Demo {

    public static void main(String args[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Insert
        hm.put(1, 10);
        hm.put(2, 20);
        hm.put(3, 30);
        hm.put(4, 40);
        hm.put(5, 50);

        // Update existing key
        hm.put(3, 300);

        System.out.println("HashMap after insert/update:");
        printMap(hm);

        // Access a value
        System.out.println("\nValue for key 4: " + hm.get(4));

        // Check if key/value exists
        System.out.println("Contains key 2? " + hm.containsKey(2));
        System.out.println("Contains value 100? " + hm.containsValue(100));

        // Remove an entry
        hm.remove(2);
        System.out.println("\nHashMap after removing key 2:");
        printMap(hm);

        // Traverse using different styles
        System.out.println("\nTraversal using foreach over keySet():");
        traverseWithForEach(hm);

        System.out.println("\nTraversal using Iterator over keySet():");
        traverseWithIterator(hm);

        System.out.println("\nTraversal using simple for loop over keySet():");
        traverseWithSimpleForLoop(hm);

        System.out.println("\nTraversal using entrySet():");
        traverseWithEntrySet(hm);

        // Example: frequency counting
        int[] arr = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        System.out.println("\nFrequency map:");
        printMap(freq);
    }

    private static void printMap(HashMap<Integer, Integer> hm) {
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // usually preferred
    private static void traverseWithForEach(HashMap<Integer, Integer> hm) {
        Set<Integer> keys = hm.keySet();
        for (Integer key : keys) {
            System.out.println("Key = " + key + ", Value = " + hm.get(key));
        }
    }

    private static void traverseWithIterator(HashMap<Integer, Integer> hm) {
        Iterator<Integer> it = hm.keySet().iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            System.out.println("Key = " + key + ", Value = " + hm.get(key));
        }
    }

    private static void traverseWithSimpleForLoop(HashMap<Integer, Integer> hm) {
        List<Integer> keys = new ArrayList<>(hm.keySet());
        for (int i = 0; i < keys.size(); i++) {
            Integer key = keys.get(i);
            System.out.println("Key = " + key + ", Value = " + hm.get(key));
        }
    }

    private static void traverseWithEntrySet(HashMap<Integer, Integer> hm) {
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }
}
