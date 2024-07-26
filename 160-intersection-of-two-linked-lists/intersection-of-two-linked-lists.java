/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode tempA = headA;
        ListNode tempB = headB;

        // Traverse both lists
        while (tempA != tempB) {
            // Move to the start of the other list when reaching the end
            tempA = (tempA == null) ? headB : tempA.next;
            tempB = (tempB == null) ? headA : tempB.next;
        }
        
        // Return the intersection node (or null if there is no intersection)
        return tempA;
    }
}