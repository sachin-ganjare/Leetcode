class ReverseDigits {
    static int reverse_digits(int num) {
        int res = 0;
        while (num != 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        if (res > (Integer.MAX_VALUE - res % 10) / 10) {
            return 0;
        }
        return res;
    }

    public static void main(String args[]) {
        System.out.println(reverse_digits(-543621));
    }
}