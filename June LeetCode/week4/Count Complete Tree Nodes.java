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
    public int countNodes(TreeNode root) {
        
       if (root == null) return 0;
        int lh = height(root.left), rh = height(root.right);
        if (lh == rh) {
            return 1 + (1 << lh) - 1 + countNodes(root.right);
        }else {
            return 1 + (1 << rh) - 1 + countNodes(root.left);
        }
    }
    
    private int height(TreeNode root) {
        int h = 0;
        while (root != null) {
            h++;
            root = root.left;
        }
        return h;
    }
}
