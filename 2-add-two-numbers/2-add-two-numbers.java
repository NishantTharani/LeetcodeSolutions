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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        boolean carry = false;
        
        while (l1 != null && l2 != null) {
            curr.next = new ListNode();
            curr = curr.next;
            int val = l1.val + l2.val;
            if (carry)
                val++;
            curr.val = val % 10;
            carry = val >= 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        ListNode l = null;
        if (l1 != null) {
            l = l1;
        } else if (l2 != null) {
            l = l2;
        }
        
        while (l != null) {
            curr.next = new ListNode();
            curr = curr.next;
            int val = l.val;
            if (carry)
                val++;
            curr.val = val % 10;
            carry = val >= 10;
            l = l.next;
        }
        
        if (carry) {
            curr.next = new ListNode();
            curr.next.val = 1;
        }
        
        return head.next;
        
        
    }
}