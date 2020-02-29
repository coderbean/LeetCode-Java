### [94\. Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)

Difficulty: **Medium**


Given a binary tree, return the _inorder_ traversal of its nodes' values.

**Example:**

```
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
```

**Follow up:** Recursive solution is trivial, could you do it iteratively?


#### Solution

Language: **Java**

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
​
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            // 一直向左，把所有节点压栈
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            // 压栈结束，元素出栈
            p = stack.pop();
            // 打印 value
            result.add(p.val);
            // 对右子树做同样的操作
            p = p.right;
        }
        return result;
    }
}
```
![LH5Tf6](https://cdn.jsdelivr.net/gh/PicGoBed/PicBed@master/uPic/LH5Tf6.png)