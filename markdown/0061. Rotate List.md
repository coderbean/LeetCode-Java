### [61\. Rotate List](https://leetcode.com/problems/rotate-list/)

Difficulty: **Medium**


Given a linked list, rotate the list to the right by _k_ places, where _k_ is non-negative.

**Example 1:**

```
Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
```

**Example 2:**

```
Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL```


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
```
![](http://ww1.sinaimg.cn/large/006tNc79ly1g50orael7nj31b80qsaeq.jpg)