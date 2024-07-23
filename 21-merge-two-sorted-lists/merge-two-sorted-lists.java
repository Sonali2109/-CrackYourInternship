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
public class Solution
{
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        //You can code here
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while(l1 != null || l2 != null)
        {
            if(l2 == null || (l1 != null && l1.val <= l2.val))
            {
                cur.next = l1;
                l1 = l1.next;
            }
            else
            {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}