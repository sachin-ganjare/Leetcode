class MaxSubArraySum {
    static int maxSubArray(int[] arr) {
        // initialise result with negative infinity
        int result = Integer.MIN_VALUE;

        // brute force approach - loop
        for(int i = 0; i < arr.length; i++) {
            int temp = 0;
            for(int j = i; j < arr.length; j++) {
                temp += arr[j];
                result = Math.max(result, temp);
            }
        }
        return result;
    }

    static int maxSubArrayKadane(int[] arr) {
        // initialise result with negative infinity
        int result = Integer.MIN_VALUE;
        int currentSum = 0;

        // loop through the array
        for(int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            result = Math.max(result, currentSum);
            if(currentSum < 0) {
                currentSum = 0;
            }
        }
        return result;
    }

    static int maximumSumSubarray(int arr[], int n) {
        // Initialize minimum
        // prefix sum to 0.
        int min_prefix_sum = 0;
        int res = Integer.MIN_VALUE;

        // the prefix sum array
        int prefix_sum[] = new int[n];
        prefix_sum[0] = arr[0];

        // for loop for calculating prefix sum array
        for (int i = 1; i < n; i++) {
            prefix_sum[i] = prefix_sum[i - 1] + arr[i];
        }

        // keep track of minimum prefix sum so far and maximum subarray sum.
        for (int i = 0; i < n; i++) {
            res = Math.max(res, prefix_sum[i] - min_prefix_sum);
            min_prefix_sum = Math.min(min_prefix_sum, prefix_sum[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;

        System.out.println("Brute Force: " + maxSubArray(arr));
        System.out.println("Kadane's Algo: " + maxSubArrayKadane(arr));
        System.out.println("Prefix Sum: " + maximumSumSubarray(arr, n));
    }
}
