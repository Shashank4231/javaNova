/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                res.append("n ");
                continue;
            }

            res.append(node.val).append(" ");
            q.add(node.left);
            q.add(node.right);
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())
            return null;

        String[] values = data.trim().split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < values.length) {
            TreeNode parent = q.poll();

            if (!values[i].equals("n")) {
                parent.left = new TreeNode(Integer.parseInt(values[i]));
                q.add(parent.left);
            }
            i++;

            if (i < values.length && !values[i].equals("n")) {
                parent.right = new TreeNode(Integer.parseInt(values[i]));
                q.add(parent.right);
            }
            i++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));