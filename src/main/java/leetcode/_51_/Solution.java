package leetcode._51_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        LinkedList<Integer> column = new LinkedList<>();
        LinkedList<Integer> pie = new LinkedList<>();
        LinkedList<Integer> na = new LinkedList<>();
        this.DFS(column, pie, na,
                0, n, result, new ArrayList<>());
        return result;
    }

    private void DFS(LinkedList<Integer> column, LinkedList<Integer> pie, LinkedList<Integer> na,
                     int row, int n, List<List<String>> result, List<String> currStat) {
        if (row >= n) {
            result.add(currStat);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (column.contains(i) || pie.contains(i + row) || na.contains(row - i)) {
                continue;
            }
            // 记录皇后可以攻击的点
            column.add(i);
            pie.add(i + row);
            na.add(row - i);

            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    stringBuilder.append("Q");
                } else {
                    stringBuilder.append(".");
                }
            }
            this.DFS(column, pie, na, row + 1, n, result, new ArrayList<String>(currStat) {{
                add(stringBuilder.toString());
            }});
            // 移除，便于下一次回溯
            column.pollLast();
            pie.pollLast();
            na.pollLast();
            // currStat.remove(stringBuilder.toString());
        }
    }
}