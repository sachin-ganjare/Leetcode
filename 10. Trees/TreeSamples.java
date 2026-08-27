public class TreeSamples {

    /*
            8
          /   \
         5     10
        / \      \
       3   6      11
     */
    public static TreeNode sampleBST() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(11);
        return root;
    }

    /*
        0
       / \
      1   2
     */
    public static TreeNode sampleSmallTree() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        return root;
    }

    /*
    1
     \
      2
       \
        3
     */
    public static TreeNode sampleRightSkewedTree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        return root;
    }

    /*
            7
          /   \
         4     9
        / \
       2   5
     */
    public static TreeNode sampleNonBST() {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        return root;
    }

    /*
            6
          /   \
         3     8
        / \   / \
       1   4 7   9
     */
    public static TreeNode sampleBalancedBST() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        return root;
    }
}
