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
    public ListNode reverseBetween(ListNode head, int M, int N) {
        if (head == null || M == N) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevM = dummy;
        
        // Move prevM to the node just before M
        for (int i = 1; i < M; i++) {
            prevM = prevM.next;
        }
        
        // Start reversal from node at M
        ListNode current = prevM.next;
        ListNode start = current;
        ListNode prev = null;
        
        // Reverse the nodes from M to N
        for (int i = M; i <= N; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        // prev is now the new head of the reversed segment
        prevM.next = prev;
        start.next = current; // Connect the end of reversed segment to N+1 node
        
        return dummy.next;
    }
}