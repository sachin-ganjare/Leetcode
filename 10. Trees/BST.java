import java.util.ArrayList;

public class BST {
    public static void main(String[] args) {
		TreeNode root = TreeSamples.sampleBST();

		RootToLeafPaths.printRoot2Leaf(root, new ArrayList<>());
		System.out.println(ValidateBST.validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
}
