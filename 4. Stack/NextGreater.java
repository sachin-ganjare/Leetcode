import java.util.Stack;
class NextGreater{
    static int[] nextGreater(int[] arr) {
        int ng[] = new int[arr.length];
        Stack<Integer> s = new Stack<>(); // stack to store indices.

        for(int i = arr.length - 1; i > 0; i--) {
            // if there is element in stack and value at that index is lesser, then it can't be next greater
            if(!s.isEmpty() && arr[s.peek()] < arr[i]) {
                s.pop();
            }
            // if stack is empty
            if(s.isEmpty()) {
                ng[i] = -1;
            }
            // push element at last
            s.push(i);
        }
        return ng;
    }

    static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        int[] result = nextGreater(new int[] {2,5,4,6});
        printArray(result);
    }
}