import java.util.*;

class PrefixProblem {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();
    static ArrayList<String> words = new ArrayList<>();

    public static void insert(String word) {
        words.add(word);

        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }

            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static String[] prefixArr() {
        String[] ans = new String[words.size()];

        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            Node curr = root;
            StringBuilder prefix = new StringBuilder();

            for (int j = 0; j < word.length(); j++) {
                int idx = word.charAt(j) - 'a';
                curr = curr.children[idx];
                prefix.append(word.charAt(j));

                if (curr.freq == 1) {
                    break;
                }
            }

            ans[i] = prefix.toString();
        }

        return ans;
    }

    public static void main(String args[]) {
        String[] arr = {"zebra", "dog", "duck", "dove"};

        for (String s : arr) {
            insert(s);
        }

        String[] prefixes = prefixArr();

        for (String s : prefixes) {
            System.out.println(s);
        }
    }
}