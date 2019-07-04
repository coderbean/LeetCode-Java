package leetcode._21_;

import leetcode.common.ListNode;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(4)));
        ListNode node2 = new ListNode(1).setNext(new ListNode(3).setNext(new ListNode(4)));
        System.out.println(solution.mergeTwoLists(node, node2));
    }
}

