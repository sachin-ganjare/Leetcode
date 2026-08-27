public class SwapWithoutThirdVar {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        System.out.println("Before swapping: a = " + a + ", b = " + b);

        // Swapping without using a third variable
        a = a + b; // Step 1: Add both numbers and store in 'a'
        b = a - b; // Step 2: Subtract new 'b' from 'a' to get original 'a'
        a = a - b; // Step 3: Subtract new 'b' from new 'a' to get original 'b'

        System.out.println("After swapping: a = " + a + ", b = " + b);
    }
}
