import java.util.*;

class PushToBottom {

    static void reverseStack(Stack<Integer> s) {
        // base case
        if(s.isEmpty()) {
            return ;
        }
        // work to be done
        int top = s.pop();
        reverseStack(s);

        // backtrack
        pushToBottom(s, top);
    }


    static void pushToBottom(Stack<Integer> s, int val) {
        // base case
        if(s.isEmpty()) {
            s.push(val);
            return;
        }

        // work to be done
        int temp = s.pop();

        // recursion call
        pushToBottom(s, val);

        // backtracking case
        s.push(temp);
    }

    static void printStack(Stack<Integer> s) {
        for(int i: s) {
            System.out.print(i + " ");
        };
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(7);
        s.push(1);
        s.push(11);
        printStack(s);
        s.push(12);
        printStack(s);
        pushToBottom(s, 100);
        printStack(s);
        reverseStack(s);
        printStack(s);
    }
}