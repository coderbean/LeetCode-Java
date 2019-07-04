package leetcode._22_;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        traceBack(result, "", n, n);
        return result;
    }

    private void traceBack(List<String> result, String curStr, int left, int rigth) {
        if (left == 0 && rigth == 0) {
            result.add(curStr);
            return;
        }
        if (left > rigth) { // 如果 剩余的 右括号比比左括号 少，说明 当前 str 的右括号多，无法匹配，不再递归
            return;
        }
        if (left >= 0) {
            traceBack(result, curStr + '(', left - 1, rigth);
        }
        if (rigth >= 0) {
            traceBack(result, curStr + ')', left, rigth - 1);
        }
    }
}