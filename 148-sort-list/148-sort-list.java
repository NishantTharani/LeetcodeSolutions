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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        // Find the end of the first half
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast.next != null)
                fast = fast.next;
        }
        
        // Disconnect the first half
        ListNode secondHead = slow.next;
        slow.next = null;
        
        // Sort each half
        head = sortList(head);
        secondHead = sortList(secondHead);
        
        // Merge the two halves
        ListNode newHead = head;
        if (head.val <= secondHead.val) {
            newHead = head;
            head = head.next;
        }
        else {
            newHead = secondHead;
            secondHead = secondHead.next;
        }
            
        ListNode curr = newHead;
        while (head != null && secondHead != null) {
            if (head.val <= secondHead.val) {
                curr.next = head;
                curr = curr.next;
                head = head.next;
            } else {
                curr.next = secondHead;
                curr = curr.next;
                secondHead = secondHead.next;
            }
        }
        
        while (head != null) {
            curr.next = head;
            curr = curr.next;
            head = head.next;
        }
        
        while (secondHead != null) {
            curr.next = secondHead;
            curr = curr.next;
            secondHead = secondHead.next;
        }
        
        curr.next = null;
        
        return newHead;
        
        
        
        
    }
}