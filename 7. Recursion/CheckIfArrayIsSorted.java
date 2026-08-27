    class CheckIfArrayIsSorted {
        static boolean isArraySorted(int[] arr, int i) {
                if(i == arr.length - 1){
                    return true;
                }
                if(arr[i] > arr[i+1]) {
                    return false;
                }

            return isArraySorted(arr,i+1);            
        }

        public static void main(String args[]){
                System.out.println(isArraySorted(new int[]{1, 3, 2}, 0));
        }
    }