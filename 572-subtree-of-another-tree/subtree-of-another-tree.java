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

//           //////////////////ATISHAY\\\\\\\\\\\\\\\\           \\
//           \\\\\\\\\\\\\\\\\\\JAIN//////////////////           \\

class Solution {
    public boolean isidentical(TreeNode root, TreeNode subroot){
        if(root==null && subroot==null){
            return true;
        } else if(root==null || subroot==null || root.val!=subroot.val){
            return false;
        }
        if(!isidentical(root.left, subroot.left)){
            return false;
        }
        if(!isidentical(root.right, subroot.right)){
            return false;
        }
        return true;
    }
    public boolean subtree(TreeNode root, TreeNode subroot){
        if(root==null){
            return false;
        }

        if(root.val==subroot.val){
            if(isidentical(root, subroot)){
                return true;
            }
        }
        return subtree(root.left, subroot) || subtree(root.right, subroot);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return subtree(root, subRoot);
    }
}