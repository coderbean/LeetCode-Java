package leetcode._94_;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.common.TreeNode;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

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