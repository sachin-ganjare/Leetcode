class CountDigits {
    static int count_digits(int n) {
        if (n == 0) return 1;
        int result = 0;
        while (n != 0) {
            result++;
            n /= 10;
        }
        return result;
    }

    public static void main(String args[]) {
        int result = count_digits(12154);
        System.out.println(result);
    }
}