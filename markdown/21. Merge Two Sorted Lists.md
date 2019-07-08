### [21\. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)

Difficulty: **Easy**


Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

**Example:**

```
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```


#### Solution

Language: **Java**

```java
​
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int headVal = 0;
        if (l1.val > l2.val) {
            headVal = l2.val;
            l2 = l2.next;
        } else {
            headVal = l1.val;
            l1 = l1.next;
        }
        ListNode head = new ListNode(headVal);
        ListNode index = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                index.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                index.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            index = index.next;
        }
        if (l1 != null) {
            index.next = l1;
        }
        if (l2 != null) {
            index.next = l2;
        }
        return head;
    }
}
```
![](https://ws4.sinaimg.cn/large/006tKfTcgy1g0ui2op9ucj31180scgpp.jpg)