import java.util.LinkedList;
import java.util.Queue;

class FirstNonRepeatingInCharacterStream {

   static void printNonRepeating(String str) {
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;
            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if(q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // First Non-Repeating Lettter in Stream of Letters
        System.out.println("Demo 1:");
        printNonRepeating("aabccxb");

        System.out.println("Demo 2:");
        printNonRepeating("aabc");

        System.out.println("Demo 3:");
        printNonRepeating("aabbcc");

        System.out.println("Demo 4:");
        printNonRepeating("abcdef");

        System.out.println("Demo 5:");
        printNonRepeating("aabbccddeeffgghhiijjklm");

        System.out.println("Demo 6:");
        printNonRepeating("abcabcabcxyz");

        System.out.println("Demo 7:");
        printNonRepeating("aabacbebebeccdd");
    }
}