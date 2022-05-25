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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode justBefore = null;
        ListNode start = head;
        
        while (left > 1) {
            justBefore = start;
            start = start.next;
            left--;
            right--;
        }
        
        // Now we are reversing 'start' and 'right-1' nodes following it
        ListNode prev = null;
        ListNode curr = start;
        ListNode tmp;
        
        while (right > 0) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
            right--;
        }
        
        // At the end, update justBefore.next and start.next
        start.next = curr;
        
        if (head != start) {
            justBefore.next = prev;
            return head;
        } else {
            return prev;
        }
        
        
    }
}