### [83\. Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)

Difficulty: **Easy**


Given a sorted linked list, delete all duplicates such that each element appear only _once_.

**Example 1:**

```
Input: 1->1->2
Output: 1->2
```

**Example 2:**

```
Input: 1->1->2->3->3
Output: 1->2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        ListNode nextIndex = head;
        while (curr.next != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if (curr != nextIndex) {
                nextIndex.next = curr.next;
                nextIndex = curr;
            } else {
                curr = curr.next;
                nextIndex = nextIndex.next;
            }
        }
        return head;
    }
}
```
![pic](https://raw.githubusercontent.com/PicGoBed/PicBed/master/2019-07-30-5KXuLX.jpg)
