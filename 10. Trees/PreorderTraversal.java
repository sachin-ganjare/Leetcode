public class PreorderTraversal {

    static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeSamples.sampleBST();
        preorder(root);
    }
}
