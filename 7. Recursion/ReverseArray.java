class ReverseArray {
    static void revArray(int[] arr, int Idx) {
        if(Idx == arr.length/2) {
            return;
        }
        int temp = arr[Idx];
        arr[Idx] = arr[arr.length - Idx - 1];
        arr[arr.length - Idx - 1] = temp;
        revArray(arr, Idx + 1);
    }

    public static void main(String args[]) {
        int[] myArr = new int[] {10,22,155,144,1};

        revArray(myArr, 0);
        for(int i = 0; i < myArr.length; i++) {
            System.out.print(myArr[i] + " ");
        }
    }

}
