class Solution {

    private void invertTreeHelper(TreeNode root)
    {
        
        // Base case: end recursive call if current node is null
         if (root == null) {
           return;
        }

        // We will do a post-order traversal of the binary tree.
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Let's swap the left and right nodes at current level
        if(root.left!=null){
           invertTree(root.left);
        }
        if(root.right!=null){
          invertTree(root.right);
        }
    
        
    }

    public TreeNode invertTree(TreeNode root) {
        
            invertTreeHelper(root);

            return root;
    }
}