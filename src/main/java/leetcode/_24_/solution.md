### [24\. Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)

Difficulty: **Medium**


Given a linked list, swap every two adjacent nodes and return its head.

You may **not** modify the values in the list's nodes, only nodes itself may be changed.

**Example:**

```
Given 1->2->3->4, you should return the list as 2->1->4->3.
```


#### Solution

Language: **Java**

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
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
​
        ListNode frontNode = head.next.next;
        ListNode backNode = head.next;
        while (frontNode != null && frontNode.next != null) {
            temp = frontNode.next;
            backNode.next = temp;
            frontNode.next = temp.next;
            temp.next = frontNode;
            backNode = backNode.next;
​
            frontNode = frontNode.next;
            backNode = backNode.next;
        }
        return head;
    }
}
```
![](https://ws1.sinaimg.cn/large/006tKfTcgy1g0vlzv7nsqj310m0nstbv.jpg)