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
        String res = "";
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res = res + "n ";
            } else {
                res = res + node.val + " ";
            }
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        System.out.print(res);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        if (data.isEmpty()) {
            return null;
        }

        String[] nodeValues = data.split(" ");
        TreeNode node = new TreeNode(Integer.parseInt(nodeValues[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        
        for(int i = 1; i < nodeValues.length; i++) {
            TreeNode parentNode = queue.poll();
            if (!nodeValues[i].equals("n")) {
                parentNode.left = new TreeNode(Integer.parseInt(nodeValues[i]));
                queue.offer(parentNode.left);
            }
            if (!nodeValues[++i].equals("n")) {
                parentNode.right = new TreeNode(Integer.parseInt(nodeValues[i]));
                queue.offer(parentNode.right);
            }
        }
        return node;
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));