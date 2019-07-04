package leetcode._19_;

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node1 = head;
        ListNode node2 = head;
        // 由于题目中说到 n 永远有效，所以不做 nodeList 长度不足n的判断
        for (int i = 0; i < n; i++) {
            node1 = node1.next;
        }
        if (node1 == null) {
            return head.next;
        }
        node1 = node1.next;

        while (node1 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        node2.next = node2.next.next;
        return head;
    }
}