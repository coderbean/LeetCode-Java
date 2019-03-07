package leetcode._19_;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        ListNode node = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(3).setNext(new ListNode(4).setNext(new ListNode(5)))));
        // ListNode node = new ListNode(1).setNext(new ListNode(2));
        Solution solution = new Solution();
        ListNode listNode = solution.removeNthFromEnd(node, 2);
        System.out.println(listNode.toString());
    }
}

