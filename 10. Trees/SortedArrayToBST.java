public class SortedArrayToBST {

    static TreeNode createBST(int[] arr, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        TreeNode rootNode = new TreeNode(arr[mid]);
        rootNode.left = createBST(arr, st, mid - 1);
        rootNode.right = createBST(arr, mid + 1, end);
        return rootNode;
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
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = createBST(arr, 0, arr.length - 1);
        inorder(root);
    }
}
