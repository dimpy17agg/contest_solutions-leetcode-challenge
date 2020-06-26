/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.
Find the total sum of all root-to-leaf numbers.
Note: A leaf is a node with no children.

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
*/

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
    public int sumNumbers(TreeNode root) {
        
        if(root==null)
            return 0;
        
   int res= sumRoot(root,0,0);      
        return res;
    }
    
    public int sumRoot(TreeNode node,int sum,int num){
        
        if(node==null)
            return sum;
        num=num*10+node.val;
        
        if(node.left==null && node.right==null){
            sum=sum+num;
            return sum;
        }
       sum= sumRoot(node.left,sum,num)+sumRoot(node.right,sum,num);
        return sum;
    }   
}


