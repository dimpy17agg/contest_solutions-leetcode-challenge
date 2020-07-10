/*
You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

Example 1:
Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
Output: [1,2,3,7,8,11,12,9,10,4,5,6]

*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
         
        Node node = head, next = null;
        while(node != null){
             
            if(node.child != null){ 
                // setting next to stack
                if(node.next != null){
                    next = node.next;
                    next.prev = null;
                    stack.push(next);  
                }                              
                // setting child to list
                node.next = node.child;
                node.next.prev = node;
                node.child = null;
            }
             
            if(node.next == null && stack.size() > 0){
                next = stack.pop();
                node.next = next;
                next.prev = node;                
            }            
            node = node.next;
        }        
        return head; 
    }
}
