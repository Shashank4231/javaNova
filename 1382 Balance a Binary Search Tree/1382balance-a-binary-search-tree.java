/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private List<Integer> values = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        // Step 1: inorder traversal to get sorted values
        inorder(root);

        // Step 2: build balanced BST from sorted values
        return build(0, values.size() - 1);
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        values.add(node.val);
        inorder(node.right);
    }

    private TreeNode build(int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(values.get(mid));
        node.left = build(left, mid - 1);
        node.right = build(mid + 1, right);

        return node;
    }
}
