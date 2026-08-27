class GCD {
    /*
    MORE EFFICIENT APPROACH IS EUCLIDIAN ALGORITHM;
    class GCD {
    static int gcd(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }

        return x;
    }

    public static void main(String args[]) {
        System.out.println(gcd(9, 12));
    }
} */
    static int gcd(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        int smaller = x < y ? x : y; // WISE WILL USE Math.min
        int result = 1;

        // BETTER APPROACH WOULD BE STARTING THE LOOP FROM smaller NUMBER INSTEAD OF 1.
        for (int i = 1; i <= smaller; i++) {
            if (x % i == 0 && y % i == 0) {
                result = i;
            }
        }

        return result;
    }

    public static void main(String args[]) {
        System.out.println(gcd(9, 12));
    }
}
