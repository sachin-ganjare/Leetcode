public class LargestBST {

    static class BSTInfo {
        boolean isBST;
        int size;
        int max;
        int min;

        public BSTInfo(boolean isBST, int size, int max, int min) {
            this.isBST = isBST;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    static int maxBST = 0;

    static BSTInfo largestBST(TreeNode root) {
        if (root == null) {
            return new BSTInfo(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        BSTInfo leftInfo = largestBST(root.left);
        BSTInfo rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if (leftInfo.isBST && rightInfo.isBST && root.data > leftInfo.max && root.data < rightInfo.min) {
            maxBST = Math.max(maxBST, size);
            return new BSTInfo(true, size, max, min);
        }

        maxBST = Math.max(maxBST, Math.max(leftInfo.size, rightInfo.size));
        return new BSTInfo(false, size, max, min);
    }

    public static void main(String[] args) {
        TreeNode root = TreeSamples.sampleBalancedBST();
        BSTInfo info = largestBST(root);
        System.out.println("isBST: " + info.isBST);
        System.out.println("size: " + info.size);
        System.out.println("largestBSTSoFar: " + maxBST);
    }
}
