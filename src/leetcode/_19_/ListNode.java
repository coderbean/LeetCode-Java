package leetcode._19_;

/**
 * Created by zhangbo54 on 2019-03-06.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
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