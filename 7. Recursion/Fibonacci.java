class Fibonacci {
    static long fibonacci(int n) {
        // base case
        if(n == 0) {
            return 0;
        }
        
        if(n == 1) {
            return 1;
        }

        long first_num = fibonacci(n - 1);
        long second_num = fibonacci(n - 2);

        return first_num + second_num;
    }
    public static void main(String args[]) {
        System.out.println(fibonacci(8));
    }
}