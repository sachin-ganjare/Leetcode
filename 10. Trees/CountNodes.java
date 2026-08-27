class CountNodes {
    static int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String args[]) {
        TreeNode root = TreeSamples.sampleSmallTree();
        System.out.println(countNodes(root));
    }
}
