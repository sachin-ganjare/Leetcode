class MergeSort {
    static void merge(int[] arr, int si, int mid, int ei) {
        int[] temp = new int[ei - si + 1];
        int i = si;       // Left half
        int j = mid + 1;  // Right half
        int k = 0;
        while (i <= mid && j <= ei) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }
        // Copy back to original array
        for (int x = 0; x < temp.length; x++) {
            arr[si + x] = temp[x];
        }
    }

    static void mergeSort(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    static void printArr(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 1, 15};
        printArr(arr);
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}