class InsertionSort {

    static int[] SortArray(int[] arr) {
      for(int i = 0; i < arr.length; i++) {
            int currNum = arr[i];
            int j = i - 1;
            // shift elements that are greater than currNum to right
            while(j >= 0 && currNum < arr[j]) {
                // shift elements to the right
                // create space for correct pos of currNum
                arr[j + 1] = arr[j];
                j--;
            }
            // swap the arr[i] and arr[j];
            arr[j + 1] = currNum;
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