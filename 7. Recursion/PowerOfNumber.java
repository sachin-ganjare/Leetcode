class PowerOfNumber {
    static long power(int x, int n) {
        // base case
        if(n == 0) {
            return 1;
        }

        // calculate x^n
        return (x * power(x, n - 1));
    }

    // optimized version
      public static int optimizedPower(int x, int n) {
        if(n == 0) {
            return 1;
        }
        
        if(n % 2 == 0) { 
            //even
            return optimizedPower(x, n/2) * optimizedPower(x, n/2);
        } else { 
            //odd
            return x * optimizedPower(x, n/2) * optimizedPower(x, n/2);
        }
    }


    public static void main(String args[]){
        System.out.println(power(5, 4));
    }
}