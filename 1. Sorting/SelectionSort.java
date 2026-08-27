class SelectionSort {

    static int[] SortArray(int[] arr) {
        // select the minimum element recursively and move it to its sorted pos
        for(int i = 0; i < arr.length; i++) {
            int min = i;
            for(int j = i + 1; j < arr.length; j++) {
                // find min
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            // swap the min with ith pos.
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        };
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