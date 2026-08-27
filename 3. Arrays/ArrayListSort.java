import java.util.ArrayList;
import java.util.Collections;

class ArrayListSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(1);
        list.add(9);

        System.out.println("Original list: " + list);
        Collections.sort(list);
        System.out.println("Sorted list: " + list);
        // Other Inbuilt sorting techniques:
        // Collections.reverse(list); // Reverse the list
        // Collections.shuffle(list); // Shuffle the list
    }
}
