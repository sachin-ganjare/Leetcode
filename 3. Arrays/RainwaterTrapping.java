
class RainwaterTrapping {

    static int trap(int[] height) {
        int water = 0;

        // for each bar, the maximum amt of water
        // is the min(its left max, and right max)
        // left max array
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];

        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // right max array
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];

        for (int i = rightMax.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // calculating the min of the two maximums
        for(int i = 0; i < height.length; i++) {
            water += Math.min(rightMax[i], leftMax[i]) - height[i];
        }

        return water;
    }

    public static void main(String args[]) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int answer = trap(height);
        System.out.println(answer);
    }
}
