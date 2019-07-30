package leetcode._83_;

import leetcode.common.ListNode;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node31 = new ListNode(2);
        ListNode node32 = new ListNode(3);
        ListNode node41 = new ListNode(4);
        ListNode node42 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node31;
        node31.next = node32;
        node32.next = node41;
        node41.next = node42;
        node42.next = node5;


        System.out.println(solution.deleteDuplicates(node1));
    }
}

