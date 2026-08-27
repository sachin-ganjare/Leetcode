import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    static class Pair implements Comparable<Pair>{
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p) {
            return Integer.compare(p.val, this.val); // descending
        }
    }
    public static void main(String args[]) {
        int k = 3; // Windows
        int[] arr = new int[] {4, 2, 4, 1, 6, 7, 8};
        int[] res = new int[arr.length - k + 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // First Window
        for(int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        // Calculating Result
        res[0] = pq.peek().val;
        for(int i = k; i < arr.length; i++) {
            while(pq.size() > 0 && pq.peek().idx <= (i - k)) {
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));
            res[i - k + 1] = pq.peek().val;
        } 
        
        // Print Result
        for(int i : res) {
            System.out.print(i + " ");
        }
    }
}
