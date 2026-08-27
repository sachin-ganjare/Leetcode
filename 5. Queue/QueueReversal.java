import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;

public class QueueReversal {
    static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();

        while(!q.isEmpty()) {
            s.push(q.remove());
        }
        while(!s.isEmpty()) {
            q.add(s.pop());
        }
        
        System.out.println(q);
    }
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        Integer[] arr = new Integer[] {5,3,2};
        q1.addAll(Arrays.asList(arr));
        reverseQueue(q1);
    }
}
