### [92\. Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/)

Difficulty: **Medium**


Reverse a linked list from position _m_ to _n_. Do it in one-pass.

**Note: **1 ≤ _m_ ≤ _n_ ≤ length of list.

**Example:**

```
Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
```


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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeNode = new ListNode(-1);
        fakeNode.next = head;
        ListNode p = fakeNode;
        ListNode q = head;
        int index = 1;
        while (q.next != null) {
            if (index >= m && index < n) {
                ListNode node = q.next;
                q.next = q.next.next;
                node.next = p.next;
                p.next = node;
            } else {
                q = q.next;
            }
            if (index < m) {
                p = p.next;
            }
            if (++index >= n) {
                break;
            }
        }
        return fakeNode.next;
    }
}
```
![pic](https://raw.githubusercontent.com/PicGoBed/PicBed/master/2019-08-14-nLuLW6.jpg)