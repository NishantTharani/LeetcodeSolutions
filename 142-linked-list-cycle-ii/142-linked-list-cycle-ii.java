/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Check if there is a cycle, if so our pointers meet at node V
        if (head == null)
            return null;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow)
                break;
        }
        
        if (fast == null || fast.next == null)
            return null;
        
        // Figure out how long the cycle is, say 'm'
        int m = 1;
        while (fast.next != slow) {
            fast = fast.next;
            m++;
        }
        
        // Start again from the beginning until our two nodes meet
        slow = head;
        fast = head;
        
        for (int i = 0; i < m; i++) {
            fast = fast.next;
        }
        
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}