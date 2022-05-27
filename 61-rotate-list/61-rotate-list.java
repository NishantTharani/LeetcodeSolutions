/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;
        
        // First adjust by length of list
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            n++;
        }
        
        k = k % n;
        if (k == 0)
            return head;
        
        // K'th node (inclusive) from the end should become head
        // end's next should become current head
        // K+1'th node (inclusive) from end's next should become null
        
        curr = head;
        ListNode prev = head;
        
        while (k > 0) {
            curr = curr.next;
            k--;
        }
        
        while (curr.next != null) {
            curr = curr.next;
            prev = prev.next;
        }
        
        curr.next = head;
        head = prev.next;
        prev.next = null;
        
        return head;
        
        
    }
}