import java.util.ArrayList;

public class RootToLeafPaths {

    static void printRoot2Leaf(TreeNode root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);

        if (root.right == null && root.left == null) {
            System.out.println(path);
            path.remove(path.size() - 1);
            return;
        }

        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeSamples.sampleBST();
        printRoot2Leaf(root, new ArrayList<>());
    }
}
