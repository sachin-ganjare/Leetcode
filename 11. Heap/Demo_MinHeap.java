import java.util.ArrayList;

public class Demo_MinHeap {
    
    // Insert a new element into the min-heap
    public static void insert(ArrayList<Integer> list, int data) {
        list.add(data);

        int child = list.size() - 1;
        while (child > 0) {
            int parent = (child - 1) / 2;

            if (list.get(child) < list.get(parent)) {
                // Swap child and parent
                int temp = list.get(child);
                list.set(child, list.get(parent));
                list.set(parent, temp);
                
                child = parent; // Move up
            } else {
                break;
            }
        }
    }

    // Remove and return the root (minimum element)
    public static int remove(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int minData = list.get(0);

        // Step 1: Swap root with last element
        int lastIdx = list.size() - 1;
        list.set(0, list.get(lastIdx));

        // Step 2: Remove last element
        list.remove(lastIdx);

        // Step 3: Heapify down from root
        if (!list.isEmpty()) {
            heapify(list, 0);
        }

        return minData;
    }

    // Maintain min-heap property from index i downwards
    private static void heapify(ArrayList<Integer> list, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int min = i;

        if (left < list.size() && list.get(left) < list.get(min)) {
            min = left;
        }

        if (right < list.size() && list.get(right) < list.get(min)) {
            min = right;
        }

        if (min != i) {
            // Swap i with the smaller child
            int temp = list.get(i);
            list.set(i, list.get(min));
            list.set(min, temp);

            // Recursively heapify affected sub-tree
            heapify(list, min);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> heap = new ArrayList<>();

        insert(heap, 5);
        insert(heap, 2);
        insert(heap, 4);
        insert(heap, 1);
        insert(heap, 3);

        System.out.println("Heap structure after inserts: " + heap);
        System.out.println("Removed min: " + remove(heap));
        System.out.println("Heap after removal: " + heap);
    }
}