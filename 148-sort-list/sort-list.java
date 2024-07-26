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
        if (head == null || head.next == null) {
      return head;
    }

    int[] freq = new int[100001];

    ListNode handle = head;

    while (handle != null) {
      freq[handle.val + 50000]++;
      handle = handle.next;
    }

    handle = head;

    for (int i = 0; i < freq.length; i++) {
      while (freq[i] != 0) {
        handle.val = i - 50000;
        handle = handle.next;
        freq[i]--;
      }
    }

    return head;
    }
}