import java.util.ArrayList;
import java.util.List;

public class HeapSort {

    // Sorts the list in ascending order using a max-heap
    public static void heapSort(ArrayList<Integer> list) {
        int n = list.size();

        // Build max-heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i);
        }

        // Repeatedly move max element to the end
        for (int end = n - 1; end > 0; end--) {
            int temp = list.get(0);
            list.set(0, list.get(end));
            list.set(end, temp);

            heapify(list, end, 0);
        }
    }

    // Maintain max-heap property for subtree rooted at i
    private static void heapify(ArrayList<Integer> list, int size, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && list.get(left) > list.get(largest)) {
            largest = left;
        }

        if (right < size && list.get(right) > list.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            int temp = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, temp);
            heapify(list, size, largest);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(5, 2, 4, 1, 3));

        System.out.println("Before Heap Sort: " + list);
        heapSort(list);
        System.out.println("After Heap Sort (Ascending): " + list);
    }
}
