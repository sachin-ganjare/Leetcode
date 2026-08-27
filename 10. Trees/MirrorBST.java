public class MirrorBST {

    static TreeNode mirrorBST(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode leftMirror = mirrorBST(node.left);
        TreeNode rightMirror = mirrorBST(node.right);
        node.left = rightMirror;
        node.right = leftMirror;
        return node;
    }

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
        System.out.println();
        mirrorBST(root);
        inorder(root);
    }
}
