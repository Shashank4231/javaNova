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
class Solution {
    private int depth(TreeNode node) {
        if (node == null)
            return 0;

        if (node.left == null)
            return 1 + depth(node.right);

        if (node.right == null)
            return 1 + depth(node.left);

        return 1 + Math.min(depth(node.left), depth(node.right));
    }

    public int minDepth(TreeNode root) {
        return depth(root);
    }
}
