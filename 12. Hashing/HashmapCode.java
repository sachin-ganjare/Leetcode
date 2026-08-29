import java.util.ArrayList;
import java.util.LinkedList;

// Arrays in which LL are storred [][][]
// Buckets are arrays 
// in each bucket there is LinkedList (nodes).

public class HashmapCode {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // size
        private LinkedList<Node>[] buckets; // N
        private int N;

        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[N];
            // we have to initialize each el with empty LL.
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>(); // linkedList
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key); // bucket index
            int di = SearchInLL(key, bi); // data index

            if (di != -1) { // if key node is found, insert a new value into that Node. 
                Node node = buckets[bi].get(di);
                node.value = value;
            } else { // otherwise create and add new node into that bucket index.
                buckets[bi].add(new Node(key, value));
                n++;
            }
            // recalculate lambda and rehash if required.
            double lambda = (double) n / N; 
            if (lambda > 2.0) {
                rehash();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;    // spread of hc should be only till array length - N
        }

        // rehashing requires creating new bucket (array) list of twice size.
        private void rehash() {
            LinkedList<Node>[] oldBuck = buckets;
            
            // create and initialise new buckets
            buckets = new LinkedList[N * 2];
            N = 2 * N;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            // put old bucket's values in new buckketlist.
            n = 0;
            for (LinkedList<Node> ll : oldBuck) {
                for (Node node : ll) {
                    put(node.key, node.value);
                }
            }
        }

        // Search the node in current bucket bi.
        private int SearchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key.equals(key)) {
                    return di;  // return index of node found in bucket bi.
                } 
                di++;
            }
            return -1;
        }

        // containsKey check - recalculate bucket index and data index in LL
        public boolean containsKey (K key) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);
            if(di != -1) {
                // valid
                return true;
            }
            return false;
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);
            if(di != -1) {
                Node node = buckets[bi].get(di); // LinkedList Inbuilt fn
                return node.value;
            } else {
                return null;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);
            if(di != -1) {
                Node node = buckets[bi].remove(di); // LinkedList Inbuilt fn
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> key = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node n : ll) {
                    key.add(n.key);
                }
            }
            return key;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }
    // LinkedList & Buckets Implementation

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("India", 120);
        map.put("China", 150);
        map.put("US", 45);
        map.put("Indonesia", 80);
        map.put("Nepal", 30);

        System.out.println("Initial keys: " + map.keySet());
        System.out.println("India -> " + map.get("India"));
        System.out.println("US present? " + map.containsKey("US"));
        System.out.println("Japan present? " + map.containsKey("Japan"));

        System.out.println("Remove China -> " + map.remove("China"));
        System.out.println("China present after remove? " + map.containsKey("China"));
        System.out.println("Keys after remove: " + map.keySet());

        map.put("India", 125);
        System.out.println("Updated India -> " + map.get("India"));
        System.out.println("Map is empty? " + map.isEmpty());

    }
}
