### [86\. Partition List](https://leetcode.com/problems/partition-list/)

Difficulty: **Medium**


Given a linked list and a value _x_, partition it such that all nodes less than _x_ come before nodes greater than or equal to _x_.

You should preserve the original relative order of the nodes in each of the two partitions.

**Example:**

```
Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fakeHeader = new ListNode(0);
        fakeHeader.next = head;
        ListNode curr = fakeHeader;
        ListNode cutPoint = null;
        while (curr.next != null) {
            if (curr.next.val >= x) {
                if (cutPoint == null) {
                    cutPoint = curr;
                }
                curr = curr.next;
            } else if (cutPoint != null) {
                ListNode node = curr.next;
                curr.next = node.next;
                node.next = cutPoint.next;
                cutPoint.next = node;
                cutPoint = node;
            } else {
                curr = curr.next;
            }
        }
        return fakeHeader.next;
    }
}
```
![pic](https://raw.githubusercontent.com/PicGoBed/PicBed/master/2019-08-01-ACf21S.jpg)