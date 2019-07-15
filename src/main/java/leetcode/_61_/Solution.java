package leetcode._61_;

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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 0;
        ListNode index = head;
        while (index.next != null) {
            length++;
            index = index.next;
        }
        length++;
        index.next = head; // 构建成循环链表，index 指向 head 的前一个节点
        k = k % length;
        for (int i = 0; i < length - k; i++) {
            index = head;
            head = head.next;
        }
        index.next = null; // 破除循环链表，添加结束 null 值
        return head;
    }
}