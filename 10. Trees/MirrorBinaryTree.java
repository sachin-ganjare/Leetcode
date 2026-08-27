public class MirrorBinaryTree {

    static void mirrorBT(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorBT(root.left);
        mirrorBT(root.right);
    }

    static void printAll(TreeNode node) {
        if (node == null) {
            return;
        }
        printAll(node.left);
        System.out.print(node.data + "->");
        printAll(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeSamples.sampleBST();

        printAll(root);
        System.out.println();
        mirrorBT(root);
        printAll(root);
    }
}
