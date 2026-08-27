class PrimeNo {

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /* Finding factors will be having no different approach 
    class Factors {

    static void printFactors(int n) {

        for (int i = 1; i * i <= n; i++) {

            if (n % i == 0) {

                System.out.println(i);

                if (i != n / i) {
                    System.out.println(n / i);
                }
            }
        }
    }

    public static void main(String[] args) {
        printFactors(36);
    }
}
*/

    public static void main(String args[]) {
        System.out.println(isPrime(2));
    }
}