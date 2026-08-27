class Subsets {
    static void findSubsetsHelper(String str, int i, String ans) {
        // base case, when all string characters are traversed
        if(i == str.length()) {
            System.out.println(ans);
            return;
        }

        findSubsetsHelper(str, i + 1, ans + str.charAt(i)); // include the current character
        findSubsetsHelper(str, i + 1, ans); // skip the current character
    }

    static void findSubsets(String str) {
        findSubsetsHelper(str, 0, "");
    }

    public static void main(String args[]) {
        findSubsets("Hello");
    }
}