class QuickSort {
    // Function to perform quicksort
    public void quickSort(int[] arr, int low, int high) {
        // Base case
        if (low < high) {
            // Find pivot index
            int pivotIndex = partition(arr, low, high);

            // Sort left subarray
            quickSort(arr, low, pivotIndex - 1);

            // Sort right subarray
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Function to partition array
    private int partition(int[] arr, int low, int high) {
        // Choose last element as pivot
        int pivot = arr[high];

        // Initialize i
        int i = low - 1;

        // Traverse from low to high-1
        for (int j = low; j < high; j++) {
            // If element <= pivot
            if (arr[j] <= pivot) {
                // Increment i and swap
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Return pivot index
        return i + 1;
    }

    public static void main(String[] args) {
        // Input array
        int[] arr = {10, 7, 8, 9, 1, 5};

        // Create object
        QuickSort sol = new QuickSort();

        // Call quickSort
        sol.quickSort(arr, 0, arr.length - 1);

        // Print sorted array
        for (int num : arr)
            System.out.print(num + " ");
    }
}
