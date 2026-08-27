class MergeSort {
    static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }

    static int[] mergeSort(int[] arr, int si, int ei) {
        // Base case
        if (si == ei) {
            return new int[]{arr[si]};
        }
        int mid = si + (ei - si) / 2;
        int[] leftArr = mergeSort(arr, si, mid);
        int[] rightArr = mergeSort(arr, mid + 1, ei);
        return merge(leftArr, rightArr);
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
        int[] sortedArr = mergeSort(arr, 0, arr.length - 1);
        printArr(sortedArr);
    }
}