package leetcode._92_;

import leetcode.common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeNode = new ListNode(-1);
        fakeNode.next = head;
        ListNode p = fakeNode;
        ListNode q = head;
        int index = 1;
        while (q.next != null) {
            if (index >= m && index < n) {
                ListNode node = q.next;
                q.next = q.next.next;
                node.next = p.next;
                p.next = node;
            } else {
                q = q.next;
            }
            if (index < m) {
                p = p.next;
            }
            if (++index >= n) {
                break;
            }
        }
        return fakeNode.next;
    }
}