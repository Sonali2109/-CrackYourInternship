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
	public ListNode deleteDuplicates(ListNode head) 
    {
		//You can code here
        ListNode orig = head;
        ListNode temp = head;
        ListNode newNode = null;
        
        while(orig != null)
        {
            while(orig.next != null && orig.val == orig.next.val)
            {
                orig = orig.next;
            }

            if(newNode == null) newNode = temp = orig;
            else
            {
                temp.next = orig;
                temp = orig;
            }

            orig = orig.next;
        }

        return newNode;     
    }
}