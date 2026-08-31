import java.util.List;

public class WordBreak {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        
        Node() {
            for(int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    static Node root = new Node();

    static void insert(String word) {
        Node curr = root;

        for(int level = 0; level < word.length(); level++) {
            // Find index
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        for(String str : wordDict) {
            insert(str);
        }
        return wordBreakHelper(s, 0);
    }

    private boolean wordBreakHelper(String key, int index) {
        if(index == key.length()) return true;

        Node ptr = root;
        for(int level = index; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if(ptr.children[idx] == null) {
                return false;
            }
            ptr = ptr.children[idx];
            if (ptr.eow) {
               // found a complete dictionary word
                if (wordBreakHelper(key, level + 1)) {
                    return true;
                };
            }
        }
        return false;
    }
}
