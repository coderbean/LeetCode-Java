### [19\. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

Difficulty: **Medium**


Given a linked list, remove the _n_-th node from the end of list and return its head.

**Example:**

```
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
```

**Note:**

Given _n_ will always be valid.

**Follow up:**

Could you do this in one pass?


#### Solution

Language: **Java**

```java
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
​
        while (node1 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        node2.next = node2.next.next;
        return head;
    }
}
            node2 = node2.next;
```
![](https://ws3.sinaimg.cn/large/006tKfTcgy1g0ugblbxe4j310o0u0dk3.jpg)