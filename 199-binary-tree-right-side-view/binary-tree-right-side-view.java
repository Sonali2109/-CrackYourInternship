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
    //Algo Used: Pre - order traversal. we can used any traversal over here, we are not using BFS bcz in that the SC can be halkf of N at times,
    // here the SC is O(Height) , TC: O N
    // In pre-order we do Ro-L-R but for printing right view we are doing Ro-R-L,
    // for printing left view we can use Ro-L-R

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        rightView(root, 0, ans);
        return ans;
    }

    public void rightView(TreeNode root, int level, List<Integer> ans){
        if(root == null){
            return;
        }

        if(level == ans.size()){    //level == ans.size(), this will ensure that we are adding the first element only of that level  from the right side in the list.
            ans.add(root.val);  // Ro
        }
        rightView(root.right, level+1, ans);  //R  
        rightView(root.left, level+1, ans);    //L
    }
}