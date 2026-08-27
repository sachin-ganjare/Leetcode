public class ValidateBST {

    static boolean validateBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (!(root.data < max) || !(root.data > min)) {
            return false;
        }

        boolean leftResult = validateBST(root.left, min, root.data);
        boolean rightResult = validateBST(root.right, root.data, max);

        return leftResult && rightResult;
    }

    public static void main(String[] args) {
        TreeNode valid = TreeSamples.sampleBST();
        TreeNode invalid = TreeSamples.sampleNonBST();

        System.out.println(validateBST(valid, Long.MIN_VALUE, Long.MAX_VALUE));
        System.out.println(validateBST(invalid, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}
