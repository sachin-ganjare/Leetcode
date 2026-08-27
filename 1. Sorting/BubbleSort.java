class BubbleSort {

    static int[] SortArray(int[] arr) {
        // bubble the element and push to its correct position at the ending of array
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    static void printArr(int[] arr) {
        for(int element: arr){
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
          int[] arr = new int[] {1, 5, 4, 1, 15}; 
        printArr(arr);
        int[] sortedArr = SortArray(arr);
        printArr(sortedArr);
    }
}