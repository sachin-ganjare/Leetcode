public class InorderTraversal {

    static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeSamples.sampleBST();
        inorder(root);
    }
}
