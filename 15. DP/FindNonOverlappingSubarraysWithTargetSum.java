// Leetcode 1477. Find two non-overalapping sub-arrays each with Target Sum.
class FindNonOverlappingSubarraysWithTargetSum {

    public static int minSumOfLengths(int[] arr, int target) {
        
        return -1;
    }
    public static void main(String[] args) {
        int test1[] = new int[] { 3, 2, 2, 4, 3 };
        int target1 = 3;
        int result1 = minSumOfLengths(test1, target1);
        // Output: 2

        int test2[] = new int[] { 7, 3, 4, 7 };
        int target2 = 3;
        int result2 = minSumOfLengths(test2, target2);
        // Output: 2

        int test3[] = new int[] { 4, 3, 2, 6, 2, 3, 4 };
        int target3 = 6;
        int result3 = minSumOfLengths(test3, target3);
        // Output: -1
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);


    }
}