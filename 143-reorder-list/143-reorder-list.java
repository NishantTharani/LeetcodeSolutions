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
    public void reorderList(ListNode head) {
        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if (fast != null)
            slow = slow.next;
        
        // Reverse the second half
        ListNode end = null;
        ListNode tmp;
        while (slow != null) {
            tmp = slow.next;
            slow.next = end;
            end = slow;
            slow = tmp;
        }
        
        // Start from head and end, and mix the two halves together
        ListNode tmp2;
        while (end != null) {
            tmp = head.next;
            tmp2 = end.next;
            head.next = end;
            end.next = tmp;
            head = tmp;
            end = tmp2;
        }
        
        if (head != null)
            head.next = null;
    }
}



