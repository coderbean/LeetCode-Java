package leetcode._86_;

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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fakeHeader = new ListNode(0);
        fakeHeader.next = head;
        ListNode curr = fakeHeader;
        ListNode cutPoint = null;
        while (curr.next != null) {
            if (curr.next.val >= x) {
                if (cutPoint == null) {
                    cutPoint = curr;
                }
                curr = curr.next;
            } else if (cutPoint != null) {
                ListNode node = curr.next;
                curr.next = node.next;
                node.next = cutPoint.next;
                cutPoint.next = node;
                cutPoint = node;
            } else {
                curr = curr.next;
            }
        }
        return fakeHeader.next;
    }
}