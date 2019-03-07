package leetcode._21_;

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int headVal = 0;
        if (l1.val > l2.val) {
            headVal = l2.val;
            l2 = l2.next;
        } else {
            headVal = l1.val;
            l1 = l1.next;
        }
        ListNode head = new ListNode(headVal);
        ListNode index = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                index.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                index.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            index = index.next;
        }
        if (l1 != null) {
            index.next = l1;
        }
        if (l2 != null) {
            index.next = l2;
        }
        return head;
    }
}