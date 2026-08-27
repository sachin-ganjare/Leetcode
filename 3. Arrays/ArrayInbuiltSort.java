import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ArrayInbuiltSort {
	public static void main(String[] args) {
		int[] numbers = { 7, 3, 9, 1, 5, 2 };
		Integer[] boxedNumbers = { 7, 3, 9, 1, 5, 2 };
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(7, 3, 9, 1, 5, 2));
		List<String> names = new ArrayList<>(Arrays.asList("Zara", "Anil", "Mona", "Ravi"));

		System.out.println("Original int array: " + Arrays.toString(numbers));
		// Works only on arrays; primitive overload uses natural ascending order.
		Arrays.sort(numbers);
		System.out.println("Arrays.sort(int[]): " + Arrays.toString(numbers));

		System.out.println("Original Integer array: " + Arrays.toString(boxedNumbers));
		// Needs boxed types for reverseOrder(); still sorts the array in place.
		Arrays.sort(boxedNumbers, Collections.reverseOrder());
		System.out.println("Arrays.sort(Integer[], reverseOrder): " + Arrays.toString(boxedNumbers));

		int[] parallelNumbers = { 12, 4, 18, 6, 9, 1 };
		System.out.println("Original parallel array: " + Arrays.toString(parallelNumbers));
		// Parallel sort can help large arrays, but it adds overhead for small inputs.
		Arrays.parallelSort(parallelNumbers);
		System.out.println("Arrays.parallelSort(int[]): " + Arrays.toString(parallelNumbers));

		System.out.println("Original list: " + list);
		// List-only API; it mutates the list and uses the list's natural ordering.
		Collections.sort(list);
		System.out.println("Collections.sort(List): " + list);

		List<Integer> listSort = new ArrayList<>(Arrays.asList(11, 4, 8, 2, 15));
		System.out.println("Original list for List.sort: " + listSort);
		// Requires a Comparator for non-natural order; also sorts in place.
		listSort.sort(Integer::compareTo);
		System.out.println("List.sort(Comparator): " + listSort);

		System.out.println("Original names: " + names);
		// Case-insensitive ordering is string-specific; not a general sort rule.
		names.sort(String::compareToIgnoreCase);
		System.out.println("List.sort(String::compareToIgnoreCase): " + names);

		List<Integer> streamSorted = Arrays.asList(10, 2, 33, 25, 14);
		// Stream.sorted() returns a new sorted result; it does not change the source list.
		System.out.println("Stream sorted result: " + streamSorted.stream().sorted().toList());

		System.out.println();
		System.out.println("Note: Java does not provide a built-in 'binary sort' method. If you meant binary insertion sort, that is a custom algorithm, not an inbuilt API.");
	}
}
