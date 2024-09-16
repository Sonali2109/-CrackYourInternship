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
    List<Integer> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        TreeNode node  = root;
        helper(root);
        if (list.size() == 0) {
            return;
        }
        for (int i = 0;i<list.size()-1;i++) {
            root.val = list.get(i);
            root.right = new TreeNode();
            root.left = null;
            root = root.right;
        }
        root.val = list.get(list.size()-1);
        root = node;
    }
    public void helper (TreeNode root) {
        if (root == null) {return;}
        list.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}