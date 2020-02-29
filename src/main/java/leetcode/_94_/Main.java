package leetcode._94_;

import leetcode.common.TreeNode;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        root.right = n2;
        n2.left = n3;
        System.out.println(solution.inorderTraversal(root));
    }
}

