class Permutations {

    static void permuteString(String str, String ans) {
        // base case, when no characters are left to include from in str
        if(str.length() == 0) { 
            System.out.println(ans);
            return;
        }

        // // permutation starting from each ith character        
        // for(int i = 0; i < str.length(); i++) {
        //     char currentChar = str.charAt(i); // include ith character into the answer string
        //     String newStr = str.substring(0, i) + str.substring(i+1); // update passed string without current character
        //     permuteString(newStr, ans + currentChar); // 
        // }

        // permutation starting from each ith character        
        for(int i = 0; i < str.length(); i++) {
            permuteString(str.substring(0, i) + str.substring(i+1), ans + str.charAt(i)); // 
        }

    }

    public static void main(String[] args) {
        String str = "abc";
        permuteString(str, "");
    }
}