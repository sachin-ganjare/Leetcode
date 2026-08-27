import java.util.*;

public class DivisorsOfNumber {

    // Static method to get divisors
    static List<Integer> getDivisors(int N) {

        List<Integer> res = new ArrayList<>();

        // Find divisors up to sqrt(N)
        for (int i = 1; i * i <= N; i++) {

            if (N % i == 0) {

                res.add(i);

                // Add paired divisor if different
                if (i != N / i) {
                    res.add(N / i);
                }
            }
        }

        // Sort divisors
        Collections.sort(res);

        return res;
    }

    public static void main(String[] args) {

        int N = 36;

        List<Integer> result = getDivisors(N);

        System.out.print("Divisors of " + N + ": ");

        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}