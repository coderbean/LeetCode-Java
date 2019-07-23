package leetcode._51_;

import leetcode.common.Printer;

import java.util.List;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.solveNQueens(1);
        System.out.println(lists);
    }
}

