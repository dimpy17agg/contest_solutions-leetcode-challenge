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
    public static TreeNode invertTree(TreeNode root) {
          
        if(root==null)
            return root;
        
          invertTree(root.left);
        invertTree(root.right);
        
        TreeNode s=root.left;
        root.left=root.right;
        root.right=s;
        
        return root;
    }
}