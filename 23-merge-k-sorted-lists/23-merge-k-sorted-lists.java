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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        ListNode out = new ListNode();
        ListNode curr = out;
        
        PriorityQueue<Pair<Integer,Integer>> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.getKey(), p2.getKey()));
        
        for (int i = 0; i < n; i++) {
            if (lists[i] != null) {
                minHeap.add(new Pair<Integer,Integer>(lists[i].val, i));
                lists[i] = lists[i].next;
            }
        }
        
        while (!minHeap.isEmpty()) {
            Pair<Integer, Integer> min = minHeap.poll();
            
            curr.next = new ListNode();
            curr = curr.next;
            curr.val = min.getKey();
            
            int i = min.getValue();
            if (lists[i] != null) {
                minHeap.add(new Pair<Integer,Integer>(lists[i].val, i));
                lists[i] = lists[i].next;
            }
        }
        
        return out.next;
        
            
    }
}