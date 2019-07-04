package leetcode._24_;

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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = temp.next;
        temp.next = head;
        head = temp;

        ListNode frontNode = head.next.next;
        ListNode backNode = head.next;
        while (frontNode != null && frontNode.next != null) {
            temp = frontNode.next;
            backNode.next = temp;
            frontNode.next = temp.next;
            temp.next = frontNode;
            backNode = backNode.next;

            frontNode = frontNode.next;
            backNode = backNode.next;
        }
        return head;
    }
}