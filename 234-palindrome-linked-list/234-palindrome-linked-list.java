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
    public boolean isPalindrome(ListNode head) {
        // Find the middle node
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // If we have an odd number of nodes, move to one after the middle one
        if (fast != null) {
            slow = slow.next;
        }
        
        // Reverse from slow to the end
        ListNode prev = null;
        ListNode tmp;
        while (slow != null) {
            tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }
        
        // Check for equality - starting with 'prev' and head
        while (prev != null) {
            if (prev.val != head.val)
                return false;
            prev = prev.next;
            head = head.next;
        }
        
        return true;
    }
}