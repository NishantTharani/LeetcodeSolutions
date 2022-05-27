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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode beforeStart = null;
        ListNode start = head;
        boolean possible = true;
        int i = 0;
        ListNode curr;
        ListNode prev;
        ListNode tmp;
        
        while (possible) {
            // Reverse k nodes starting from start, inclusive
            prev = beforeStart;
            curr = start;
            while (i < k) {
                tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
                i++;
            }
            
            // Tie the final two ends
            if (beforeStart != null) {
                beforeStart.next = prev;
            } else {
                head = prev;
            }
                
            start.next = curr;
            
            // Update the base pointers
            beforeStart = start;
            start = curr;
            
            // Check if k more nodes exist
            i = 0;
            while (curr != null && i <= k) {
                curr = curr.next;
                i++;
            }
            
            if (i < k)
                possible = false;
            
            i = 0;
        }
        
        return head;
    }
}