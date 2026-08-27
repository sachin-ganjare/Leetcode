class Palindrome {
    static boolean isPalindrome(String str){
        str = str.toLowerCase();

        for(int i = 0; i <str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - (i + 1))){
                return false;        
            }    
        }
        return true;
    }

    public static void main(String args[]){
        boolean result = isPalindrome("RACECAR");
        System.out.println(result);
    }
}