/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        
        if(node==null)
            return;
     
        ListNode ptr=node.next;
        node.val=ptr.val;
        node.next=ptr.next;
        
        
    }
}
