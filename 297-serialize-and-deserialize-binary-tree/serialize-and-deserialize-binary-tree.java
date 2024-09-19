/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec 
{
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder(); 
        preorder(root, sb);      
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;

        if(data == null || data.isEmpty())
        {
            return root; 
        }

        return des(0,data).getKey();
    }

    private Pair<TreeNode,Integer> des(int index, String data)
    {
        TreeNode node = new TreeNode();
        node.val = Integer.parseInt(data.substring(index, index+5));

        index = index+5; 

        if(index >= data.length())
        {
            return new Pair<>(node,index);
        }

        if(data.charAt(index) == '(')
        {
            index++; 
            if(data.charAt(index) == 'L')
            {
                Pair<TreeNode,Integer> res = des(index+1, data);
                node.left = res.getKey();
                index = res.getValue();
            }

            if(data.charAt(index) == 'R')
            {
                Pair<TreeNode,Integer> res = des(index+1, data);
                node.right = res.getKey();
                index = res.getValue();
            }

            // skip )
            return new Pair<>(node,index+1);
        }

        return new Pair<>(node, index);
    }

    private void preorder(TreeNode node, StringBuilder sb)
    {
        if(node == null)
        {
            return; 
        }

        if(node.val > 0)
        {
            sb.append("+");
        }
        else 
        {
            sb.append("-");
        }

        node.val = Math.abs(node.val);

        if(node.val < 1000 && node.val > 99)
        {
            sb.append("0");
        }

        else if(node.val <= 99 && node.val > 9)
        {
            sb.append("00");
        }

        else if(node.val <= 9)
        {
            sb.append("000");
        }

        sb.append(node.val);

        if(node.left != null || node.right != null)
        {
            sb.append("(");
        }

        if(node.left!=null)
        {
            sb.append("L");
            preorder(node.left, sb);
        }

        if(node.right != null)
        {
            sb.append("R");
            preorder(node.right, sb);
        }

        if(node.left != null || node.right != null)
        {
            sb.append(")");
        }

        return;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));