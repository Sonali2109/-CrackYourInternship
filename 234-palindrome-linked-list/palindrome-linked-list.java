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
    public boolean isPalindrome(ListNode head) 
    {
        ListNode slow = head;
        ListNode fast = head;

        // finds the middle element of LL
        while(fast != null && fast.next != null)    
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode t2 = reverseLLhelper(slow);    //reverse the LL starts from middle (to the end)
        ListNode t1 = head;

        //checks whether given LL is Palindrome or not!
        while(t2 != null)
        {
            if(t1.val != t2.val)    return false;   
            t1 = t1.next;
            t2 = t2.next;
        }

        return true;
    }

    static ListNode reverseLLhelper(ListNode head)
    {
        ListNode prev = head;
        ListNode cur = head.next;
        head.next = null;

        while(cur != null)
        {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}