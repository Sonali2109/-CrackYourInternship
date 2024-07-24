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
    public ListNode removeNthFromEnd(ListNode A, int B) {
        if (A == null) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = A;
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Move second pointer B nodes ahead
        for (int i = 0; i <= B; i++) {
            if (second == null) {
                // B is greater than the length of the list, remove the head
                return A.next;
            }
            second = second.next;
        }
        
        // Move both pointers until second reaches the end
        while (second != null) {
            first = first.next;
            second = second.next;
        }
        
        // Remove the B-th node from the end
        first.next = first.next.next;
        
        return dummy.next;
    }
}