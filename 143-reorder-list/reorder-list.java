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
public class Solution {
	public void reorderList(ListNode head) 
    {
	    if (head == null || head.next == null) {
            return;
        }
        
        // Step 1: Find the middle of the linked list using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Now slow is at the middle of the linked list
        ListNode secondHalf = slow.next;
        slow.next = null; // break the link between first and second half
        
        // Step 2: Reverse the second half of the linked list
        ListNode reversedSecondHalf = reverseList(secondHalf);
        
        // Step 3: Merge the two halves alternatively
        mergeLists(head, reversedSecondHalf);
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    private void mergeLists(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;
            
            l1.next = l2;
            l1 = l1Next;
            
            l2.next = l1;
            l2 = l2Next;
        }
    }
}