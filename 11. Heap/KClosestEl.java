import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class KClosestEl {
    static class Point implements Comparable<Point>{
        int value;
        int dist;

        Point(int value, int x) {
            this.value = value;
            this.dist = Math.abs(value - x);
        }

       @Override
        public int compareTo(Point p) {
            if (this.dist != p.dist) {
                return Integer.compare(this.dist, p.dist); // smaller distance first
            }
            return Integer.compare(this.value, p.value);   // smaller value first
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Priority Queue needs to be used
        PriorityQueue<Point> pq = new PriorityQueue<>();
       
       // add point and sort ascending according to distances.
        for(int i = 0; i < arr.length; i++) {
            pq.add(new Point(arr[i], x));
        }
       
        List<Integer> list = new ArrayList<>();
        
        // Remove k elements and add to the result list.
        for (int i = 0; i < k; i++) {
            list.add(pq.remove().value);
        }

        Collections.sort(list);
        return list;
    }
}