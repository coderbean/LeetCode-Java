package leetcode.common;

/**
 * Created by zhangbo54 on 2019-03-06.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode head = this;
        while (head != null) {
            sb.append(head.val).append("->");
            head = head.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}